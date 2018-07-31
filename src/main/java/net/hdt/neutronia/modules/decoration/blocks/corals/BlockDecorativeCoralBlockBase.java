package net.hdt.neutronia.modules.decoration.blocks.corals;

import net.hdt.huskylib2.block.BlockMod;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.hdt.neutronia.init.NCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
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

public class BlockDecorativeCoralBlockBase extends BlockMod implements INeutroniaBlock {

    public BlockDecorativeCoralBlockBase(String name) {
        super(name, Material.CORAL);
        this.setCreativeTab(NCreativeTabs.OCEAN_EXPANSION_TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        for (int oreId : OreDictionary.getOreIDs(stack)) {
            String oreNameLowercase = OreDictionary.getOreName(oreId);
            tooltip.add(oreNameLowercase);
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

}
