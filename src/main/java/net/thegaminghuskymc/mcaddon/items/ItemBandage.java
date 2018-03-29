package net.thegaminghuskymc.mcaddon.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.thegaminghuskymc.huskylib2.items.ItemMod;
import net.thegaminghuskymc.mcaddon.HuskysMinecraftAdditions;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class ItemBandage extends ItemMod {

    public ItemBandage() {
        super("bandage", Reference.MOD_ID);
        this.setCreativeTab(HuskysMinecraftAdditions.OVERWORLD_EXPANSION_TAB);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (playerIn.getHealth() < playerIn.getMaxHealth() && worldIn.isRemote && playerIn.getHeldItem(handIn).getItem() == this) {
            float f = playerIn.getHealth();
            playerIn.setHealth(f + 1.0F);
            playerIn.getHeldItem(handIn).shrink(1);
            return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
        }
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
