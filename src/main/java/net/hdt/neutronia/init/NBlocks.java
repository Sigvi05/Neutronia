package net.hdt.neutronia.init;

import net.hdt.huskylib2.blocks.BlockModStairs;
import net.hdt.huskylib2.recipie.RecipeHandler;
import net.hdt.huskylib2.utils.ProxyRegistry;
import net.hdt.neutronia.blocks.*;
import net.hdt.neutronia.blocks.base.BlockColoredAlt;
import net.hdt.neutronia.blocks.base.*;
import net.hdt.neutronia.blocks.base.BlockFalling;
import net.hdt.neutronia.blocks.nether.*;
import net.hdt.neutronia.blocks.overworld.*;
import net.hdt.neutronia.blocks.overworld.BlockColoredSlime;
import net.hdt.neutronia.properties.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Objects;

import static net.hdt.neutronia.init.NCreativeTabs.*;
import static net.hdt.neutronia.util.Reference.MOD_ID;

public class NBlocks {

    // Misc
    private static final Block blackSand;
    private static final Block smoothQuartz, smoothSandstone, smoothRedSandstone;
    private static final Block quartzBricks, sandstoneBricks, redSandstoneBricks;
    // Sea Blocks
    public static final Block[] coralBlock = new Block[5];
    static final Block[] deadCoralBlock = new Block[5];
    public static final Block[] decorativeCoralBlock = new Block[5];
    static final Block[] decorativeDeadCoralBlock = new Block[5];
    public static final Block[] coralFan = new Block[5];
    public static final Block[] deadCoralFan = new Block[5];
    public static final Block[] decorativeCoralFan = new Block[5];
    public static final Block[] decorativeDeadCoralFan = new Block[5];
    public static final Block[] coralFanWall = new Block[5];
    public static final Block[] deadCoralFanWall = new Block[5];
    public static final Block[] decorativeCoralFanWall = new Block[5];
    public static final Block[] decorativeDeadCoralFanWall = new Block[5];
    public static final Block[] coral = new Block[5];
    public static final Block[] deadCoral = new Block[5];
    public static final Block[] decorativeCoral = new Block[5];
    static final Block[] decorativeDeadCoral = new Block[5];
    public static Block[] pipeCoral = new Block[5];
    public static Block[] deadPipeCoral = new Block[5];
    public static Block[] seaFan = new Block[5];
    public static Block[] deadSeaFan = new Block[5];
    private static final Block[] naturalAquamarine = new Block[13];
    private static final Block[] aquamarine = new Block[6];
    public static Block seaPickle, turtleEgg;
    private static final Block driedKelpBlock;
    private static final Block wrautnaut, wrautnautOld, wrautnautPorthole;
    public static final ArrayList<Block> livingCorals = new ArrayList<>(EnumCoralColor.values().length);
    private static final ArrayList<Block> deadCorals = new ArrayList<>(EnumCoralColor.values().length);
    private static final MRPillar prismarineColumn;
    public static final BlockPrismarineChiseled chiseledPrismarine;
    public static final BlockPrismarineChiseled chiseledPrismarineFilled;
    //Stone Blocks
    public static final Block[] newStoneVariants = new Block[26];
    //Wood Blocks
    private static final Block[] strippedLogs = new Block[6], strippedBarkBlocks = new Block[6];
    public static final Block[] potterySpinner = new Block[6], potterySpinnerActive = new Block[6];
    private static final Block[] barkBlocks = new Block[6], chiseledBarkBlocks = new Block[6], unnamedChiseledBarkBlock = new Block[6];
    public static final Block[] logPoles = new Block[6];
    public static final Block[] strippedLogPoles = new Block[6];
    private static final Block[] plankPoles = new Block[6];
    public static Block[] logDowels = new Block[6], strippedLogDowels = new Block[6], plankDowels = new Block[6];
    public static Block[] barkButtons = new Block[6], plankButtons = new Block[6];
    public static Block[] barkPressurePlates = new Block[6], plankPressurePlates = new Block[6];
    //Blocks for the nether
    public static final Block[] glowingNetherBlocks;
    private static final Block[] soulStone = new Block[4];
    public static Block[] netherPlants = new Block[3];
    public static Block[] tallNetherPlants = new Block[2];
    private static final Block netherGlass, netherRod, netherSponge, ash, burnedBones;
    public static final BlockSoulGlass soulGlass, soulGlassOn;
    private static final MRPillar netherbrickPillar;
    public static final BlockNetherbrickChiseled chiseledNetherbrick, chiseledNetherbrickFilled;
    //Frosted versions of some blocks
    public static Block[] frostedStones = new Block[6];
    public static Block[] frostedDirts = new Block[12];
    public static Block[] frostedClay = new Block[16];
    // Some colored blocks
    public static Block[] coloredSand = new Block[16];
    public static Block[] coloredSandstone = new Block[16];
    public static final BlockColoredAlt[] coloredCandles = new BlockColoredAlt[16];
    public static final Block[] coloredPlanks = new Block[16];
    public static Block[] coloredPlanksStair = new Block[16];
    public static final Block[] coloredPlanksSlabSingle = new Block[16], coloredPlanksSlabDouble = new Block[16];
    public static final BlockColoredAlt[] coloredLitCandles = new BlockColoredAlt[16];
    public static final BlockColoredAlt[] coloredLanterns = new BlockColoredAlt[16];
    public static final BlockColoredAlt[] coloredLitLanterns = new BlockColoredAlt[16];
    public static final BlockColoredAlt[] coloredRedstoneLamp = new BlockColoredAlt[16];
    public static final BlockColoredAlt[] coloredLitRedstoneLamp = new BlockColoredAlt[16];
    public static final BlockColoredAlt[] coloredSlimeBlock = new BlockColoredAlt[16];
    public static Block[] coloredVases = new Block[16];
    public static Block[] terracottaPots = new Block[16];
    private static final Block[] centeredGlazedTerracottaBlocks = new Block[16];
    private static Block[] coffins = new Block[13];
    private static Block slumpedWitherSkeleton, slumpedSkeleton;
    private static Block tombstoneBig, tombstoneBigDark, tombstoneMedium, tombstoneMediumDark, tombstoneSmall, tombstoneSmallDark;
    public static final Block fireflyBulbOff, fireflyBulbOn;
//    public static final Block stoneAnvil, carbonAnvil, goldenAnvil, marbleAnvil, ironAnvil, darkIronAnvil;
//    public static final Block stoneCauldron, carbonCauldron, goldenCauldron, marbleCauldron, ironCauldron, glassCauldron;
//    public static final Block whiteBricks, redBricks, greenBricks;
//    public static final Block redClayBlock, greenClayBlock;

