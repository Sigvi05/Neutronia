package net.hdt.neutronia.groups;

import net.hdt.neutronia.base.groups.Group;
import net.hdt.neutronia.groups.building.features.*;
import net.hdt.neutronia.groups.client.features.*;
import net.hdt.neutronia.groups.decoration.features.*;
import net.hdt.neutronia.groups.dimensions.features.MarsDimension;
import net.hdt.neutronia.groups.dimensions.features.MoonBiomes;
import net.hdt.neutronia.groups.dimensions.features.MoonDimension;
import net.hdt.neutronia.groups.dimensions.features.SunDimension;
import net.hdt.neutronia.groups.experimental.features.BiggerCaves;
import net.hdt.neutronia.groups.experimental.features.ColoredLights;
import net.hdt.neutronia.groups.management.features.BetterCraftShifting;
import net.hdt.neutronia.groups.management.features.FavoriteItems;
import net.hdt.neutronia.groups.management.features.RightClickAddToShulkerBox;
import net.hdt.neutronia.groups.tweaks.features.*;
import net.hdt.neutronia.groups.vanity.feature.DyableElytra;
import net.hdt.neutronia.groups.vanity.feature.DyeItemNames;
import net.hdt.neutronia.groups.vanity.feature.SitInStairs;
import net.hdt.neutronia.groups.world.features.*;
import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public class NGroups {

    public static Group building, client, decoration, dimensions, experimental, management, tweaks, vanity, world;

    public static void registerGroups() {
        building = Group.builder()
                .withName("Building")
                .withDesc("This group adds new structural building blocks and building utensils.")
                .withIcon(new ItemStack(Blocks.BRICK_BLOCK))
                .withComponent(new BarkBlocks())
                .withComponent(new CarvedWood())
                .withComponent(new LogBlocks())
                .withComponent(new MoreStoneBlocks())
                .withComponent(new VanillaStairsAndSlabs())
                .withComponent(new VanillaWalls())
                .withComponent(new WoodBlocks())
                .withComponent(new WorldStoneBricks())
                .isEnabled(true)
                .register();

        client = Group.builder()
                .withName("Client")
                .withDesc("This group adds components that alter the client, not needing Quark to be loaded on the server.")
                .withIcon(new ItemStack(Items.ENDER_EYE))
                .withComponent(new FoodTooltip())
                .withComponent(new GreenerGrass())
                .withComponent(new ImprovedSignEdit())
                .withComponent(new MapTooltip())
                .withComponent(new NewMenuScreenBackgrounds())
                .withComponent(new ShulkerBoxTooltip())
                .withComponent(new UsageTicker())
                .withComponent(new VisualStatDisplay())
                .isEnabled(true)
                .register();

        decoration = Group.builder()
                .withName("Decoration")
                .withDesc("This group adds new decorative building blocks and improves vanilla ones.")
                .withIcon(new ItemStack(Blocks.RED_FLOWER))
                .withComponent(new DecorativeCorals())
                .withComponent(new VariedTrapdoors())
                .withComponent(new MoreBanners())
                .withComponent(new NetherBrickFenceGate())
                .withComponent(new CharcoalBlock())
                .withComponent(new VariedBookshelves())
                .withComponent(new FlatItemFrames())
                .withComponent(new DecorativeAquamarine())
                .isEnabled(true)
                .register();

        dimensions = Group.builder()
                .withName("Dimensions")
                .withDesc("This group adds some new dimensions")
                .withIcon(new ItemStack(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.WHITE).getBlock()))
                .withComponent(new MarsDimension())
                .withComponent(new MoonBiomes())
                .withComponent(new MoonDimension())
                .withComponent(new SunDimension())
                .isEnabled(true)
                .register();

        experimental = Group.builder()
                .withName("Experimental")
                .withDesc("Experimental Features. All components in this group are disabled by default. Use at your own risk.")
                .withIcon(new ItemStack(Blocks.TNT))
                .withComponent(new BiggerCaves())
                .withComponent(new ColoredLights())
                .isEnabled(true)
                .register();

        management = Group.builder()
                .withName("Management")
                .withDesc("This module adds inventory management features.")
                .withIcon(new ItemStack(Items.BOOK))
                .withComponent(new FavoriteItems())
                .withComponent(new BetterCraftShifting())
                .withComponent(new RightClickAddToShulkerBox())
                .isEnabled(true)
                .register();

        tweaks = Group.builder()
                .withName("Tweaks")
                .withDesc("This module tweaks various gameplay elements.")
                .withIcon(new ItemStack(Items.IRON_PICKAXE))
                .withComponent(new ArmedArmorStands())
                .withComponent(new BabyZombiesBurn())
                .withComponent(new CompassesWorkEverywhere())
                .withComponent(new HoeSickle())
                .withComponent(new ImprovedSleeping())
                .withComponent(new ImprovedStoneToolCrafting())
                .withComponent(new RemoveSnowLayers())
                .withComponent(new SlabsToBlocks())
                .withComponent(new SquidsInkYou())
                .withComponent(new StackableItems())
                .withComponent(new StairsMakeMore())
                .withComponent(new TorchesBurnInFurnaces())
                .withComponent(new BlastproofShulkerBoxes())
                .withComponent(new ChickensShedFeathers())
                .withComponent(new AxesBreakLeaves())
                .withComponent(new ConvertClay())
                .withComponent(new ExtendedToolProgression())
                .isEnabled(true)
                .register();

        vanity = Group.builder()
                .withName("Vanity")
                .withDesc("This module tweaks various gameplay elements.")
                .withIcon(new ItemStack(Items.LEATHER_HELMET))
                .withComponent(new DyableElytra())
                .withComponent(new DyeItemNames())
                .withComponent(new SitInStairs())
                .isEnabled(true)
                .register();

        world = Group.builder()
                .withName("World")
                .withDesc("This module adds world generation features.")
                .withIcon(new ItemStack(Blocks.GRASS))
                .withComponent(new Corals())
                .withComponent(new NaturalAquamarine())
                .withComponent(new Basalt())
                .withComponent(new ClayGeneration())
                .withComponent(new OceanGuardians())
                .withComponent(new NaturalBlazesInNether())
                .withComponent(new MushroomsInSwamps())
                .withComponent(new BuriedTreasure())
                .withComponent(new RevampStoneGen())
                .withComponent(new CrystalCaves())
                .withComponent(new VariedDungeons())
                .withComponent(new UndergroundBiomes())
                .withComponent(new PathfinderMaps())
                .withComponent(new NetherFossils())
                .withComponent(new NetherMushrooms())
                .withComponent(new RealisticWorldType())
                .withComponent(new DefaultWorldOptions())
                .withComponent(new Speleothems())
                .withComponent(new BetterCaves())
                .isEnabled(true)
                .register();

        Group.builder()
                .withName("Example Group")
                .withDesc("This is an example group")
                .withIcon(new ItemStack(Blocks.STONE))
                .isEnabled(true)
                .register();

        Group.builder()
                .withName("Example Group 2")
                .withDesc("This is an example group")
                .withIcon(new ItemStack(Blocks.STONE))
                .isEnabled(true)
                .register();

        Group.builder()
                .withName("Example Group 3")
                .withDesc("This is an example group")
                .withIcon(new ItemStack(Blocks.STONE))
                .isEnabled(true)
                .register();
    }

}
