package net.hdt.neutronia.init;

import net.hdt.huskylib2.blocks.BlockModStairs;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.base.*;
import net.hdt.neutronia.blocks.nether.BlockNetherBase;
import net.hdt.neutronia.blocks.nether.BlockNetherGlowingBase;
import net.hdt.neutronia.blocks.nether.BlockNetherSponge;
import net.hdt.neutronia.blocks.nether.BlockSoulStone;
import net.hdt.neutronia.blocks.overworld.*;
import net.hdt.neutronia.properties.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class NBlocks {

//    public static final Block dried_kelp_block;
    public static final Block netherGlass, soulGlass, netherRod, netherSponge;

    // misc blocks
//    public static final Block glowingGrass;
//    public static final Block stoneAnvil, carbonAnvil, goldenAnvil, marbleAnvil, ironAnvil;
//    public static final Block stoneCauldron, carbonCauldron, goldenCauldron, marbleCauldron, ironCauldron, glassCauldron;

    // Sea Blocks
    public static Block[] brain_coral = new Block[5];
    public static Block[] dead_brain_coral = new Block[5];
    public static Block[] normal_coral = new Block[5];
    public static Block[] dead_normal_coral = new Block[5];
    public static Block[] coral_fan = new Block[5];
    public static Block[] dead_coral_fan = new Block[5];
    public static Block[] coral_plant = new Block[5];
    public static Block[] dead_coral_plant = new Block[5];
    public static Block[] pipe_coral = new Block[5];
    public static Block[] dead_pipe_coral = new Block[5];
    public static Block[] sea_fan = new Block[5];
    public static Block[] dead_sea_fan = new Block[5];
    public static Block[] naturalAquamarine = new Block[6];
    public static Block[] aquamarine = new Block[6];
    public static Block kelp;
    public static Block tropicsWater;

    //Stone Blocks
    public static Block[] newStoneVariants = new Block[26];
    public static Block[] idkNewStones = new Block[16], idkNewStones2 = new Block[16], idkNewStones3 = new Block[3];


    //Wood Blocks
    public static Block[] strippedLogs = new Block[6];
    public static Block[] potterySpinner = new Block[6];
    public static Block[] potterySpinnerActive = new Block[6];
    public static Block[] barkBlocks = new Block[6];

    //Blocks for the nether
    public static Block[] netherBlocks = new Block[2];
    public static Block[] glowingNetherBlocks = new Block[24];
    public static Block[] soulStone = new Block[4];
    public static Block[] netherPlants = new Block[3];
    public static Block[] tallNetherPlants = new Block[2];

    //Frosted versions of some blocks
    public static Block[] frostedStones = new Block[25];
    public static Block[] frostedDirts = new Block[25];
    public static Block[] frostedClay = new Block[25];

    // Some colored blocks
    public static Block[] coloredSand = new Block[16];
    public static Block[] coloredCandles = new Block[16];
    public static Block[] coloredLanterns = new Block[16];
    public static Block[] coloredRedstoneLamp = new Block[16];
    public static BlockColoredVase[] pots = new BlockColoredVase[16];

    public static Block[] glazedTerracottaPillar = new Block[16];
    public static Block[] terracottaPillar = new Block[16];
    public static Block[] woolPillar = new Block[16];

    public static Block neonLight;

    private static Block[] coffins = new Block[6];
    private static Block slumpedWitherSkeleton, slumpedSkeleton;
    private static Block tombstoneBig, tombstoneBigDark, tombstoneMedium, tombstoneMediumDark, tombstoneSmall, tombstoneSmallDark;

    static {

        for (EnumCoralColor coralColor : EnumCoralColor.values()) {
            brain_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "brain_coral");
            dead_brain_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "brain_coral_dead");
            normal_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "coral");
            dead_normal_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "dead_coral");
            coral_fan[coralColor.getMetadata()] = new BlockColoredWaterPlantBase(coralColor, "coral_fan");
            /*dead_coral_fan[coralColor.getMetadata()] = new BlockColoredWaterPlantBase(coralColor, "dead_coral_fan");
            coral_plant[coralColor.getMetadata()] = new BlockColoredWaterPlantBase(coralColor, "coral_plant");
            dead_coral_plant[coralColor.getMetadata()] = new BlockColoredWaterPlantBase(coralColor, "dead_coral_plant");*/
            /*pipe_coral[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "pipe_coral");
            dead_pipe_coral[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "dead_coral_plant");
            sea_fan[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "sea_fan");
            dead_sea_fan[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "dead_sea_fan");*/

