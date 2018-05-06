package net.hdt.neutronia.world.events;

import net.hdt.neutronia.world.gen.generators.StoneInfoBasedGenerator;
import net.hdt.neutronia.world.utils.StoneInfo;
import net.hdt.neutronia.world.utils.handlers.BiomeTypeConfigHandler;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

import static net.minecraftforge.common.BiomeDictionary.Type;

public class OreGenEvents {

    private static StoneInfo graniteInfo,
            dioriteInfo,
            andesiteInfo;
    private static List<StoneInfoBasedGenerator> generators;

    public OreGenEvents(FMLPreInitializationEvent event) {
        setupConfig();
        preInit(event);
    }

    private static void setupConfig() {
        int defSize = 14;
        int defRarity = 15;
        int defUpper = 80;
        int defLower = 20;

        graniteInfo = loadStoneInfo("granite", defSize, defRarity, defUpper, defLower, true, Type.MOUNTAIN, Type.HILLS);
        dioriteInfo = loadStoneInfo("diorite", defSize, defRarity, defUpper, defLower, true, Type.SANDY, Type.SAVANNA, Type.WASTELAND, Type.MUSHROOM);
        andesiteInfo = loadStoneInfo("andesite", defSize, defRarity, defUpper, defLower, true, Type.FOREST);
    }

    private static StoneInfo loadStoneInfo(String name, int clusterSize, int clusterRarity, int upperBound, int lowerBound, boolean enabled, Type... biomes) {
        return loadStoneInfo(name, clusterSize, clusterRarity, upperBound, lowerBound, enabled, "0", biomes);
    }

    private static StoneInfo loadStoneInfo(String name, int clusterSize, int clusterRarity, int upperBound, int lowerBound, boolean enabled, String dims, Type... biomes) {
        String category = "worldGen." + name;
        return new StoneInfo(category, clusterSize, clusterRarity, upperBound, lowerBound, enabled, dims, biomes);
    }

    public static void preInit(FMLPreInitializationEvent event) {
        IBlockState graniteState = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE);
        IBlockState dioriteState = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE);
        IBlockState andesiteState = Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE);

        generators = new ArrayList<>();

        generators.add(new StoneInfoBasedGenerator(() -> graniteInfo, graniteState, "granite"));
        generators.add(new StoneInfoBasedGenerator(() -> dioriteInfo, dioriteState, "diorite"));
        generators.add(new StoneInfoBasedGenerator(() -> andesiteInfo, andesiteState, "andesite"));

        BiomeTypeConfigHandler.debugStoneGeneration(generators);
    }

    @SubscribeEvent
    public void onOreGenerate(OreGenEvent.GenerateMinable event) {
        switch (event.getType()) {
            case GRANITE:
                if (graniteInfo.enabled)
                    event.setResult(Event.Result.DENY);
                break;
            case DIORITE:
                if (dioriteInfo.enabled)
                    event.setResult(Event.Result.DENY);
                break;
            case ANDESITE:
                if (andesiteInfo.enabled)
                    event.setResult(Event.Result.DENY);

                generateNewStones(event);
                break;
            default:
        }
    }

    private void generateNewStones(OreGenEvent.GenerateMinable event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        Chunk chunk = world.getChunkFromBlockCoords(pos);

        for (StoneInfoBasedGenerator gen : generators)
            gen.generate(chunk.x, chunk.z, world);
    }

}
