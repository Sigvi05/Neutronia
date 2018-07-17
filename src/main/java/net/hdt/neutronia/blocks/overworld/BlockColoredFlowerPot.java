package net.hdt.neutronia.blocks.overworld;

import net.hdt.huskylib2.interf.IBlockColorProvider;
import net.hdt.huskylib2.interf.IModBlock;
import net.hdt.huskylib2.interf.IRecipeGrouped;
import net.hdt.huskylib2.items.blocks.ItemModBlock;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockColoredFlowerPot extends BlockFlowerPot implements IModBlock, IBlockColorProvider, IRecipeGrouped {

    private final String[] variants;
    private final String bareName;

    public BlockColoredFlowerPot(EnumDyeColor color) {
        String name = color.getName() + "_terracotta_flowerpot";
        variants = new String[]{name};
        bareName = name;

        setHardness(0.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.DECORATIONS);

        setTranslationKey(name);
    }

    @Override
    public Block setTranslationKey(String name) {
        super.setTranslationKey(name);
        setRegistryName(MOD_ID, name);
        ProxyRegistry.register(this);
        ProxyRegistry.register(new ItemModBlock(this, new ResourceLocation(MOD_ID, name)));
        return this;
    }

    @Override
    public String getModNamespace() {
        return MOD_ID;
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        ItemStack stack = super.getItem(worldIn, pos, state);
        if (stack.getItem() == Items.FLOWER_POT)
            stack = new ItemStack(Item.getItemFromBlock(this));

        return stack;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(getTranslationKey() + ".name");
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[]{LEGACY_DATA};
    }

    @Override
    public IProperty getVariantProp() {
        return null;
    }

    @Override
    public Class getVariantEnum() {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IItemColor getItemColor() {
        return (stack, i) -> 0xFFFFFF;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IBlockColor getBlockColor() {
        return (state, world, pos, i) -> Minecraft.getMinecraft().getBlockColors().colorMultiplier(Blocks.FLOWER_POT.getDefaultState(), world, pos, i);
    }

    @Override
    public String getRecipeGroup() {
        return "terracotta_flower_pot";
    }

}