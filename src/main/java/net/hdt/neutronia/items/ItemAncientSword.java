package net.hdt.neutronia.items;

import net.hdt.neutronia.Main;
import net.hdt.neutronia.items.base.tools.BaseSword;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAncientSword extends BaseSword {

    private static Item.ToolMaterial ancientToolMaterial = EnumHelper.addToolMaterial("egyptian", 1, 131, 8.0F, 3.5F, 22);

    public ItemAncientSword() {
        super("khopesh", ancientToolMaterial);
        setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GOLD + String.format(TextFormatting.ITALIC + "This is a khopesh from the old egyptian times. It was only used by the pharaohs best guards"));
    }

}