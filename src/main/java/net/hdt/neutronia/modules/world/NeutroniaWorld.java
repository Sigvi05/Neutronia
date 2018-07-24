package net.hdt.neutronia.modules.world;

import net.hdt.neutronia.base.module.Module;
import net.hdt.neutronia.modules.world.features.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NeutroniaWorld extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new Corals());
        registerFeature(new NaturalAquamarine());
//        registerFeature(new SeaPickles());
        registerFeature(new Basalt());
        registerFeature(new ClayGeneration(), "Generate clay underground like dirt");
        registerFeature(new OceanGuardians(), "Guardians spawn in oceans");
        registerFeature(new NaturalBlazesInNether(), "Blazes spawn naturally in the nether");
        registerFeature(new MushroomsInSwamps(), "Big mushrooms generate in swamps");
        registerFeature(new BuriedTreasure());
        registerFeature(new RevampStoneGen());
        registerFeature(new CrystalCaves());
        registerFeature(new VariedDungeons());
        registerFeature(new UndergroundBiomes());
        registerFeature(new PathfinderMaps());
        registerFeature(new NetherFossils());
        registerFeature(new NetherMushrooms());

        registerFeature(new RealisticWorldType());
        registerFeature(new DefaultWorldOptions());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.GRASS);
    }

}