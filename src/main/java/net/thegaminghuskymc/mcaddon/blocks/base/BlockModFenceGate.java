package net.thegaminghuskymc.mcaddon.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;
import net.thegaminghuskymc.huskylib2.items.blocks.ItemModBlock;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class BlockModFenceGate extends BlockFenceGate implements IModBlock {

    private final String[] variants;
    private String bareName, modid;

    public BlockModFenceGate(String modid, String name, String... variants)  {
        super(BlockPlanks.EnumType.OAK);

        useNeighborBrightness = true;

        if (variants.length == 0)
            variants = new String[]{name};

        bareName = name;
        this.variants = variants;
        this.modid = modid;

        setUnlocalizedName(modid, name);

        setHardness(1.5F);
        setResistance(30F);
        setHarvestLevel("pickaxe", 1);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }

    @Override
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    public Block setUnlocalizedName(String modid, String name) {

        String[] nameParts = name.split("_");

        String gateName = ":fence_gate" + StringUtils.capitalize(nameParts[0]) + ".";
        StringBuilder gateType = new StringBuilder(nameParts[1]);

        for(int i = 2; i < nameParts.length; i++)
        {
            gateType.append(StringUtils.capitalize(nameParts[i]));
        }

        super.setUnlocalizedName(gateName + gateType);
        this.setRegistryName(modid, gateName + gateType);
        ProxyRegistry.register(this);
        ProxyRegistry.register(this.createItemBlock(new ResourceLocation(modid, name)));
        return this;
    }

    protected ItemBlock createItemBlock(ResourceLocation res) {
        return new ItemModBlock(this, res);
    }

    @Override
    public PathNodeType getAiPathNodeType(IBlockState state, IBlockAccess world, BlockPos pos)  {
        return state.getValue(OPEN) ? PathNodeType.DOOR_OPEN : PathNodeType.DOOR_WOOD_CLOSED;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        EnumFacing.Axis facing = state.getValue(FACING).getAxis();

        Block northBlock = worldIn.getBlockState(pos.north()).getBlock();
        Block eastBlock = worldIn.getBlockState(pos.east()).getBlock();
        Block southBlock = worldIn.getBlockState(pos.south()).getBlock();
        Block westBlock = worldIn.getBlockState(pos.west()).getBlock();

        if(facing == EnumFacing.Axis.Z && ((westBlock instanceof BlockWall) || (eastBlock instanceof BlockWall)) || facing == EnumFacing.Axis.X && ((northBlock instanceof BlockWall) || (southBlock instanceof BlockWall)))
        {
            return state.withProperty(IN_WALL, true);
        }

        return state.withProperty(IN_WALL, false);
    }

    @Override
    public String getPrefix() {
        return this.modid;
    }

    @Override
    public String getModNamespace() {
        return this.modid;
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
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.CUTOUT_MIPPED || layer == BlockRenderLayer.CUTOUT || layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    @Override
    public IProperty getVariantProp() {
        return null;
    }

    @Override
    public Class getVariantEnum() {
        return null;
    }

}