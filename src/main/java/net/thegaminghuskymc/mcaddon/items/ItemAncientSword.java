package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.thegaminghuskymc.huskylib2.items.ItemModSword;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;

import javax.annotation.Nullable;
import java.util.List;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class ItemAncientSword extends ItemModSword {

    private static Item.ToolMaterial ancientToolMaterial = EnumHelper.addToolMaterial("egyptian", 1, 131, 8.0F, 3.5F, 22);

    public ItemAncientSword() {
        super("khopesh", MOD_ID, ancientToolMaterial);
        setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GOLD + String.format(TextFormatting.ITALIC + "This is a khopesh from the old egyptian times. It was only used by the pharaohs best guards"));
    }
}