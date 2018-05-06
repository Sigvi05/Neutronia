package net.hdt.neutronia.init;

import json_generator.JsonGenerator;
import net.hdt.neutronia.Main;
import net.hdt.neutronia.blocks.base.*;
import net.hdt.neutronia.blocks.nether.*;
import net.hdt.neutronia.blocks.overworld.*;
import net.hdt.neutronia.properties.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.huskylib2.blocks.BlockMod;
import net.thegaminghuskymc.huskylib2.blocks.BlockModSlab;
import net.thegaminghuskymc.huskylib2.blocks.BlockModStairs;
import net.thegaminghuskymc.huskylib2.compat.ModIntegrationHandler;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;

import static net.hdt.neutronia.util.Reference.MOD_ID;

public class HMBlocks {

    public static final BlockChest.Type CUSTOM_TYPE_QUARK = EnumHelper.addEnum(BlockChest.Type.class, "QUARK", new Class[0]);
    public static final BlockChest.Type CUSTOM_TYPE_QUARK_TRAP = EnumHelper.addEnum(BlockChest.Type.class, "QUARK_TRAP", new Class[0]);

    public static final ResourceLocation TRAP_RESOURCE = new ResourceLocation(MOD_ID, "textures/blocks/chests/trap.png");
    public static final ResourceLocation TRAP_DOUBLE_RESOURCE = new ResourceLocation(MOD_ID, "textures/blocks/chests/trap_double.png");
    public static final Block dried_kelp_block;
    public static final Block netherGlass, soulGlass, netherRod, netherSponge;
    public static final BlockFloorTile floorTile;
    // misc blocks
    public static final Block glowingGrass;
    public static final Block stoneAnvil, carbonAnvil, goldenAnvil, marbleAnvil, ironAnvil;
    public static final Block stoneCauldron, carbonCauldron, goldenCauldron, marbleCauldron, ironCauldron, glassCauldron;
    //    public static final BlockWorkbench craftingTable;
    //Wood Blocks
    public static BlockCustomChest customChest, prismarineChest;
    public static BlockCustomChest prismarineChestTrap, customChestTrap;
    public static BlockMod custom_bookshelf;
    public static Block spruce_trapdoor, birch_trapdoor, jungle_trapdoor, acacia_trapdoor, dark_oak_trapdoor;
    // Sea Blocks
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
    public static Block[] brainCoralStair = new Block[5];
    public static Block[] deadBrainCoralStair = new Block[5];
    public static Block[] coralStair = new Block[5];
    public static Block[] deadCoralStair = new Block[5];
    public static Block[] brainCoralFence = new Block[5];
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
    public static Block[] aquamarineSlabs = new Block[6];
    public static Block[] naturalAquamarineSlabsDouble = new Block[6];
    public static Block[] aquamarineSlabsDouble = new Block[6];
    public static Block[] coralPlants = new Block[16];
    //Stone Blocks
    public static Block[] newStoneVariants = new Block[30];
    public static Block[] newStoneVariantStairs = new Block[30];
    public static Block[] newStoneVariantSlabs = new Block[30];
    public static Block[] newStoneVariantSlabsDouble = new Block[30];
    //Blocks for the nether
    public static Block[] netherBlocks = new Block[2];
    public static Block[] glowingNetherBlocks = new Block[24];
    public static Block[] soulStone = new Block[4];
    public static Block[] soulStoneStairs = new Block[4];
    public static Block[] soulStoneSlabs = new Block[4];
    public static Block[] soulStoneSlabsDouble = new Block[4];
    public static Block[] soulStoneFences = new Block[4];
    public static Block[] soulStoneFenceGates = new Block[4];
    public static Block[] netherPlants = new Block[3];
    public static Block[] tallNetherPlants = new Block[2];
    //Frosted versions of some blocks
    public static Block[] frostedStones = new Block[25];
    public static Block[] frostedStonesStairs = new Block[25];
    public static Block[] frostedStonesSlabs = new Block[25];
    public static Block[] frostedStonesSlabsDouble = new Block[25];
    public static Block[] frostedDirts = new Block[25];
    public static Block[] frostedDirtStairs = new Block[25];
    public static Block[] frostedDirtSlabs = new Block[25];
    public static Block[] frostedDirtSlabsDouble = new Block[25];
    public static Block[] frostedClay = new Block[25];
    public static Block[] frostedClayStairs = new Block[25];
    public static Block[] frostedClaySlabs = new Block[25];
    public static Block[] frostedClaySlabsDouble = new Block[25];
    // New Stairs and slabs
    public static Block[] stoneStairs = new Block[7];
    public static Block[] terracottaStairs = new Block[16];
    public static Block[] woolStairs = new Block[16];
    public static Block[] glazedTerracottaStairs = new Block[16];
    public static Block[] coloredGlassStairs = new Block[16];
    public static Block[] stoneSlabs = new Block[7];
    public static Block[] stoneSlabsDouble = new Block[7];
    public static Block[] terracottaSlabs = new Block[16];
    public static Block[] terracottaSlabsDouble = new Block[16];
    public static Block[] woolSlabs = new Block[16];
    public static Block[] woolSlabsDouble = new Block[16];
    public static Block[] glazedTerracottaSlabs = new Block[16];
    public static Block[] glazedTerracottaSlabsDouble = new Block[16];
    public static Block[] coloredGlassSlabs = new Block[16];
    public static Block[] coloredGlassSlabsDouble = new Block[16];
    // Some colored blocks
    public static Block[] coloredSand = new Block[16];
    public static Block[] coloredCandles = new Block[16];
    public static Block[] coloredLanterns = new Block[16];
    public static Block[] coloredRedstoneLamp = new Block[16];
    public static BlockMod stained_clay_tiles, stained_planks, hardened_clay_tiles;
    public static BlockColoredVase[] pots = new BlockColoredVase[16];

