package net.hdt.neutronia.modules.building.blocks;

import net.hdt.neutronia.modules.building.features.WorldStoneBricks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.blocks.BlockMetaVariants;
import net.thegaminghuskymc.huskylib2.interf.IModBlock;
import net.thegaminghuskymc.huskylib2.module.Feature;
import net.thegaminghuskymc.huskylib2.module.ModuleLoader;

import java.util.function.Supplier;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class BlockWorldStoneBricks extends BlockMetaVariants implements IModBlock {

    public BlockWorldStoneBricks() {
        super("world_stone_bricks", MOD_ID, Material.ROCK, Variants.class);
        setHardness(1.5F);
        setResistance(10.0F);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public boolean shouldDisplayVariant(int variant) {
        return Variants.class.getEnumConstants()[variant].isEnabled();
    }

    public enum Variants implements BlockMetaVariants.EnumBase {

        STONE_GRANITE_BRICKS(WorldStoneBricks.class),
        STONE_DIORITE_BRICKS(WorldStoneBricks.class),
        STONE_ANDESITE_BRICKS(WorldStoneBricks.class)/*,
		STONE_BASALT_BRICKS(Basalt.class),
		STONE_MARBLE_BRICKS(RevampStoneGen.class, () -> RevampStoneGen.enableMarble),
		STONE_LIMESTONE_BRICKS(RevampStoneGen.class, () -> RevampStoneGen.enableLimestone)*/;

        public final Class<? extends Feature> featureLink;
        private final Supplier<Boolean> enabledCond;

        Variants(Class<? extends Feature> clazz) {
            this(clazz, () -> true);
        }

        Variants(Class<? extends Feature> clazz, Supplier<Boolean> enabledCond) {
            featureLink = clazz;
            this.enabledCond = enabledCond;
        }

        public boolean isEnabled() {
            return ModuleLoader.isFeatureEnabled(featureLink) && enabledCond.get();
        }

    }

}
