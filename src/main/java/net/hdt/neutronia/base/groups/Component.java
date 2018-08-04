package net.hdt.neutronia.base.groups;

import net.hdt.neutronia.base.lib.LibMisc;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.text.WordUtils;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class Component implements Comparable<Component> {

	public Group group;
	
	boolean loadtimeDone;
	boolean enabledAtLoadtime;
	
	public boolean enabledByDefault;
	public boolean enabled;
	boolean prevEnabled;
	public String configCategory;
	String configName;
	private String iconFile = "";
	private ResourceLocation icon;
	public Property prop;
	
	boolean forceLoad;

    public Component() {
    }

    public Component(Builder builder) {

	}

	final void setupConstantConfig() {
		String[] incompat = getIncompatibleMods();
		if(incompat != null && incompat.length > 0) {
			StringBuilder desc = new StringBuilder("This component disables itself if any of the following mods are loaded: \n");
			for(String s : incompat)
				desc.append(" - ").append(s).append("\n");
			desc.append("This is done to prevent content overlap.\nYou can turn this on to force the component to be loaded even if the above mods are also loaded.");
				
			ConfigHelper.needsRestart = true;
			forceLoad = loadPropBool("Force Enabled", desc.toString(), false);
		}
	}
	
	public void setupConfig() {
		// NO-OP
	}

	public void onEnabled() {
		// NO-OP
	}
	
	public void onDisabled() {
		// NO-OP
	}
	
	public void preInit(FMLPreInitializationEvent event) {
		// NO-OP
	}
	
	public void postPreInit(FMLPreInitializationEvent event) {
		// NO-OP
	}

	public void init(FMLInitializationEvent event) {
		// NO-OP
	}

	public void postInit(FMLPostInitializationEvent event) {
		// NO-OP
	}
	
	public void finalInit(FMLPostInitializationEvent event) {
		// NO-OP
	}

	@SideOnly(Side.CLIENT)
	public void preInitClient(FMLPreInitializationEvent event) {
		// NO-OP
	}

	@SideOnly(Side.CLIENT)
	public void initClient(FMLInitializationEvent event) {
		// NO-OP
	}

	@SideOnly(Side.CLIENT)
	public void postInitClient(FMLPostInitializationEvent event) {
		// NO-OP
	}

	void serverStarting(FMLServerStartingEvent event) {
		// NO-OP
	}
	
	public String[] getIncompatibleMods() {
		return null;
	}

	public boolean hasSubscriptions() {
		return false;
	}

	public boolean hasTerrainSubscriptions() {
		return false;
	}

	public boolean hasOreGenSubscriptions() {
		return false;
	}

	public String getFeatureDescription() {
		return "";
	}
	
	public String getComponentIngameConfigName() {
		return WordUtils.capitalizeFully(configName);
	}
	
	public boolean requiresMinecraftRestartToEnable() {
		return false;
	}

	public static void registerTile(Class<? extends TileEntity> clazz, String key) {
		GameRegistry.registerTileEntity(clazz, new ResourceLocation(LibMisc.PREFIX_MOD + key));
	}

	public final boolean isClient() {
		return FMLCommonHandler.instance().getSide().isClient();
	}

	protected final int loadPropInt(String propName, String desc, int default_) {
		return ConfigHelper.loadPropInt(propName, configCategory, desc, default_);
	}

	public final double loadPropDouble(String propName, String desc, double default_) {
		return ConfigHelper.loadPropDouble(propName, configCategory, desc, default_);
	}

	public final boolean loadPropBool(String propName, String desc, boolean default_) {
		return ConfigHelper.loadPropBool(propName, configCategory, desc, default_);
	}

	public final String loadPropString(String propName, String desc, String default_) {
		return ConfigHelper.loadPropString(propName, configCategory, desc, default_);
	}

	public final String[] loadPropStringList(String propName, String desc, String[] default_) {
		return ConfigHelper.loadPropStringList(propName, configCategory, desc, default_);
	}

	@Override
	public int compareTo(Component o) {
		return configName.compareTo(o.configName);
	}

    public void setIconFile(String iconFile) {
        this.iconFile = iconFile;
    }

    public ResourceLocation getIcon() {
        if (icon != null) {
            return icon;
        }
        if (iconFile == null || iconFile.isEmpty()) {
            return null;
        }
        icon = new ResourceLocation(MOD_ID, iconFile);
        return icon;
    }

	public static class Builder {

		private String name, desc;
		private ItemStack icon;
		private Component component;

		public Builder(Component component) {
			this.component = component;
		}

		public Component.Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Component.Builder withDesc(String desc) {
			this.desc = desc;
			return this;
		}

		public Component.Builder withIcon(ItemStack icon) {
			this.icon = icon;
			return this;
		}

		public Component register() {
			return new Component(this);
		}

	}

}
