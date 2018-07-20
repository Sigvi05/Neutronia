package net.hdt.neutronia.modules.colorful_armor_points.features;

import com.google.gson.Gson;
import net.hdt.neutronia.base.NeutroniaMain;
import net.hdt.neutronia.base.module.Feature;
import net.hdt.neutronia.base.module.ModuleLoader;
import net.hdt.neutronia.modules.colorful_armor_points.GuiArmor;
import net.hdt.neutronia.modules.colorful_armor_points.config.IconData;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class ColoredArmorPoints extends Feature {

    /** Default armor icon Y position */
    public static int iconDefault;
    /** Flag to render glint on enchanted pieces */
    public static boolean renderGlint;
    /** Flag to compress the bar into different colored borders */
    public static boolean compressBar;

    /** Information from icons.json */
    private static IconData iconData;

    private static final GuiArmor GUI = new GuiArmor();

    @Override
    public void setupConfig() {
        iconDefault = loadPropInt("iconDefault", "Default icon index", 2);
        renderGlint = loadPropBool("renderGlint", "Display enchanted shine", true);
        compressBar = loadPropBool("compressBar", "Compress the bar into different colored borders when your armor exceeds 20", false);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        // Load icon data and overrides
        try {
            iconData = getIconData();
        } catch(IOException e) {
            NeutroniaMain.LOGGER.error("An error occurred loading icon data");
            e.printStackTrace();
        }
        if(ModuleLoader.config.hasChanged()) ModuleLoader.config.save();
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Pre e) {
        if(e.getType() == RenderGameOverlayEvent.ElementType.ARMOR) {
            e.setCanceled(true); // Don't want anything else rendering on top
            GUI.draw(e.getResolution().getScaledWidth(), e.getResolution().getScaledHeight());
        }
    }

    @SubscribeEvent
    public void onRenderTooltip(ItemTooltipEvent e) {
        if(e.getFlags().isAdvanced() && e.getItemStack().getItem() instanceof ItemArmor) {
            final String material = ((ItemArmor)e.getItemStack().getItem()).getArmorMaterial().getName();
            e.getToolTip().add(TextFormatting.DARK_GRAY + "Armor Material: " + material);
        }
    }

    /** Returns the icon index of the given {@link ItemStack}.
     * @param stack The item stack to look up
     * @return The icon index found, or {@link #iconDefault} if none was found. */
    public static int getIcon(ItemStack stack) {
        return iconData.getIcon(stack);
    }

    /** Reads (and copies, if necessary) icons.json to load icon information.
     * @return The resultant icon data from file */
    private IconData getIconData() throws IOException {
        // Default icons
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/assets/neutronia_armor_points/icons.json")));
        IconData data = new Gson().fromJson(reader, IconData.class);
        reader.close();

        // Combine default with overrides
        File overrides = new File("Neutronia: Armor Points", "icons.json");

        if(overrides.exists()) {
            reader = new BufferedReader(new FileReader(overrides));
            IconData dataOverrides = new Gson().fromJson(reader, IconData.class);
            reader.close();

            data.putAll(dataOverrides);
        } else {
            // First run, or file has been deleted
            NeutroniaMain.LOGGER.warn(overrides.getAbsolutePath() + " did not exist. Loading defaults");
            FileUtils.copyURLToFile(getClass().getResource("/assets/neutronia_armor_points/overrides.json"), overrides);
        }
        return data;
    }

}
