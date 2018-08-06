package net.hdt.neutronia.groups.world.features;

import net.hdt.neutronia.base.groups.Component;
import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class MushroomsInSwamps extends Component {

    double bigMushroomsPerChunk;
    private WorldGenerator bigMushroomGen = new WorldGenBigMushroom();

    @Override
    public void setupConfig() {
        bigMushroomsPerChunk = loadPropDouble("Big Mushroom count per chunk", "Must be an integer if above 1. If below 1, works as a chance to generate one per chunk.", 0.5);
    }

    @SubscribeEvent
    public void decorate(DecorateBiomeEvent.Decorate event) {
        World world = event.getWorld();
        Biome biome = world.getBiome(event.getPos());
        Random rand = event.getRand();

        if ((biome == Biomes.SWAMPLAND || biome == Biomes.MUTATED_SWAMPLAND) && event.getType() == EventType.BIG_SHROOM) {
            if (bigMushroomsPerChunk < 1 && rand.nextDouble() > bigMushroomsPerChunk)
                return;

            int amount = (int) Math.max(1, bigMushroomsPerChunk);
            for (int i = 0; i < amount; i++) {
                int x = rand.nextInt(16) + 8;
                int y = rand.nextInt(16) + 8;
                bigMushroomGen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
            }

            event.setResult(Result.DENY);
        }
    }

    @Override
    public boolean hasTerrainSubscriptions() {
        return true;
    }

    @Override
    public String getComponentIngameConfigName() {
        return "Big Mushrooms In Swamps";
    }

}
