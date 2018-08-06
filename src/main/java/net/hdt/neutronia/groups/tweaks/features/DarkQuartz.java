package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.groups.Component;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DarkQuartz extends Component {

    @Override
    public String getFeatureDescription() {
        return "Makes Nether Quartz a dark material to give it a more hellish feel, as well as make it more unique from Whitestone";
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        overrideBlock("quartz_ore");
        overrideBlock("quartz_block_bottom");
        overrideBlock("quartz_block_top");
        overrideBlock("quartz_block_side");
        overrideBlock("quartz_block_chiseled_top");
        overrideBlock("quartz_block_chiseled");
        overrideBlock("quartz_block_lines_top");
        overrideBlock("quartz_block_lines");
        overrideItem("quartz");
    }


    @Override
    public boolean requiresMinecraftRestartToEnable() {
        return true;
    }

}
