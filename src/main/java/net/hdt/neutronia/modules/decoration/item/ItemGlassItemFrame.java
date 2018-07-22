package net.hdt.neutronia.modules.decoration.item;

import net.hdt.huskylib2.interf.IExtraVariantHolder;
import net.hdt.huskylib2.items.ItemMod;
import net.hdt.neutronia.base.items.INeutroniaItem;
import net.hdt.neutronia.base.module.ModuleLoader;
import net.hdt.neutronia.modules.decoration.entity.EntityGlassItemFrame;
import net.hdt.neutronia.modules.decoration.features.FlatItemFrames;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

public class ItemGlassItemFrame extends ItemMod implements INeutroniaItem, IExtraVariantHolder {

	private static final String[] EXTRA_VARIANTS = {
			"glass_item_frame_world"
	};
	
	public ItemGlassItemFrame() {
		super("glass_item_frame", MOD_ID);
		setCreativeTab(CreativeTabs.DECORATIONS);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = playerIn.getHeldItem(hand);
		BlockPos blockpos = pos.offset(facing);

		if((ModuleLoader.isFeatureEnabled(FlatItemFrames.class) || facing.getAxis() != EnumFacing.Axis.Y) && playerIn.canPlayerEdit(blockpos, facing, stack)) {
			EntityHanging entityhanging = createEntity(worldIn, blockpos, facing);

			if(entityhanging.onValidSurface()) {
				if(!worldIn.isRemote) {
					entityhanging.playPlaceSound();
					worldIn.spawnEntity(entityhanging);
				}

				stack.shrink(1);
			}

			return EnumActionResult.SUCCESS;
		}

		return EnumActionResult.FAIL;
	}

	private EntityHanging createEntity(World worldIn, BlockPos pos, EnumFacing clickedSide) {
		return new EntityGlassItemFrame(worldIn, pos, clickedSide);
	}
	
	@Override
	public String[] getExtraVariants() {
		return EXTRA_VARIANTS;
	}
	
}