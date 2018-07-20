package net.hdt.neutronia.world.gen.generators;

import net.hdt.neutronia.base.util.Reference;
import net.hdt.neutronia.base.util.interfaces.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class WorldGenCustomStructure extends WorldGenerator implements IStructure {

    private static String structureName;
    private boolean isRuined = true;

    public WorldGenCustomStructure(String name, int ruinedStage) {
        structureName = name;
        if (ruinedStage == 0) {
            isRuined = false;
        }
    }

    private static void generateStructure(World world, BlockPos pos) {
        MinecraftServer mcServer = world.getMinecraftServer();
        TemplateManager manager = worldServer.getStructureTemplateManager();
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
        Template template = manager.get(mcServer, location);

        if (template != null) {
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
            template.addBlocksToWorldChunk(world, pos, settings);
        }

        if (template == null) {
            System.out.println("NO STRUCTURE");
        }

    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        generateStructure(worldIn, position);
        return true;
    }

}