//            brainCoralFence[coralColor.getMetadata()] = new BlockModFence(Material.CORAL, MOD_ID, coralColor.getName() + "_brain_coral").setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);

            /*brainCoralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_brain_coral_stairs", brain_coral[coralColor.getMetadata()].getDefaultState());
            deadBrainCoralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_dead_brain_coral_stairs", dead_brain_coral[coralColor.getMetadata()].getDefaultState());
            coralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_coral_stairs", normal_coral[coralColor.getMetadata()].getDefaultState());
            deadCoralStair[coralColor.getMetadata()] = new BlockOverworldStairBase(coralColor.getName() + "_dead_coral_stairs", dead_normal_coral[coralColor.getMetadata()].getDefaultState());

            BlockModStairs.initStairs(brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) brainCoralStair[coralColor.getMetadata()]);
            BlockModStairs.initStairs(dead_brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) deadBrainCoralStair[coralColor.getMetadata()]);
            BlockModStairs.initStairs(normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) coralStair[coralColor.getMetadata()]);
            BlockModStairs.initStairs(dead_normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModStairs) deadCoralStair[coralColor.getMetadata()]);*/

            /*brainCoralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_brain_coral_slab", Material.CORAL, false);
            deadBrainCoralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_brain_coral_slab", Material.CORAL, false);
            coralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_coral_slab", Material.CORAL, false);
            deadCoralSlab[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_coral_slab", Material.CORAL, false);

            brainCoralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_brain_coral_slab", Material.CORAL, true);
            deadBrainCoralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_brain_coral_slab", Material.CORAL, true);
            coralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_coral_slab", Material.CORAL, true);
            deadCoralSlabDouble[coralColor.getMetadata()] = new BlockOverworldSlabBase(coralColor.getName() + "_dead_coral_slab", Material.CORAL, true);

            BlockModSlab.initSlab(brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) brainCoralSlab[coralColor.getMetadata()], (BlockModSlab) brainCoralSlabDouble[coralColor.getMetadata()]);
            BlockModSlab.initSlab(dead_brain_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) deadBrainCoralSlab[coralColor.getMetadata()], (BlockModSlab) deadBrainCoralSlabDouble[coralColor.getMetadata()]);
            BlockModSlab.initSlab(normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) coralSlab[coralColor.getMetadata()], (BlockModSlab) coralSlabDouble[coralColor.getMetadata()]);
            BlockModSlab.initSlab(dead_normal_coral[coralColor.getMetadata()], coralColor.getMetadata(), (BlockModSlab) deadCoralSlab[coralColor.getMetadata()], (BlockModSlab) deadCoralSlabDouble[coralColor.getMetadata()]);*/
        }
        for (EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
            aquamarine[aquamarineVariants.ordinal()] = new BlockOverworldBase(Material.ROCK, aquamarineVariants.getName());
            /*aquamarineStairs[aquamarineVariants.ordinal()] = new BlockOverworldStairBase(aquamarineVariants.getName() aquamarine[aquamarineVariants.ordinal()].getDefaultState());
            BlockModStairs.initStairs(aquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModStairs) aquamarineStairs[aquamarineVariants.ordinal()]);*/
            add(aquamarineVariants.getName(), aquamarine[aquamarineVariants.getID()], 0, true, false, Main.OVERWORLD_EXPANSION_TAB);
        }
        /*for (EnumNaturalAquamarineVariants naturalAquamarineVariants : EnumNaturalAquamarineVariants.values()) {
            naturalAquamarine[naturalAquamarineVariants.getID()] = new BlockOverworldBase(Material.ROCK, naturalAquamarineVariants.getName());
            *//*naturalAquamarineStairs[naturalAquamarineVariants.getID()] = new BlockOverworldStairBase(naturalAquamarineVariants.getName(), naturalAquamarine[naturalAquamarineVariants.getID()].getDefaultState());
            BlockModStairs.initStairs(naturalAquamarine[naturalAquamarineVariants.getID()], naturalAquamarineVariants.getID(), (BlockModStairs) naturalAquamarineStairs[naturalAquamarineVariants.getID()]);*//*
            naturalAquamarineSlabs[naturalAquamarineVariants.getID()] = new BlockOverworldSlabBase(naturalAquamarineVariants.getName() + "_slab", Material.ROCK, false);
            naturalAquamarineSlabsDouble[naturalAquamarineVariants.getID()] = new BlockOverworldSlabBase(naturalAquamarineVariants.getName() + "_slab", Material.ROCK, true);
            BlockModSlab.initSlab(naturalAquamarine[naturalAquamarineVariants.getID()], naturalAquamarineVariants.getID(), (BlockModSlab) naturalAquamarineSlabs[naturalAquamarineVariants.getID()], (BlockModSlab) naturalAquamarineSlabsDouble[naturalAquamarineVariants.getID()]);
        }*/
