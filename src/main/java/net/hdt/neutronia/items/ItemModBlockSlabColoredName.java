package net.hdt.neutronia.items;

import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.huskylib2.interf.IVariantHolder;
import net.hdt.huskylib2.items.ItemMod;
import net.hdt.neutronia.blocks.base.BlockModSlab;
import net.hdt.neutronia.util.WearableColourUtils;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemModBlockSlabColoredName extends ItemSlab implements IVariantHolder {

    private IModBlock modBlock;
    private EnumDyeColor dyeColor;

    public ItemModBlockSlabColoredName(BlockModSlab block, ResourceLocation res, EnumDyeColor dyeColor) {
        super(block, block.getSingleBlock(), block.getFullBlock());
        modBlock = block;

        ItemMod.variantHolders.add(this);
        if(getVariants().length > 1)
            setHasSubtypes(true);
        setRegistryName(res);
        this.dyeColor = dyeColor;
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public ItemBlock setUnlocalizedName(String par1Str) {
        return (ItemBlock) super.setUnlocalizedName(par1Str);
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int dmg = par1ItemStack.getItemDamage();
        String[] variants = getVariants();

        String name;
        if(dmg >= variants.length)
            name = modBlock.getBareName();
        else name = variants[dmg];

        return "tile." + name;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return WearableColourUtils.getClosest(dyeColor.getColorValue()) + super.getItemStackDisplayName(stack);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        String[] variants = getVariants();
        if(isInCreativeTab(tab))
            for(int i = 0; i < variants.length; i++)
                subItems.add(new ItemStack(this, 1, i));
    }

    @Override
    public String[] getVariants() {
        return modBlock.getVariants();
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition() {
        return modBlock.getCustomMeshDefinition();
    }

    @Override
    public String getModNamespace() {
        return modBlock.getModNamespace();
    }

}