    static {

        for (EnumCoralColor coralColor : EnumCoralColor.values()) {
            brain_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "brain_coral");
            dead_brain_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "brain_coral_dead");
            normal_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "coral");
            dead_normal_coral[coralColor.getMetadata()] = new BlockColoredWaterBlockBase(coralColor, "dead_coral");
            coral_fan[coralColor.getMetadata()] = new BlockColoredWaterPlantBase(coralColor, "coral_fan");
            /*dead_coral_fan[coralColor.getMetadata()] = new BlockColoredWaterPlantBase(coralColor, "dead_coral_fan");
            pipe_coral[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "pipe_coral");
            dead_pipe_coral[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "dead_coral_plant");
            sea_fan[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "sea_fan");
            dead_sea_fan[coralColor.getMetadata()] = new BlockNetherDoublePlantBase(coralColor, "dead_sea_fan");*/

            brainCoralFence[coralColor.getMetadata()] = new BlockModFence(Material.CORAL, MOD_ID, coralColor.getName() + "_brain_coral").setCreativeTab(Main.OVERWORLD_EXPANSION_TAB);

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
            aquamarineSlabs[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_slab", Material.ROCK, false);
            aquamarineSlabsDouble[aquamarineVariants.ordinal()] = new BlockOverworldSlabBase(aquamarineVariants.getName() + "_slab", Material.ROCK, true);
            BlockModSlab.initSlab(aquamarine[aquamarineVariants.ordinal()], aquamarineVariants.ordinal(), (BlockModSlab) aquamarineSlabs[aquamarineVariants.ordinal()], (BlockModSlab) aquamarineSlabsDouble[aquamarineVariants.ordinal()]);
        }
        for (EnumNaturalAquamarineVariants naturalAquamarineVariants : EnumNaturalAquamarineVariants.values()) {
            naturalAquamarine[naturalAquamarineVariants.getID()] = new BlockOverworldBase(Material.ROCK, naturalAquamarineVariants.getName());
            /*naturalAquamarineStairs[naturalAquamarineVariants.getID()] = new BlockOverworldStairBase(naturalAquamarineVariants.getName(), naturalAquamarine[naturalAquamarineVariants.getID()].getDefaultState());
            BlockModStairs.initStairs(naturalAquamarine[naturalAquamarineVariants.getID()], naturalAquamarineVariants.getID(), (BlockModStairs) naturalAquamarineStairs[naturalAquamarineVariants.getID()]);*/
            naturalAquamarineSlabs[naturalAquamarineVariants.getID()] = new BlockOverworldSlabBase(naturalAquamarineVariants.getName() + "_slab", Material.ROCK, false);
            naturalAquamarineSlabsDouble[naturalAquamarineVariants.getID()] = new BlockOverworldSlabBase(naturalAquamarineVariants.getName() + "_slab", Material.ROCK, true);
            BlockModSlab.initSlab(naturalAquamarine[naturalAquamarineVariants.getID()], naturalAquamarineVariants.getID(), (BlockModSlab) naturalAquamarineSlabs[naturalAquamarineVariants.getID()], (BlockModSlab) naturalAquamarineSlabsDouble[naturalAquamarineVariants.getID()]);
        }
        for (EnumCoralTypes coralTypes : EnumCoralTypes.values()) {
            coralPlants[coralTypes.getID()] = new BlockCoralPlantBase(coralTypes.getName());
        }
        dried_kelp_block = new BlockOverworldBase(Material.LEAVES, "dried_kelp_block");
        prismarineChest = new BlockCustomChest("prismarine_chest", BlockChest.Type.BASIC);
        prismarineChestTrap = new BlockCustomChest("prismarine_chest_trap", BlockChest.Type.TRAP);

        //Wood Blocks
        customChest = new BlockCustomChest("wooden_chest", CUSTOM_TYPE_QUARK);
        customChestTrap = new BlockCustomChest("wooden_chest_trap", CUSTOM_TYPE_QUARK_TRAP);
        for (EnumWoodType type : EnumWoodType.values()) {
            custom_bookshelf = new BlockCustomBookshelf(type.getName());
        }
        spruce_trapdoor = new BlockModTrapdoor("spruce_trapdoor");
        birch_trapdoor = new BlockModTrapdoor("birch_trapdoor");
        jungle_trapdoor = new BlockModTrapdoor("jungle_trapdoor");
        acacia_trapdoor = new BlockModTrapdoor("acacia_trapdoor");
        dark_oak_trapdoor = new BlockModTrapdoor("dark_oak_trapdoor");
        Blocks.TRAPDOOR.setUnlocalizedName("oak_trapdoor");

        // Nether Blocks
        for (EnumNetherBlocks netherBlockTypes : EnumNetherBlocks.values()) {
            netherBlocks[netherBlockTypes.getMetadata()] = new BlockNetherBase(Material.ROCK, netherBlockTypes.getName());
        }
        for (EnumSoulStoneTypes soulStoneTypes : EnumSoulStoneTypes.values()) {
            soulStone[soulStoneTypes.getMetadata()] = new BlockSoulStone(soulStoneTypes.getName());
            soulStoneSlabs[soulStoneTypes.getMetadata()] = new BlockNetherSlabBase(soulStoneTypes.getName() + "_slab", false);
            soulStoneSlabsDouble[soulStoneTypes.getMetadata()] = new BlockNetherSlabBase(soulStoneTypes.getName() + "_slab", true);
            BlockModSlab.initSlab(soulStone[soulStoneTypes.getMetadata()], soulStoneTypes.getMetadata(), (BlockModSlab) soulStoneSlabs[soulStoneTypes.getMetadata()], (BlockModSlab) soulStoneSlabsDouble[soulStoneTypes.getMetadata()]);
        }
        for (EnumGlowingNetherBlocks enumGlowingNetherBlocks : EnumGlowingNetherBlocks.values()) {
            glowingNetherBlocks[enumGlowingNetherBlocks.getMetadata()] = new BlockNetherGlowingBase(Material.GLASS, enumGlowingNetherBlocks.getName());
        }
        for (EnumNetherPlantTypes netherPlantTypes : EnumNetherPlantTypes.values()) {
            netherPlants[netherPlantTypes.getID()] = new BlockNetherPlantBase(netherPlantTypes.getName());
        }
        for (EnumTallNetherPlantTypes netherPlantTypes : EnumTallNetherPlantTypes.values()) {
            tallNetherPlants[netherPlantTypes.getID()] = new BlockNetherDoublePlantBase(netherPlantTypes.getName());
        }
        netherGlass = new BlockGlassBase("nether_glass").setCreativeTab(Main.NETHER_EXPANSION_TAB);
        soulGlass = new BlockGlassBase("soul_glass").setCreativeTab(Main.NETHER_EXPANSION_TAB);
        netherRod = new BlockRodBase("nether_rod", Main.NETHER_EXPANSION_TAB);
        netherSponge = new BlockNetherSponge();

        // New Stone Blocks
        for (EnumNewStoneVariants newStoneVariant : EnumNewStoneVariants.values()) {
            newStoneVariants[newStoneVariant.getMetadata()] = new BlockOverworldBase(Material.ROCK, newStoneVariant.getName());
            newStoneVariantStairs[newStoneVariant.getMetadata()] = new BlockOverworldStairBase(newStoneVariant.getName() + "_stairs", newStoneVariants[newStoneVariant.getMetadata()].getDefaultState());
            BlockModStairs.initStairs(newStoneVariants[newStoneVariant.getMetadata()], newStoneVariant.getMetadata(), (BlockModStairs) newStoneVariantStairs[newStoneVariant.getMetadata()]);
            newStoneVariantSlabs[newStoneVariant.getMetadata()] = new BlockOverworldSlabBase(newStoneVariant.getName() + "_slab", Material.ROCK, false);
            newStoneVariantSlabsDouble[newStoneVariant.getMetadata()] = new BlockOverworldSlabBase(newStoneVariant.getName() + "_slab", Material.ROCK, true);
            BlockModSlab.initSlab(newStoneVariants[newStoneVariant.getMetadata()], newStoneVariant.getMetadata(), (BlockModSlab) newStoneVariantSlabs[newStoneVariant.getMetadata()], (BlockModSlab) newStoneVariantSlabsDouble[newStoneVariant.getMetadata()]);
        }

        // Frosted versions of vanilla stones & dirt
        for (EnumFrostedStoneVariants frostedStoneVariants : EnumFrostedStoneVariants.values()) {
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
        }
        for (EnumDyeColor dyeColor : EnumDyeColor.values()) {
            frostedClay[dyeColor.getMetadata()] = new BlockOverworldBase(Material.ROCK, "frosted_" + dyeColor.getName() + "_terracotta");
            frostedClaySlabs[dyeColor.getMetadata()] = new BlockOverworldSlabBase("frosted_" + dyeColor.getName() + "_terracotta_slab", Material.ICE, false);
            frostedClaySlabsDouble[dyeColor.getMetadata()] = new BlockOverworldSlabBase("frosted_" + dyeColor.getName() + "_terracotta_slab", Material.ICE, true);
            BlockModSlab.initSlab(newStoneVariants[dyeColor.getMetadata()], dyeColor.getMetadata(), (BlockModSlab) frostedClaySlabs[dyeColor.getMetadata()], (BlockModSlab) frostedClaySlabsDouble[dyeColor.getMetadata()]);
            pots[dyeColor.getMetadata()] = new BlockColoredVase(EnumDyeColor.byMetadata(dyeColor.getMetadata()));
        }

        // New stairs & slabs and also new colored blocks
        for (EnumDyeColor color : EnumDyeColor.values()) {
            /*terracottaStairs[color.getMetadata()] = new BlockOverworldStairBase(color.getName() + "_terracotta_stairs", Blocks.STAINED_HARDENED_CLAY.getDefaultState());
            BlockModStairs.initStairs(Blocks.STAINED_HARDENED_CLAY, color.getMetadata(), (BlockModStairs) terracottaStairs[color.getMetadata()]);
            woolStairs[color.getMetadata()] = new BlockOverworldStairBase(color.getName() + "_wool_stairs", Blocks.WOOL.getDefaultState());
            BlockModStairs.initStairs(Blocks.WOOL, color.getMetadata(), (BlockModStairs) woolStairs[color.getMetadata()]);
            glazedTerracottaStairs[color.getMetadata()] = new BlockOverworldStairBase(color.getName() + "_glazed_terracotta_stairs", Block.getBlockFromName("minecraft:" + color.getName() + "_glazed_terracotta").getDefaultState());
            BlockModStairs.initStairs(Block.getBlockFromName("minecraft:" + color.getName() + "_glazed_terracotta"), color.getMetadata(), (BlockModStairs) glazedTerracottaStairs[color.getMetadata()]);
            coloredGlassStairs[color.getMetadata()] = new BlockOverworldStairBase(color.getName() + "_glass_stairs", Blocks.STAINED_GLASS.getDefaultState());
            BlockModStairs.initStairs(Blocks.STAINED_GLASS, color.getMetadata(), (BlockModStairs) coloredGlassStairs[color.getMetadata()]);
            terracottaSlabs[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_terracotta_slab", Material.ROCK, false);
            terracottaSlabsDouble[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_terracotta_slab", Material.ROCK, true);
            BlockModSlab.initSlab(Blocks.STAINED_HARDENED_CLAY, color.getMetadata(), (BlockModSlab) terracottaSlabs[color.getMetadata()], (BlockModSlab) terracottaSlabsDouble[color.getMetadata()]);
            woolSlabs[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_wool_slab", Material.CLOTH, false);
            woolSlabsDouble[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_wool_slab", Material.CLOTH, true);
            BlockModSlab.initSlab(Blocks.WOOL, color.getMetadata(), (BlockModSlab) woolSlabs[color.getMetadata()], (BlockModSlab) woolSlabsDouble[color.getMetadata()]);
            glazedTerracottaSlabs[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_glazed_terracotta_slab", Material.ROCK, false);
            glazedTerracottaSlabsDouble[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_glazed_terracotta_slab", Material.ROCK, true);
            BlockModSlab.initSlab(Block.getBlockFromName("minecraft:" + color.getName() + "_glazed_terracotta"), color.getMetadata(), (BlockModSlab) glazedTerracottaSlabs[color.getMetadata()], (BlockModSlab) glazedTerracottaSlabsDouble[color.getMetadata()]);
            coloredGlassSlabs[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_glass_slab", Material.GLASS, false);
            coloredGlassSlabsDouble[color.getMetadata()] = new BlockOverworldSlabBase(color.getName() + "_glass_slab", Material.GLASS, true);
            BlockModSlab.initSlab(Blocks.STAINED_GLASS, color.getMetadata(), (BlockModSlab) coloredGlassSlabs[color.getMetadata()], (BlockModSlab) coloredGlassSlabsDouble[color.getMetadata()]);*/
            coloredSand[color.getMetadata()] = new BlockColoredAlt(MOD_ID, "sand", color);
            /*coloredCandles[color.getMetadata()] = new BlockColoredLightSourceWithParticlesAlt(MOD_ID, "candles", color);
            coloredLanterns[color.getMetadata()] = new BlockColoredLightSourceWithParticlesAlt(MOD_ID, "lanterns", color);
            coloredRedstoneLamp[color.getMetadata()] = new BlockColoredRedstoneLamp(color);*/
        }
        floorTile = new BlockFloorTile();
        /*hardened_clay_tiles = new BlockHardenedClayTiles();

        BlockModStairs.initStairs(hardened_clay_tiles, 0, new BlockHardenedClayTilesStairs());
        BlockModSlab.initSlab(hardened_clay_tiles, 0, new BlockHardenedClayTilesSlab(false), new BlockHardenedClayTilesSlab(true));

        stained_clay_tiles = new BlockStainedClayTiles();

        for(BlockStainedClayTiles.Variants variant : BlockStainedClayTiles.Variants.class.getEnumConstants())
            BlockModStairs.initStairs(stained_clay_tiles, variant.ordinal(), new BlockStainedClayTilesStairs(variant));
        for(BlockStainedClayTiles.Variants variant : BlockStainedClayTiles.Variants.class.getEnumConstants())
            BlockModSlab.initSlab(stained_clay_tiles, variant.ordinal(), new BlockStainedClayTilesSlab(variant, false), new BlockStainedClayTilesSlab(variant, true));

        stained_planks = new BlockStainedPlanks();

        for(BlockStainedPlanks.Variants variant : BlockStainedPlanks.Variants.class.getEnumConstants())
            BlockModStairs.initStairs(stained_planks, variant.ordinal(), new BlockStainedPlanksStairs(variant));
        for(BlockStainedPlanks.Variants variant : BlockStainedPlanks.Variants.class.getEnumConstants())
            BlockModSlab.initSlab(stained_planks, variant.ordinal(), new BlockStainedPlanksSlab(variant, false), new BlockStainedPlanksSlab(variant, true));*/

        /*add("stone", Blocks.STONE, 0, false, true, stone);
        add("stone_granite", Blocks.STONE, 1, granite);
        add("stone_diorite", Blocks.STONE, 3, diorite);
        add("stone_andesite", Blocks.STONE, 5, andesite);
        add("end_bricks", Blocks.END_BRICKS, 0, endBricks);
        add("prismarine", Blocks.PRISMARINE, 0, prismarine);
        add("prismarine_bricks", Blocks.PRISMARINE, 1, prismarineBricks);
        add("prismarine_dark", Blocks.PRISMARINE, 2, darkPrismarine);
        add("red_nether_brick", Blocks.RED_NETHER_BRICK, 0, redNetherBricks);

        addWall("stone", Blocks.STONE, 0, stone);
        addWall("stone_granite", Blocks.STONE, 1, granite);
        addWall("stone_diorite", Blocks.STONE, 3, diorite);
        addWall("stone_andesite", Blocks.STONE, 5, andesite);
        addWall("sandstone", Blocks.SANDSTONE, 0, sandstone);
        addWall("red_sandstone", Blocks.RED_SANDSTONE, 0, redSandstone);
        addWall("stonebrick", Blocks.STONEBRICK, 0, stoneBricks);
        addWall("brick", Blocks.BRICK_BLOCK, 0, bricks);
        addWall("quartz", Blocks.QUARTZ_BLOCK, 0, quartz);
        addWall("prismarine_rough", Blocks.PRISMARINE, 0, prismarine);
        addWall("prismarine_bricks", Blocks.PRISMARINE, 1, prismarineBricks);
        addWall("dark_prismarine", Blocks.PRISMARINE, 2, darkPrismarine);
        addWall("purpur_block", Blocks.PURPUR_BLOCK, 0, purpurBlock);
        addWall("end_bricks", Blocks.END_BRICKS, 0, endBricks);*/

        glowingGrass = new BlockGlowingGrass();

        stoneAnvil = new BlockModAnvil("stone_anvil", Main.OVERWORLD_EXPANSION_TAB);
        carbonAnvil = new BlockModAnvil("carbon_anvil", Main.OVERWORLD_EXPANSION_TAB);
        goldenAnvil = new BlockModAnvil("golden_anvil", Main.OVERWORLD_EXPANSION_TAB);
        marbleAnvil = new BlockModAnvil("marble_anvil", Main.OVERWORLD_EXPANSION_TAB);
        ironAnvil = new BlockModAnvil("iron_anvil", Main.OVERWORLD_EXPANSION_TAB);

        stoneCauldron = new BlockModCauldron("stone_cauldron", Main.OVERWORLD_EXPANSION_TAB);
        carbonCauldron = new BlockModCauldron("carbon_cauldron", Main.OVERWORLD_EXPANSION_TAB);
        goldenCauldron = new BlockModCauldron("golden_cauldron", Main.OVERWORLD_EXPANSION_TAB);
        marbleCauldron = new BlockModCauldron("marble_cauldron", Main.OVERWORLD_EXPANSION_TAB);
        ironCauldron = new BlockModCauldron("iron_cauldron", Main.OVERWORLD_EXPANSION_TAB);
        glassCauldron = new BlockModCauldron("glass_cauldron", Main.OVERWORLD_EXPANSION_TAB);
//        craftingTable = new BlockWorkbench();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    private static void registerBlock(String name, String textureName) {
        JsonGenerator.genBlock(MOD_ID, name, textureName);
    }

    private static void registerRecipe(String name, boolean isShaped, String row1, String row2, String row3, String[] keys, String[] values, int[] data, String result, String group, int resultCount) {
        JsonGenerator.genRecipe(MOD_ID, name, isShaped, row1, row2, row3, keys, values, data, result, group, resultCount);
    }

    private static void registeChiselVariants(String group, Block block) {
        ModIntegrationHandler.registerChiselVariant(group, ProxyRegistry.newStack(block, 1, 0));
    }

    public static void add(String name, Block block, int meta) {
        add(name, block, meta, true, true);
    }

    public static void add(String name, Block block, int meta, boolean slab, boolean stairs) {
        IBlockState state = block.getStateFromMeta(meta);
        String stairsName = name;
        String slabName = name;

        if (stairs)
            BlockModStairs.initStairs(block, meta, new BlockOverworldStairBase(stairsName, state));
        if (slab)
            BlockModSlab.initSlab(block, meta, new BlockOverworldSlabBase(slabName, block.getMaterial(state), false), new BlockOverworldSlabBase(slabName, block.getMaterial(state), true));
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
