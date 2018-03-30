package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.huskylib2.items.ItemModSword;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class ItemAncientSword extends ItemModSword {

    public static Item.ToolMaterial ancientToolMaterial = EnumHelper.addToolMaterial("ANCIENT", 1, 131, 8.0F, 3.5F, 22);

    public ItemAncientSword() {
        super("ancient_sword", MOD_ID, ancientToolMaterial);
        setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

}