    public static final MRPillar sandstonePillar;
    public static final MRPillar redSandstonePillar;
    public static final BlockPurpurChiseled chiseledPurpur;
    public static final BlockPurpurChiseled chiseledPurpurFilled;
    public static final BlockBrickChiseled chiseledBricks;
    public static final BlockBrickChiseled chiseledBricksFilled;
    public static final Block scaffoldingBlock;

    static {
        glowingNetherBlocks = new Block[24];

        for (EnumCoralColor coralColor : EnumCoralColor.values()) {
//            brainCoral[coralColor.getMetadata()] = new BlockCoralBlock(coralColor, "brain_coral", false, livingCorals, deadCorals);
//            deadBrainCoral[coralColor.getMetadata()] = new BlockCoralBlock(coralColor, "dead_brain_coral", true, livingCorals, deadCorals);
            coralBlock[coralColor.getMetadata()] = new BlockCoralBlock(coralColor, false, livingCorals, deadCorals);
            deadCoralBlock[coralColor.getMetadata()] = new BlockCoralBlock(coralColor, true, livingCorals, deadCorals);
            decorativeCoralBlock[coralColor.getMetadata()] = new BlockWaterBlockBase(String.format("decorative_%s_coral_block", coralColor.getNewName()));
            decorativeDeadCoralBlock[coralColor.getMetadata()] = new BlockWaterBlockBase(String.format("decorative_dead_%s_coral_block", coralColor.getNewName()));
            coralFan[coralColor.getMetadata()] = new BlockCoralFan(coralColor, false, livingCorals, deadCorals);
            deadCoralFan[coralColor.getMetadata()] = new BlockCoralFan(coralColor, true, livingCorals, deadCorals);
            decorativeCoralFan[coralColor.getMetadata()] = new BlockWaterPlantBase(String.format("decorative_%s_coral_fan", coralColor.getNewName()));
            decorativeDeadCoralFan[coralColor.getMetadata()] = new BlockWaterPlantBase(String.format("decorative_dead_%s_coral_fan", coralColor.getNewName()));
            coralFanWall[coralColor.getMetadata()] = new BlockCoralFan(coralColor, "coral_wall_fan",false, livingCorals, deadCorals);
            deadCoralFanWall[coralColor.getMetadata()] = new BlockCoralFan(coralColor, "coral_wall_fan", true, livingCorals, deadCorals);
            decorativeCoralFanWall[coralColor.getMetadata()] = new BlockWaterPlantBase(String.format("decorative_%s_coral_wall_fan", coralColor.getNewName()));
            decorativeDeadCoralFanWall[coralColor.getMetadata()] = new BlockWaterPlantBase(String.format("decorative_dead_%s_coral_wall_fan", coralColor.getNewName()));
            coral[coralColor.getMetadata()] = new BlockCoralPlant(coralColor, false, livingCorals, deadCorals);
            deadCoral[coralColor.getMetadata()] = new BlockCoralPlant(coralColor, true, livingCorals, deadCorals);
            decorativeCoral[coralColor.getMetadata()] = new BlockWaterPlantBase(String.format("decorative_%s_coral", coralColor.getNewName()));
            decorativeDeadCoral[coralColor.getMetadata()] = new BlockWaterPlantBase(String.format("decorative_dead_%s_coral", coralColor.getNewName()));
            /*pipeCoral[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "pipe_coral");
            deadPipeCoral[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "dead_pipe_coral");
            seaFan[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "sea_fan");
            deadSeaFan[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "dead_sea_fan");*/
        }

        for (EnumAquamarineVariants aquamarineVariants : EnumAquamarineVariants.values()) {
            aquamarine[aquamarineVariants.ordinal()] = new BlockOverworldBase(Material.ROCK, aquamarineVariants.getName(), false).setCreativeTab(OCEAN_EXPANSION_TAB);
            add(aquamarineVariants.getName(), aquamarine[aquamarineVariants.getID()], Material.ROCK, 0, true, false, OCEAN_EXPANSION_TAB);
        }
        for (EnumNaturalAquamarineVariants naturalAquamarineVariants : EnumNaturalAquamarineVariants.values()) {
            naturalAquamarine[naturalAquamarineVariants.getID()] = new BlockOverworldBase(Material.ROCK, naturalAquamarineVariants.getName(), false).setCreativeTab(OCEAN_EXPANSION_TAB);
        }
        driedKelpBlock = new BlockOverworldBase(Material.PLANTS, "dried_kelp_block", false).setCreativeTab(OCEAN_EXPANSION_TAB);
        wrautnaut = new BlockOverworldBase(Material.IRON, "wrautnaut", false).setCreativeTab(OCEAN_EXPANSION_TAB);
        wrautnautOld = new BlockOverworldBase(Material.IRON, "old_wrautnaut", false).setCreativeTab(OCEAN_EXPANSION_TAB);
        wrautnautPorthole = new BlockOverworldBase(Material.IRON, "wrautnaut_porthole", false).setCreativeTab(OCEAN_EXPANSION_TAB);
        prismarineColumn = new MRPillar(Material.ROCK, "prismarine_column", OCEAN_EXPANSION_TAB, 0.3F, 6.5F);
        chiseledPrismarine = new BlockPrismarineChiseled("chiseled_prismarine", false);
        chiseledPrismarineFilled = new BlockPrismarineChiseled("chiseled_prismarine_filled", true);
//        elderPrismarine = new MRBlock(Material.ROCK, "elder_prismarine", CreativeTabs.BUILDING_BLOCKS, 1.5F, 10.0F);
//        elderPrismarineBricks = new MRBlock(Material.ROCK, "elder_prismarine_bricks", CreativeTabs.BUILDING_BLOCKS, 1.5F, 10.0F);

        // Nether Blocks
        netherGlass = new BlockGlassBase("nether_glass").setCreativeTab(NETHER_EXPANSION_TAB);
        soulGlass = new BlockSoulGlass(false, Material.GLASS, "soul_glass", NETHER_EXPANSION_TAB);
        soulGlassOn = new BlockSoulGlass(true, Material.GLASS, "soul_glass_on", null);
        netherRod = new BlockRodBase("nether_rod", NETHER_EXPANSION_TAB, true);
        netherSponge = new BlockNetherSponge();
        burnedBones = new BlockBurnedBones();
        ash = new BlockNetherBase(Material.SAND, "ash");

        for (EnumGlowingNetherBlocks enumGlowingNetherBlocks : EnumGlowingNetherBlocks.values()) {
            glowingNetherBlocks[enumGlowingNetherBlocks.getMetadata()] = new BlockNetherGlowingBase(Material.GLASS, enumGlowingNetherBlocks.getName());
        }
        for (EnumSoulStoneTypes soulStoneTypes : EnumSoulStoneTypes.values()) {
            soulStone[soulStoneTypes.getMetadata()] = new BlockSoulStone(soulStoneTypes.getName());
            add(soulStoneTypes.getName(), soulStone[soulStoneTypes.getMetadata()], Material.ROCK, 0, true, false, NETHER_EXPANSION_TAB);
        }

        netherbrickPillar = new MRPillar(Material.ROCK, "netherbrick_pillar", NETHER_EXPANSION_TAB, 0.4F, 7.5F);
        chiseledNetherbrick = new BlockNetherbrickChiseled("chiseled_netherbrick", false);
        chiseledNetherbrickFilled = new BlockNetherbrickChiseled("chiseled_netherbrick_filled", true);

        // New Stone Blocks
        for (EnumNewStoneVariants newStoneVariant : EnumNewStoneVariants.values()) {
            newStoneVariants[newStoneVariant.getMetadata()] = new BlockOverworldBase(Material.ROCK, newStoneVariant.getName(), false);
        }
        for (EnumNewStoneVariantsSlabsAndStairs newStoneVariantsSlabsAndStairs : EnumNewStoneVariantsSlabsAndStairs.values()) {
            add(newStoneVariantsSlabsAndStairs.getName(), newStoneVariants[newStoneVariantsSlabsAndStairs.getMetadata()], Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
        }
        GameRegistry.addSmelting(newStoneVariants[4], new ItemStack(newStoneVariants[1], 4), 2F);
        add("stone", Blocks.STONE, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("stone_granite", Blocks.STONE, Material.ROCK, 1, false, true, OVERWORLD_EXPANSION_TAB);
        add("stone_andesite", Blocks.STONE, Material.ROCK, 5, false, true, OVERWORLD_EXPANSION_TAB);
        add("andesite_bricks", NBlocks.newStoneVariants[EnumNewStoneVariants.ANDESITE_BRICKS.getMetadata()], Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("andesite_cobble", NBlocks.newStoneVariants[EnumNewStoneVariants.ANDESITE_COBBLE.getMetadata()], Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("granite_bricks", NBlocks.newStoneVariants[EnumNewStoneVariants.GRANITE_BRICKS.getMetadata()], Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("granite_cobble", NBlocks.newStoneVariants[EnumNewStoneVariants.GRANITE_COBBLE.getMetadata()], Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("end_bricks", Blocks.END_BRICKS, Material.ROCK, 0, false, true, END_EXPANSION_TAB);
        add("prismarine", Blocks.PRISMARINE, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("prismarine_bricks", Blocks.PRISMARINE, Material.ROCK, 1, false, true, OVERWORLD_EXPANSION_TAB);
        add("prismarine_dark", Blocks.PRISMARINE, Material.ROCK, 2, false, true, OVERWORLD_EXPANSION_TAB);
        add("red_nether_brick", Blocks.RED_NETHER_BRICK, Material.ROCK, 0, false, true, NETHER_EXPANSION_TAB);

        add("stone", Blocks.STONE, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
        add("stone_granite", Blocks.STONE, Material.ROCK, 1, true, false, OVERWORLD_EXPANSION_TAB);
        add("stone_andesite", Blocks.STONE, Material.ROCK, 5, true, false, OVERWORLD_EXPANSION_TAB);
        add("end_bricks", Blocks.END_BRICKS, Material.ROCK, 0, true, false, END_EXPANSION_TAB);
        add("prismarine", Blocks.PRISMARINE, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
        add("prismarine_bricks", Blocks.PRISMARINE, Material.ROCK, 1, true, false, OVERWORLD_EXPANSION_TAB);
        add("prismarine_dark", Blocks.PRISMARINE, Material.ROCK, 2, true, false, OVERWORLD_EXPANSION_TAB);
        add("red_nether_brick", Blocks.RED_NETHER_BRICK, Material.ROCK, 0, true, false, NETHER_EXPANSION_TAB);

        //Wood Blocks
        for (BlockPlanks.EnumType enumType : BlockPlanks.EnumType.values()) {
//            potterySpinner[enumType.getMetadata()] = new BlockPotteryClayMachine(enumType.getMetadata(), String.format("%s_pottery_clay_machine", enumType.getName()), false).setCreativeTab(WOOD_EXPANSION_TAB);
//            potterySpinnerActive[enumType.getMetadata()] = new BlockPotteryClayMachine(enumType.getMetadata(), String.format("%s_pottery_clay_machine_active", enumType.getName()), true).setCreativeTab(null);
            barkBlocks[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, String.format("%s_wood", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            add(String.format("%s_wood", enumType.getName()), barkBlocks[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//            addWall(String.format("%s_bark", enumType.getName()), barkBlocks[enumType.getMetadata()], Material.WOOD, 0, WOOD_EXPANSION_TAB);
//            addFenceAndFenceGate(enumType, String.format("%s_bark", enumType.getName()), barkBlocks[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//            addFenceAndFenceGate(enumType, String.format("stripped_%s_bark", enumType.getName()), strippedBarkBlocks[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//            addFenceAndFenceGate(enumType, String.format("stripped_%s_log", enumType.getName()), strippedLogs[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
            chiseledBarkBlocks[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, String.format("%s_bark_chiseled", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            unnamedChiseledBarkBlock[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, String.format("unnamed_%s_bark_chiseled", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            logPoles[enumType.getMetadata()] = new BlockRodBase(String.format("%s_log_pole", enumType.getName()), WOOD_EXPANSION_TAB, false);
            strippedLogs[enumType.getMetadata()] = new BlockModPillar(String.format("stripped_%s_log", enumType.getName()), Material.WOOD).setCreativeTab(WOOD_EXPANSION_TAB);
            strippedBarkBlocks[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, String.format("stripped_%s_bark", enumType.getName()), true).setCreativeTab(WOOD_EXPANSION_TAB);
            strippedLogPoles[enumType.getMetadata()] = new BlockRodBase(String.format("stripped_%s_log_pole", enumType.getName()), WOOD_EXPANSION_TAB, false);
            add(String.format("stripped_%s_log", enumType.getName()), strippedLogs[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
            add(String.format("stripped_%s_wood", enumType.getName()), strippedLogs[enumType.getMetadata()], Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//            logDowels[enumType.getMetadata()] = new BlockRodBase(String.format("%s_log_dowel", enumType.getName()), WOOD_EXPANSION_TAB, false);
//            strippedLogDowels[enumType.getMetadata()] = new BlockRodBase(String.format("stripped_%s_log_dowel", enumType.getName()), WOOD_EXPANSION_TAB, false);
//            plankDowels[enumType.getMetadata()] = new BlockRodBase(String.format("%s_plank_dowel", enumType.getName()), WOOD_EXPANSION_TAB, false);
            plankPoles[enumType.getMetadata()] = new BlockRodBase(String.format("%s_plank_pole", enumType.getName()), WOOD_EXPANSION_TAB, false);
//            coffins[enumType.getMetadata()] = new BlockOverworldBase(Material.WOOD, enumType.getName() + "_coffin", true).setCreativeTab(WOOD_EXPANSION_TAB);
//            addWall(String.format("%s_plank", enumType.getName()), Blocks.PLANKS, enumType.getMetadata(), WOOD_EXPANSION_TAB);
            ItemStack log = ProxyRegistry.newStack(enumType.getMetadata() > 3 ? Blocks.LOG2 : Blocks.LOG, 1, enumType.getMetadata() % 4);
            RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(strippedLogs[enumType.getMetadata()], 1), log, NItems.logStripper);
            RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(strippedBarkBlocks[enumType.getMetadata()], 1), ProxyRegistry.newStack(barkBlocks[enumType.getMetadata()], 1), NItems.logStripper);
            RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(chiseledBarkBlocks[enumType.getMetadata()], 1), ProxyRegistry.newStack(barkBlocks[enumType.getMetadata()], 1), NItems.chisel);
        }
        add("oak_log", Blocks.LOG, Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
        add("spruce_log", Blocks.LOG, Material.WOOD, 1, true, true, WOOD_EXPANSION_TAB);
        add("birch_log", Blocks.LOG, Material.WOOD, 2, true, true, WOOD_EXPANSION_TAB);
        add("jungle_log", Blocks.LOG, Material.WOOD, 3, true, true, WOOD_EXPANSION_TAB);
        add("acacia_log", Blocks.LOG2, Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
        add("dark_oak_log", Blocks.LOG2, Material.WOOD, 1, true, true, WOOD_EXPANSION_TAB);
//        addWall("oak_log", Blocks.LOG, Material.WOOD, 0, WOOD_EXPANSION_TAB);
//        addWall("spruce_log", Blocks.LOG, 1, WOOD_EXPANSION_TAB);
//        addWall("birch_log", Blocks.LOG, 2, WOOD_EXPANSION_TAB);
//        addWall("jungle_log", Blocks.LOG, 3, WOOD_EXPANSION_TAB);
//        addWall("acacia_log", Blocks.LOG2, Material.WOOD, 0, WOOD_EXPANSION_TAB);
//        addWall("dark_oak_log", Blocks.LOG2, 1, WOOD_EXPANSION_TAB);
//        addFenceAndFenceGate(BlockPlanks.EnumType.OAK, "oak_log", Blocks.LOG, Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//        addFenceAndFenceGate(BlockPlanks.EnumType.SPRUCE, "spruce_log", Blocks.LOG, 1, true, true, WOOD_EXPANSION_TAB);
//        addFenceAndFenceGate(BlockPlanks.EnumType.BIRCH, "birch_log", Blocks.LOG, 2, true, true, WOOD_EXPANSION_TAB);
//        addFenceAndFenceGate(BlockPlanks.EnumType.JUNGLE, "jungle_log", Blocks.LOG, 3, true, true, WOOD_EXPANSION_TAB);
//        addFenceAndFenceGate(BlockPlanks.EnumType.ACACIA, "acacia_log", Blocks.LOG2, Material.WOOD, 0, true, true, WOOD_EXPANSION_TAB);
//        addFenceAndFenceGate(BlockPlanks.EnumType.DARK_OAK, "dark_oak_log", Blocks.LOG2, 1, true, true, WOOD_EXPANSION_TAB);

        // Frosted versions of vanilla stones & dirt
        for (EnumDyeColor dyeColor : EnumDyeColor.values()) {
            frostedClay[dyeColor.getMetadata()] = new BlockOverworldBase(Material.ROCK, String.format("frozen_%s_terracotta", dyeColor.getName()), false);
//            coloredVases[dyeColor.getMetadata()] = new BlockColoredVase(EnumDyeColor.byMetadata(dyeColor.getMetadata()));
//            terracottaPots[dyeColor.getMetadata()] = new BlockColoredFlowerPot(EnumDyeColor.byMetadata(dyeColor.getMetadata()));
//            glazedTerracottaPillar[dyeColor.getMetadata()] = new BlockModPillar(String.format("%s_glazed_terracotta_pillar", dyeColor.getName()), Material.ROCK);
//            terracottaPillar[dyeColor.getMetadata()] = new BlockModPillar(String.format("%s_terracotta_pillar", dyeColor.getName()), Material.ROCK);
            add(String.format("frozen_%s_terracotta", dyeColor.getName()), frostedClay[dyeColor.getMetadata()], Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
            add(String.format("%s_terracotta", dyeColor.getName()), Blocks.STAINED_HARDENED_CLAY, Material.ROCK, dyeColor.getMetadata(), true, false, OVERWORLD_EXPANSION_TAB);
            add(String.format("%s_glazed_terracotta", dyeColor.getName()), Objects.requireNonNull(Block.getBlockFromName(String.format("minecraft:%s_glazed_terracotta", dyeColor.getName()))), Material.ROCK, dyeColor.getMetadata(), true, false, OVERWORLD_EXPANSION_TAB);
            add(String.format("%s_terracotta", dyeColor.getName()), Blocks.STAINED_HARDENED_CLAY, Material.ROCK, dyeColor.getMetadata(), false, true, OVERWORLD_EXPANSION_TAB);
            coloredCandles[dyeColor.getMetadata()] = new BlockColoredCandles(dyeColor, false);
            coloredPlanks[dyeColor.getMetadata()] = new BlockColoredAlt(MOD_ID, "colored_plank", dyeColor).setCreativeTab(NCreativeTabs.WOOD_EXPANSION_TAB);
//            coloredPlanksStair[dyeColor.getMetadata()] = new BlockOverworldColoredStair("colored_plank_stair", coloredPlanksStair[dyeColor.getMetadata()].getDefaultState(), dyeColor, NCreativeTabs.WOOD_EXPANSION_TAB);
//            BlockModColoredStairs.initStairs(coloredPlanks[dyeColor.getMetadata()], 0, (BlockStairs) coloredPlanksStair[dyeColor.getMetadata()]);
            coloredPlanksSlabSingle[dyeColor.getMetadata()] = new BlockOverworldColoredSlab("colored_plank_slab", MOD_ID, dyeColor, Material.WOOD, false).setCreativeTab(NCreativeTabs.WOOD_EXPANSION_TAB);
            coloredPlanksSlabDouble[dyeColor.getMetadata()] = new BlockOverworldColoredSlab("colored_plank_slab", MOD_ID, dyeColor, Material.WOOD, true).setCreativeTab(NCreativeTabs.WOOD_EXPANSION_TAB);
            BlockModColoredSlab.initSlab(coloredPlanks[dyeColor.getMetadata()], 0, (BlockModColoredSlab) coloredPlanksSlabSingle[dyeColor.getMetadata()], (BlockModColoredSlab) coloredPlanksSlabDouble[dyeColor.getMetadata()]);
            coloredLitCandles[dyeColor.getMetadata()] = new BlockColoredCandles(dyeColor, true);
            coloredLanterns[dyeColor.getMetadata()] = new BlockColoredLanterns(dyeColor, false);
            coloredLitLanterns[dyeColor.getMetadata()] = new BlockColoredLanterns(dyeColor, true);
            coloredRedstoneLamp[dyeColor.getMetadata()] = new BlockColoredRedstoneLamp(dyeColor, false);
            coloredLitRedstoneLamp[dyeColor.getMetadata()] = new BlockColoredRedstoneLamp(dyeColor, true);
            coloredSlimeBlock[dyeColor.getMetadata()] = new BlockColoredSlime(dyeColor);
            add(String.format("%s_glass", dyeColor.getName()), Blocks.STAINED_GLASS, Material.GLASS, dyeColor.getMetadata(), true, false, NCreativeTabs.OVERWORLD_EXPANSION_TAB);
            centeredGlazedTerracottaBlocks[dyeColor.getMetadata()] = new BlockOverworldBase(Material.ROCK, String.format("centered_glazed_terracotta_%s", dyeColor.getName()), false);
        }

        //Misc
        fireflyBulbOff = new BlockFireflyBulb(false);
        fireflyBulbOn = new BlockFireflyBulb(true);

        smoothQuartz = new BlockOverworldBase(Material.ROCK, "smooth_quartz", false);
        smoothRedSandstone = new BlockOverworldBase(Material.ROCK, "smooth_red_sandstone", false);
        smoothSandstone = new BlockOverworldBase(Material.ROCK, "smooth_sandstone", false);

        quartzBricks = new BlockOverworldBase(Material.ROCK, "quartz_bricks", false);
        redSandstoneBricks = new BlockOverworldBase(Material.ROCK, "red_sandstone_bricks", false);
        sandstoneBricks = new BlockOverworldBase(Material.ROCK, "sandstone_bricks", false);

        add("smooth_quartz", smoothQuartz, Material.ROCK, 0, true, false, NCreativeTabs.OVERWORLD_EXPANSION_TAB);
        add("smooth_red_sandstone", smoothRedSandstone, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
        add("smooth_sandstone", smoothSandstone, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);

        add("quartz_bricks", quartzBricks, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
        add("red_sandstone_bricks", redSandstoneBricks, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);
        add("sandstone_bricks", sandstoneBricks, Material.ROCK, 0, true, false, OVERWORLD_EXPANSION_TAB);

        add("smooth_quartz", smoothQuartz, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("smooth_red_sandstone", smoothRedSandstone, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("smooth_sandstone", smoothSandstone, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);

        add("quartz_bricks", quartzBricks, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("red_sandstone_bricks", redSandstoneBricks, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);
        add("sandstone_bricks", sandstoneBricks, Material.ROCK, 0, false, true, OVERWORLD_EXPANSION_TAB);

        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(smoothSandstone, 8),
                "SSS", "S S", "SSS",
                'S', ProxyRegistry.newStack(Blocks.SANDSTONE));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(sandstoneBricks, 4),
                "SS", "SS",
                'S', ProxyRegistry.newStack(smoothSandstone, 1));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(smoothRedSandstone, 8),
                "SSS", "S S", "SSS",
                'S', ProxyRegistry.newStack(Blocks.RED_SANDSTONE));
        RecipeHandler.addOreDictRecipe(ProxyRegistry.newStack(redSandstoneBricks, 4),
                "SS", "SS",
                'S', ProxyRegistry.newStack(smoothRedSandstone, 1));

        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Blocks.SAND, 4),
                ProxyRegistry.newStack(Blocks.SANDSTONE, 1));

        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Blocks.SAND, 4),
                ProxyRegistry.newStack(Blocks.SANDSTONE, 1));

        RecipeHandler.addShapelessOreDictRecipe(ProxyRegistry.newStack(Blocks.STONE_SLAB.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.SAND).getBlock(), 4),
                ProxyRegistry.newStack(Blocks.SANDSTONE.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.CHISELED).getBlock(), 1));

        addWall("sandstone", Blocks.SANDSTONE, 0);
        addWall("chiseled_sandstone", Blocks.SANDSTONE, 1);
        addWall("smooth_sandstone", Blocks.SANDSTONE, 2);
        addWall("red_sandstone", Blocks.RED_SANDSTONE, 0);
        addWall("chiseled_red_sandstone", Blocks.RED_SANDSTONE, 1);
        addWall("smooth_red_sandstone", Blocks.RED_SANDSTONE, 2);

//        stoneAnvil = new BlockModAnvil("stone_anvil", OVERWORLD_EXPANSION_TAB);
//        carbonAnvil = new BlockModAnvil("carbon_anvil", OVERWORLD_EXPANSION_TAB);
//        goldenAnvil = new BlockModAnvil("golden_anvil", OVERWORLD_EXPANSION_TAB);
//        marbleAnvil = new BlockModAnvil("marble_anvil", OVERWORLD_EXPANSION_TAB);
//        ironAnvil = new BlockModAnvil("iron_anvil", OVERWORLD_EXPANSION_TAB);
//        darkIronAnvil = new BlockModAnvil("dark_iron_anvil", OVERWORLD_EXPANSION_TAB);

        blackSand = new BlockFalling("black_sand", OVERWORLD_EXPANSION_TAB);

        sandstonePillar = new MRPillar(Material.ROCK, "sandstone_pillar", OVERWORLD_EXPANSION_TAB, 0.8F, 4.0F);
        redSandstonePillar = new MRPillar(Material.ROCK, "red_sandstone_pillar", OVERWORLD_EXPANSION_TAB, 0.8F, 4.0F);
        chiseledPurpur = new BlockPurpurChiseled("purpur_chiseled", false);
        chiseledPurpurFilled = new BlockPurpurChiseled("purpur_chiseled_filled", true);
        chiseledBricks = new BlockBrickChiseled("chiseled_bricks", false);
        chiseledBricksFilled = new BlockBrickChiseled("chiseled_bricks_filled", true);

        scaffoldingBlock = new BlockScaffoldingBlock();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    public static void add(String name, Block block, Material material, int meta, CreativeTabs creativeTabs) {
        add(name, block, material, meta, true, true, creativeTabs);
    }

    public static void add(String name, Block block, Material material, int meta, boolean slabs, boolean stairs, CreativeTabs creativeTabs) {
        IBlockState state = block.getStateFromMeta(meta);
        String stairsName = name + "_stairs";
        String slabName = name + "_slab";

        if (stairs) {
            BlockModStairs.initStairs(block, meta, new BlockOverworldStairBase(stairsName, state, creativeTabs));
        }
        if (slabs) {
            BlockModSlab.initSlab(block, meta, new BlockOverworldSlabBase(slabName, material, false, creativeTabs), new BlockOverworldSlabBase(slabName, material, true, creativeTabs));
        }
    }

    public static void addWall(String name, Block block, int meta, CreativeTabs creativeTab) {
        addWall(name, block, meta, BlockModWall::new, creativeTab);
    }

    public static void addWall(String name, Block block, int meta) {
        addWall(name, block, meta, BlockModWall::new, CreativeTabs.DECORATIONS);
    }

    public static void addWall(String name, Block block, int meta, WallSupplier supplier, CreativeTabs creativeTab) {
        IBlockState state = block.getStateFromMeta(meta);
        String wallName = name + "_wall";
        BlockModWall.initWall(block, meta, supplier.supply(wallName, state).setCreativeTab(creativeTab));
    }

    public static void addFenceAndFenceGate(BlockPlanks.EnumType woodType, String name, Block block, int meta, boolean fence, boolean gate, CreativeTabs creativeTabs) {
        IBlockState state = block.getStateFromMeta(meta);

        if (fence) {
            new BlockModFence(block.getMaterial(state), MOD_ID, name + "_fence").setCreativeTab(creativeTabs);
        }
        if (gate) {
            new BlockModFenceGate(woodType, name + "_fence_gate").setCreativeTab(creativeTabs);
        }
    }

    public interface WallSupplier {
        BlockModWall supply(String wallName, IBlockState state);
    }

}