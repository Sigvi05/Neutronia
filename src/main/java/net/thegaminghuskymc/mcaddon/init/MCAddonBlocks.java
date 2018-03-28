package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.mcaddon.blocks.overworld.*;
import net.thegaminghuskymc.mcaddon.properties.EnumAquamarineVariants;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;
import net.thegaminghuskymc.mcaddon.properties.EnumNewStoneVariants;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class MCAddonBlocks {

    public static Block[] brain_coral = new Block[5];
    public static Block[] dead_brain_coral = new Block[5];
    public static Block[] normal_coral = new Block[5];
    public static Block[] dead_normal_coral = new Block[5];
    public static Block[] coral_fan = new Block[5];
    public static Block[] dead_coral_fan = new Block[5];
    public static Block[] pipe_coral = new Block[5];
    public static Block[] dead_pipe_coral = new Block[5];
    public static Block[] sea_fan = new Block[5];
    public static Block[] dead_sea_fan = new Block[5];
    public static final Block dried_kelp_block;

    public static Block[] brainCoralStair = new Block[5];
    public static Block[] deadBrainCoralStair = new Block[5];
    public static Block[] coralStair = new Block[5];
    public static Block[] deadCoralStair = new Block[5];

    public static Block[] brainCoralSlab = new Block[5];
    public static Block[] deadBrainCoralSlab = new Block[5];
    public static Block[] coralSlab = new Block[5];
    public static Block[] deadCoralSlab = new Block[5];

    public static Block[] brainCoralSlabDouble = new Block[5];
    public static Block[] deadBrainCoralSlabDouble = new Block[5];
    public static Block[] coralSlabDouble = new Block[5];
    public static Block[] deadCoralSlabDouble = new Block[5];

    public static Block[] naturalAquamarine = new Block[6];
    public static Block[] aquamarine = new Block[6];
    public static Block[] naturalAquamarineStairs = new Block[6];
    public static Block[] aquamarineStairs = new Block[6];
    public static Block[] naturalAquamarineSlabs = new Block[6];
    public static Block[] naturalAquamarineSlabsVertical = new Block[6];
    public static Block[] aquamarineSlabs = new Block[6];
    public static Block[] aquamarineSlabsVertical = new Block[6];
    public static Block[] naturalAquamarineSlabsDouble = new Block[6];
    public static Block[] aquamarineSlabsDouble = new Block[6];
    public static Block[] aquamarineSlabsDoubleVertical = new Block[6];

    public static Block[] newStoneVariants = new Block[27];
    public static Block[] newStoneVariantStairs = new Block[27];
    public static Block[] newStoneVariantSlabs = new Block[27];
    public static Block[] newStoneVariantSlabsVertical = new Block[27];
    public static Block[] newStoneVariantSlabsDouble = new Block[27];

    static {
        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            brain_coral[coralColor.getMetadata()] = new BlockCoral(coralColor, "brain_coral");
            dead_brain_coral[coralColor.getMetadata()] = new BlockCoral(coralColor, "dead_brain_coral");
            normal_coral[coralColor.getMetadata()] = new BlockCoral(coralColor, "coral");
            dead_normal_coral[coralColor.getMetadata()] = new BlockCoral(coralColor, "dead_coral");
            coral_fan[coralColor.getMetadata()] = new BlockCoralPlant(coralColor, "coral_fan");
            dead_coral_fan[coralColor.getMetadata()] = new BlockCoralPlant(coralColor, "dead_coral_fan");
            pipe_coral[coralColor.getMetadata()] = new BlockDoubleCoralPlant(coralColor, "pipe_coral");
            dead_pipe_coral[coralColor.getMetadata()] = new BlockDoubleCoralPlant(coralColor, "dead_coral_plant");
            sea_fan[coralColor.getMetadata()] = new BlockDoubleCoralPlant(coralColor, "sea_fan");
            dead_sea_fan[coralColor.getMetadata()] = new BlockDoubleCoralPlant(coralColor, "dead_sea_fan");

            brainCoralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_brain_coral_stairs", brain_coral[coralColor.getMetadata()].getDefaultState());
            deadBrainCoralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_dead_brain_coral_stairs", dead_brain_coral[coralColor.getMetadata()].getDefaultState());
            coralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_coral_stairs", normal_coral[coralColor.getMetadata()].getDefaultState());
            deadCoralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_dead_coral_stairs", dead_normal_coral[coralColor.getMetadata()].getDefaultState());

            BlockModStairs.initStairs(brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) brainCoralStair[coralColor.getMetadata()]);
            BlockModStairs.initStairs(dead_brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) deadBrainCoralStair[coralColor.getMetadata()]);
            BlockModStairs.initStairs(normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) coralStair[coralColor.getMetadata()]);
            BlockModStairs.initStairs(dead_normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) deadCoralStair[coralColor.getMetadata()]);

            brainCoralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_brain_coral_slab", false);
            deadBrainCoralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_brain_coral_slab", false);
            coralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_coral_slab", false);
            deadCoralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_coral_slab", false);

            brainCoralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_brain_coral_slab", true);
            deadBrainCoralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_brain_coral_slab", true);
            coralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_coral_slab", true);
            deadCoralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_coral_slab", true);

            BlockModSlab.initSlab(brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) brainCoralSlab[coralColor.getMetadata()], (BlockModSlab) brainCoralSlabDouble[coralColor.getMetadata()]);
            BlockModSlab.initSlab(dead_brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) deadBrainCoralSlab[coralColor.getMetadata()], (BlockModSlab) deadBrainCoralSlabDouble[coralColor.getMetadata()]);
            BlockModSlab.initSlab(normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) coralSlab[coralColor.getMetadata()], (BlockModSlab) coralSlabDouble[coralColor.getMetadata()]);
            BlockModSlab.initSlab(dead_normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) deadCoralSlab[coralColor.getMetadata()], (BlockModSlab) deadCoralSlabDouble[coralColor.getMetadata()]);
        }

        for(EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
            naturalAquamarine[aquamarineVariants.ordinal()] = new BlockOverworldBase(Material.ROCK, aquamarineVariants.getName() + "_natural_aquamarine");
            aquamarine[aquamarineVariants.ordinal()] = new BlockOverworldBase(Material.ROCK, aquamarineVariants.getName() + "_aquamarine");
            naturalAquamarineStairs[aquamarineVariants.ordinal()] = new BlockOverworldStairBase(aquamarineVariants.getName() + "_natural_aquamarine_stairs", naturalAquamarine[aquamarineVariants.ordinal()].getDefaultState());
            BlockModStairs.initStairs(naturalAquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModStairs) naturalAquamarineStairs[aquamarineVariants.ordinal()]);
            aquamarineStairs[aquamarineVariants.ordinal()] = new BlockOverworldStairBase(aquamarineVariants.getName() + "_aquamarine_stairs", aquamarine[aquamarineVariants.ordinal()].getDefaultState());
            BlockModStairs.initStairs(aquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModStairs) aquamarineStairs[aquamarineVariants.ordinal()]);
            naturalAquamarineSlabs[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_natural_aquamarine_slab", false);
            naturalAquamarineSlabsDouble[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_natural_aquamarine_slab", true);
            BlockModSlab.initSlab(naturalAquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModSlab) naturalAquamarineSlabs[aquamarineVariants.ordinal()], (BlockModSlab) naturalAquamarineSlabsDouble[aquamarineVariants.ordinal()]);
            aquamarineSlabs[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_aquamarine_vertical_slab", false);
            aquamarineSlabsVertical[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_aquamarine_slab", false);
            aquamarineSlabsDouble[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_aquamarine_slab", true);
            aquamarineSlabsDoubleVertical[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_aquamarine_vertical_slab", true);
            BlockModSlab.initSlab(aquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModSlab) aquamarineSlabs[aquamarineVariants.ordinal()], (BlockModSlab) aquamarineSlabsDouble[aquamarineVariants.ordinal()]);
            BlockModSlab.initSlab(aquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModSlab) aquamarineSlabsVertical[aquamarineVariants.ordinal()], (BlockModSlab) aquamarineSlabsDoubleVertical[aquamarineVariants.ordinal()]);
        }
        dried_kelp_block = new BlockOverworldBase(Material.LEAVES, "dried_kelp_block");

        for(EnumNewStoneVariants newStoneVariant : EnumNewStoneVariants.values()) {
            newStoneVariants[newStoneVariant.getMetadata()] = new BlockOverworldBase(Material.ROCK, newStoneVariant.getName());
            newStoneVariantStairs[newStoneVariant.getMetadata()] = new BlockOverworldStairBase(newStoneVariant.getName() + "_stairs", newStoneVariants[newStoneVariant.getMetadata()].getDefaultState());
            BlockModStairs.initStairs(newStoneVariants[newStoneVariant.getMetadata()], newStoneVariant.getMetadata(), (BlockModStairs) newStoneVariantStairs[newStoneVariant.getMetadata()]);
            newStoneVariantSlabs[newStoneVariant.getMetadata()] = new BlockOverworldSlabBase(newStoneVariant.getName() + "_slab", false);
            newStoneVariantSlabsDouble[newStoneVariant.getMetadata()] = new BlockOverworldSlabBase(newStoneVariant.getName() + "_slab", true);
            BlockModSlab.initSlab(newStoneVariants[newStoneVariant.getMetadata()], newStoneVariant.getMetadata(), (BlockModSlab) newStoneVariantSlabs[newStoneVariant.getMetadata()], (BlockModSlab) newStoneVariantSlabsDouble[newStoneVariant.getMetadata()]);
        }
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

}
