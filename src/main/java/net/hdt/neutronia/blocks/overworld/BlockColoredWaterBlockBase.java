package net.hdt.neutronia.blocks.overworld;

import net.hdt.neutronia.blocks.test.BlockMod;
import net.hdt.neutronia.init.NCreativeTabs;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.hdt.neutronia.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.List;

public class BlockColoredWaterBlockBase extends BlockMod {

    private final EnumCoralColor color;

    public BlockColoredWaterBlockBase(EnumCoralColor colorIn, String name) {
        super(BlockMod.Builder.of(Material.CORAL), Reference.MOD_ID, colorIn + "_" + name);
        this.color = colorIn;
        this.setCreativeTab(NCreativeTabs.OCEAN_EXPANSION_TAB);
    }

    @SideOnly(Side.CLIENT)
    public static EnumCoralColor getColorFromItem(Item itemIn) {
        return getColorFromBlock(Block.getBlockFromItem(itemIn));
    }

    @SideOnly(Side.CLIENT)
    private static EnumCoralColor getColorFromBlock(Block blockIn) {
        return blockIn instanceof BlockColoredWaterBlockBase ? ((BlockColoredWaterBlockBase) blockIn).getColor() : EnumCoralColor.BLUE;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        for (int oreId : OreDictionary.getOreIDs(stack)) {
            String oreNameLowercase = OreDictionary.getOreName(oreId);
            tooltip.add(oreNameLowercase);
        }
    }

    @Override
    public String getPrefix() {
        return Reference.MOD_ID;
    }

    @Override
    public String getModNamespace() {
        return Reference.MOD_ID;
    }

    @Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        switch (face) {
            case DOWN:
                return false;
            case UP:
                return isWater(world, pos.add(0, 1, 0));
            case NORTH:
                return isWater(world, pos.add(0, 0, -1));
            case SOUTH:
                return isWater(world, pos.add(0, 0, 1));
            case EAST:
                return isWater(world, pos.add(1, 0, 0));
            case WEST:
                return isWater(world, pos.add(-1, 0, 0));
        }
        return false;
    }

    private boolean isWater(IBlockAccess world, BlockPos pos) {
        return world.getBlockState(pos).getMaterial() == Material.WATER;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public EnumCoralColor getColor() {
        return this.color;
    }

}
