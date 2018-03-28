package net.thegaminghuskymc.mcaddon.world.gen.generators;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.thegaminghuskymc.mcaddon.util.interfaces.IStructure;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

public class WorldGenStructure extends WorldGenerator implements IStructure
{
	private static String structureName;
	
	public WorldGenStructure(String name) 
	{
		structureName = name;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) 
	{
		generateStructure(worldIn, position);
		return true;
	}
	
	private static void generateStructure(World world, BlockPos pos)
	{
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(MOD_ID, structureName);
		Template template = manager.get(mcServer, location);
		
		if(template != null)
		{
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings);
		}
	}
}