//        dried_kelp_block = new BlockOverworldBase(Material.PLANTS, "dried_kelp_block");
        kelp = new BlockKelp();
//        tropicsWater = new BlockTropicsWater(NFluids.tropicsWater, Material.WATER);

        // Nether Blocks
        for (EnumNetherBlocks netherBlockTypes : EnumNetherBlocks.values()) {
            netherBlocks[netherBlockTypes.getMetadata()] = new BlockNetherBase(Material.ROCK, netherBlockTypes.getName());
        }
        for (EnumSoulStoneTypes soulStoneTypes : EnumSoulStoneTypes.values()) {
            soulStone[soulStoneTypes.getMetadata()] = new BlockSoulStone(soulStoneTypes.getName());
            add(soulStoneTypes.getName(), soulStone[soulStoneTypes.getMetadata()], 0, true, false, Main.NETHER_EXPANSION_TAB);
        }
        for (EnumGlowingNetherBlocks enumGlowingNetherBlocks : EnumGlowingNetherBlocks.values()) {
            glowingNetherBlocks[enumGlowingNetherBlocks.getMetadata()] = new BlockNetherGlowingBase(Material.GLASS, enumGlowingNetherBlocks.getName());
        }
        /*for (EnumNetherPlantTypes netherPlantTypes : EnumNetherPlantTypes.values()) {
            netherPlants[netherPlantTypes.getID()] = new BlockNetherPlantBase(netherPlantTypes.getName());
        }
        for (EnumTallNetherPlantTypes netherPlantTypes : EnumTallNetherPlantTypes.values()) {
            tallNetherPlants[netherPlantTypes.getID()] = new BlockNetherDoublePlantBase(netherPlantTypes.getName());
        }*/
        netherGlass = new BlockGlassBase("nether_glass").setCreativeTab(Main.NETHER_EXPANSION_TAB);
        soulGlass = new BlockGlassBase("soul_glass").setCreativeTab(Main.NETHER_EXPANSION_TAB);
        netherRod = new BlockRodBase("nether_rod", Main.NETHER_EXPANSION_TAB);
        netherSponge = new BlockNetherSponge();

        // New Stone Blocks
        for (EnumNewStoneVariants newStoneVariant : EnumNewStoneVariants.values()) {
            newStoneVariants[newStoneVariant.getMetadata()] = new BlockOverworldBase(Material.ROCK, newStoneVariant.getName());
            add(newStoneVariant.getName(), newStoneVariants[newStoneVariant.getMetadata()], 0, true, false, Main.OVERWORLD_EXPANSION_TAB);
        }
        /*for (BlockExtraStones.EnumType stoneType : BlockExtraStones.EnumType.values()) {
            idkNewStones[stoneType.getMetadata()] = new BlockOverworldBase(Material.ROCK, stoneType.getName());
        }
        for (BlockExtraStones2.EnumType stoneType : BlockExtraStones2.EnumType.values()) {
            idkNewStones2[stoneType.getMetadata()] = new BlockOverworldBase(Material.ROCK, stoneType.getName());
        }
        for (BlockExtraStones3.EnumType stoneType : BlockExtraStones3.EnumType.values()) {
            idkNewStones3[stoneType.getMetadata()] = new BlockOverworldBase(Material.ROCK, stoneType.getName());
        }*/

        //Wood Blocks
        for(BlockPlanks.EnumType enumType : BlockPlanks.EnumType.values()) {
//            strippedLogs[enumType.getMetadata()] = new BlockModPillar(String.format("stripped_%s_log", enumType.getName()), Material.WOOD);
//            potterySpinner[enumType.getMetadata()] = new BlockPotteryClayMachine(enumType.getMetadata(), String.format("%s_pottery_clay_machine", enumType.getName()), false).setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);
//            potterySpinnerActive[enumType.getMetadata()] = new BlockPotteryClayMachine(enumType.getMetadata(), String.format("%s_pottery_clay_machine_active", enumType.getName()), true).setCreativeTab(null);
//            barkBlocks[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, String.format("%s_bark_block", enumType.getName()));
//            add(String.format("stripped_%s_log", enumType.getName()),strippedLogs[enumType.getMetadata()], 0, true, true, Main.OVERWORLD_EXPANSION_TAB);
//            coffins[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, enumType.getName() + "_coffin");
        }

        // Frosted versions of vanilla stones & dirt
        /*for (EnumFrostedStoneVariants frostedStoneVariants : EnumFrostedStoneVariants.values()) {
            frostedStones[frostedStoneVariants.getMetadata()] = new BlockOverworldBase(Material.ROCK, frostedStoneVariants.getName());
            frostedStonesSlabs[frostedStoneVariants.getMetadata()] = new BlockOverworldSlabBase(frostedStoneVariants.getName() + "_slab", Material.ICE, false);
            frostedStonesSlabsDouble[frostedStoneVariants.getMetadata()] = new BlockOverworldSlabBase(frostedStoneVariants.getName() + "_slab", Material.ICE, true);
            BlockModSlab.initSlab(frostedStones[frostedStoneVariants.getMetadata()], frostedStoneVariants.getMetadata(), (BlockModSlab) frostedStonesSlabs[frostedStoneVariants.getMetadata()], (BlockModSlab) frostedStonesSlabsDouble[frostedStoneVariants.getMetadata()]);
        }
        for (EnumFrostedDirtVariants frostedDirtVariants : EnumFrostedDirtVariants.values()) {
            frostedDirts[frostedDirtVariants.getMetadata()] = new BlockOverworldBase(Material.ROCK, frostedDirtVariants.getName());
            frostedDirtSlabs[frostedDirtVariants.getMetadata()] = new BlockOverworldSlabBase(frostedDirtVariants.getName() + "_slab", Material.ICE, false);
            frostedDirtSlabsDouble[frostedDirtVariants.getMetadata()] = new BlockOverworldSlabBase(frostedDirtVariants.getName() + "_slab", Material.ICE, true);
            BlockModSlab.initSlab(newStoneVariants[frostedDirtVariants.getMetadata()], frostedDirtVariants.getMetadata(), (BlockModSlab) frostedDirtSlabs[frostedDirtVariants.getMetadata()], (BlockModSlab) frostedDirtSlabsDouble[frostedDirtVariants.getMetadata()]);
        }*/
        for (EnumDyeColor dyeColor : EnumDyeColor.values()) {
            frostedClay[dyeColor.getMetadata()] = new BlockOverworldBase(Material.ROCK, String.format("frosted_%s_terracotta", dyeColor.getName()));
            add(String.format("frosted_%s_terracotta", dyeColor.getName()), frostedClay[dyeColor.getMetadata()], 0, true, false, Main.OVERWORLD_EXPANSION_TAB);
//            pots[dyeColor.getMetadata()] = new BlockColoredVase(EnumDyeColor.byMetadata(dyeColor.getMetadata()));
//            neonLight = new BlockNeonLight(dyeColor);
//            glazedTerracottaPillar[dyeColor.getMetadata()] = new BlockModPillar(String.format("%s_glazed_terracotta_pillar", dyeColor.getName()), Material.ROCK);
//            terracottaPillar[dyeColor.getMetadata()] = new BlockModPillar(String.format("%s_terracotta_pillar", dyeColor.getName()), Material.ROCK);
            add(String.format("%s_terracotta", dyeColor.getName()), Blocks.STAINED_HARDENED_CLAY, dyeColor.getMetadata(), true, false, Main.OVERWORLD_EXPANSION_TAB);
//            add(String.format("%s_glazed_terracotta", dyeColor.getName()), Block.getBlockFromName(String.format("minecraft:%s_glazed_terracotta", dyeColor.getName())), dyeColor.getMetadata(), true, false);
            coloredSand[dyeColor.getMetadata()] = new BlockColoredAlt(MOD_ID, "sand", dyeColor);
        }

        // New stairs & slabs and also new colored blocks
        for (EnumDyeColor color : EnumDyeColor.values()) {
            /*woolStairs[color.getMetadata()] = new BlockOverworldStairBase(color.getName() + "_wool_stairs", Blocks.WOOL.getDefaultState());
            BlockModStairs.initStairs(Blocks.WOOL, color.getMetadata(), (BlockModStairs) woolStairs[color.getMetadata()]);
            coloredGlassStairs[color.getMetadata()] = new BlockOverworldStairBase(color.getName() + "_glass_stairs", Blocks.STAINED_GLASS.getDefaultState());
            BlockModStairs.initStairs(Blocks.STAINED_GLASS, color.getMetadata(), (BlockModStairs) coloredGlassStairs[color.getMetadata()]);
            woolSlabs[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_wool_slab", Material.CLOTH, false);
            woolSlabsDouble[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_wool_slab", Material.CLOTH, true);
            BlockModSlab.initSlab(Blocks.WOOL, color.getMetadata(), (BlockModSlab) woolSlabs[color.getMetadata()], (BlockModSlab) woolSlabsDouble[color.getMetadata()]);
             coloredGlassSlabs[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_glass_slab", Material.GLASS, false);
            coloredGlassSlabsDouble[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_glass_slab", Material.GLASS, true);
            BlockModSlab.initSlab(Blocks.STAINED_GLASS, color.getMetadata(), (BlockModSlab) coloredGlassSlabs[color.getMetadata()], (BlockModSlab) coloredGlassSlabsDouble[color.getMetadata()]);*/
            /*coloredCandles[color.getMetadata()] = new BlockColoredLightSourceWithParticlesAlt(MOD_ID, "candles", color);
            coloredLanterns[color.getMetadata()] = new BlockColoredLightSourceWithParticlesAlt(MOD_ID, "lanterns", color);
            coloredRedstoneLamp[color.getMetadata()] = new BlockColoredRedstoneLamp(color);*/
        }
