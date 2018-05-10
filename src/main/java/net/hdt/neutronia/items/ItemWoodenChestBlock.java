package net.hdt.neutronia.items;

import net.hdt.neutronia.blocks.overworld.BlockCustomChest;
import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.properties.ChestType;
import net.hdt.neutronia.tileentity.TileCustomChest;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.interf.IExtraVariantHolder;
import net.thegaminghuskymc.huskylib2.items.blocks.ItemModBlock;

import java.util.ArrayList;
import java.util.List;

public class ItemWoodenChestBlock extends ItemModBlock implements IExtraVariantHolder {

    public ItemWoodenChestBlock(Block block, ResourceLocation res) {
        super(block, res);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return stack -> {
            ChestType type = NBlocks.customChest.getCustomType(stack);
            return getBlock() == NBlocks.customChestTrap ? type.trapModel : type.normalModel;
        };
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        ChestType type = NBlocks.customChest.getCustomType(stack);
        String name = type.name + (getBlock() == NBlocks.customChestTrap ? "_trap" : "");
        return "tile.custom_chest_" + name;
    }

    @Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
        int typeCnt = 0;

        BlockPos posN = pos.north();
        BlockPos posS = pos.south();
        BlockPos posW = pos.west();
        BlockPos posE = pos.east();

        BlockCustomChest cChest = (BlockCustomChest) getBlock();
        ChestType myType = cChest.getCustomType(stack);

        if (world.getBlockState(posN).getBlock() == block && cChest.getCustomType(world, posN) == myType)
            typeCnt += cChest.isDoubleChest(world, posN, myType) ? 2 : 1;
        if (world.getBlockState(posS).getBlock() == block && cChest.getCustomType(world, posS) == myType)
            typeCnt += cChest.isDoubleChest(world, posS, myType) ? 2 : 1;
        if (world.getBlockState(posW).getBlock() == block && cChest.getCustomType(world, posW) == myType)
            typeCnt += cChest.isDoubleChest(world, posW, myType) ? 2 : 1;
        if (world.getBlockState(posE).getBlock() == block && cChest.getCustomType(world, posE) == myType)
            typeCnt += cChest.isDoubleChest(world, posE, myType) ? 2 : 1;

        if (typeCnt <= 1 && super.placeBlockAt(stack, player, world, pos, side, hitX, hitY, hitZ, newState)) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileCustomChest) {
                ((TileCustomChest) te).chestType = myType;
                return true;
            }
        }

        return false;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        BlockCustomChest chest = (BlockCustomChest) Block.getBlockFromItem(this);
        if (isInCreativeTab(tab))
            for (ChestType type : ChestType.VALID_TYPES)
                subItems.add(chest.setCustomType(new ItemStack(this, 1), type));
    }

    @Override
    public String[] getExtraVariants() {
        List<String> variants = new ArrayList();
        for (ChestType type : ChestType.VALID_TYPES) {
            variants.add("custom_chest_" + type.name);
            variants.add("custom_chest_trap_" + type.name);
        }

        return variants.toArray(new String[variants.size()]);
    }

}