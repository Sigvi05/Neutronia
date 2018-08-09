package net.hdt.neutronia.groups.client.features;

import net.hdt.huskylib2.util.ModelHandler;
import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LessIntrusiveShields extends Component {

	@Override
	@SideOnly(Side.CLIENT)
	public void preInitClient(FMLPreInitializationEvent event) {
		ModelHandler.registerModels(Items.SHIELD, LibMisc.PREFIX_MOD, new String[] { "shield_override" }, null, true);
		ModelLoader.setCustomMeshDefinition(Items.SHIELD, stack -> new ModelResourceLocation("neutronia:shield_override", "inventory"));
	}

	@Override
	public boolean requiresMinecraftRestartToEnable() {
		return true;
	}
	
}