//        floorTile = new BlockFloorTile();

        add("stone", Blocks.STONE, 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("stone_granite", Blocks.STONE, 1, true, true, Main.OVERWORLD_EXPANSION_TAB);
        add("stone_diorite", Blocks.STONE, 3, true, true, Main.OVERWORLD_EXPANSION_TAB);
        add("stone_andesite", Blocks.STONE, 5, true, true, Main.OVERWORLD_EXPANSION_TAB);
        add("andesite_bricks", NBlocks.newStoneVariants[0], 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("andesite_cobble", NBlocks.newStoneVariants[1], 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("diorite_bricks", NBlocks.newStoneVariants[8], 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("diorite_cobble", NBlocks.newStoneVariants[9], 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("granite_bricks", NBlocks.newStoneVariants[11], 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("granite_cobble", NBlocks.newStoneVariants[12], 0, false, true, Main.OVERWORLD_EXPANSION_TAB);
        add("end_bricks", Blocks.END_BRICKS, 0, true, true, Main.END_EXPANSION_TAB);
        add("prismarine", Blocks.PRISMARINE, 0, true, true, Main.OVERWORLD_EXPANSION_TAB);
        add("prismarine_bricks", Blocks.PRISMARINE, 1, true, true, Main.OVERWORLD_EXPANSION_TAB);
        add("prismarine_dark", Blocks.PRISMARINE, 2, true, true, Main.OVERWORLD_EXPANSION_TAB);
        add("red_nether_brick", Blocks.RED_NETHER_BRICK, 0, true, true, Main.NETHER_EXPANSION_TAB);

        addWall("sandstone", Blocks.SANDSTONE, 0);
        addWall("chiseled_sandstone", Blocks.SANDSTONE, 1);
        addWall("smooth_sandstone", Blocks.SANDSTONE, 2);
        addWall("red_sandstone", Blocks.RED_SANDSTONE, 0);
        addWall("chiseled_red_sandstone", Blocks.RED_SANDSTONE, 1);
        addWall("smooth_red_sandstone", Blocks.RED_SANDSTONE, 2);

//        glowingGrass = new BlockGlowingGrass();

//        stoneAnvil = new BlockModAnvil("stone_anvil", Main.OVERWORLD_EXPANSION_TAB);
//        carbonAnvil = new BlockModAnvil("carbon_anvil", Main.OVERWORLD_EXPANSION_TAB);
//        goldenAnvil = new BlockModAnvil("golden_anvil", Main.OVERWORLD_EXPANSION_TAB);
//        marbleAnvil = new BlockModAnvil("marble_anvil", Main.OVERWORLD_EXPANSION_TAB);
//        ironAnvil = new BlockModAnvil("iron_anvil", Main.OVERWORLD_EXPANSION_TAB);
//
//        stoneCauldron = new BlockModCauldron("stone_cauldron", Main.OVERWORLD_EXPANSION_TAB);
//        carbonCauldron = new BlockModCauldron("carbon_cauldron", Main.OVERWORLD_EXPANSION_TAB);
//        goldenCauldron = new BlockModCauldron("golden_cauldron", Main.OVERWORLD_EXPANSION_TAB);
//        marbleCauldron = new BlockModCauldron("marble_cauldron", Main.OVERWORLD_EXPANSION_TAB);
//        ironCauldron = new BlockModCauldron("iron_cauldron", Main.OVERWORLD_EXPANSION_TAB);
//        glassCauldron = new BlockModCauldron("glass_cauldron", Main.OVERWORLD_EXPANSION_TAB);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    public static void add(String name, Block block, int meta, CreativeTabs creativeTabs) {
        add(name, block, meta, true, true, creativeTabs);
    }

    public static void add(String name, Block block, int meta, boolean slabs, boolean stairs, CreativeTabs creativeTabs) {
        IBlockState state = block.getStateFromMeta(meta);
        String stairsName = name + "_stairs";
        String slabName = name + "_slab";

        if (stairs) {
            BlockModStairs.initStairs(block, meta, new BlockOverworldStairBase(stairsName, state, creativeTabs));
        }
        if (slabs) {
            BlockModSlab.initSlab(block, meta, new BlockOverworldSlabBase(slabName, block.getMaterial(state), false, creativeTabs), new BlockOverworldSlabBase(slabName, block.getMaterial(state), true, creativeTabs));
        }
    }

    public static void addWall(String name, Block block, int meta) {
        addWall(name, block, meta, BlockModWall::new);
    }

    public static void addWall(String name, Block block, int meta, WallSupplier supplier) {
        IBlockState state = block.getStateFromMeta(meta);
        String wallName = name + "_wall";
        BlockModWall.initWall(block, meta, supplier.supply(wallName, state));
    }

    public interface WallSupplier {
        BlockModWall supply(String wallName, IBlockState state);
    }

}
