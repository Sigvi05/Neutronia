package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.util.Reference;
import net.thegaminghuskymc.mcaddon.items.base.tools.BaseSword;

public class ItemAncientSword extends BaseSword {

    public static Item.ToolMaterial ancientToolMaterial = EnumHelper.addToolMaterial("ANCIENT", 1, 131, 8.0F, 3.5F, 22);

    public ItemAncientSword() {
        super("ancient_sword", Reference.MOD_ID, ancientToolMaterial);
        setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

}
