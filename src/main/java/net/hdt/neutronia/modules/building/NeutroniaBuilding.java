package net.hdt.neutronia.modules.building;

import net.hdt.neutronia.modules.building.features.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.thegaminghuskymc.huskylib2.module.Module;

public class NeutroniaBuilding extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new HardenedClayTiles());
        registerFeature(new VanillaStairsAndSlabs());
        registerFeature(new WorldStoneBricks());
        registerFeature(new Thatch());
        registerFeature(new SandyBricks());
        registerFeature(new ReedBlock(), "Sugar cane blocks");
        registerFeature(new BarkBlocks());
        registerFeature(new VanillaWalls());
        registerFeature(new PolishedStone());
        registerFeature(new CarvedWood());
        registerFeature(new SnowBricks());
        registerFeature(new CharredNetherBricks());
        registerFeature(new MoreSandstone());
        registerFeature(new MidoriBlocks());
        registerFeature(new IronPlates());
        registerFeature(new VerticalWoodPlanks());
        registerFeature(new SoulSandstone());
        registerFeature(new StainedPlanks());
        registerFeature(new PolishedNetherrack());
        registerFeature(new DuskboundBlocks());
        registerFeature(new SturdyStone());
        registerFeature(new QuiltedWool());
        registerFeature(new MagmaBricks());
    }

    @Override
    public ItemStack getIconStack() {
        return new ItemStack(Blocks.BRICK_BLOCK);
    }

}
