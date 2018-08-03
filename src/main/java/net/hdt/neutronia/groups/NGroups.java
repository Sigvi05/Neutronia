package net.hdt.neutronia.groups;

import net.hdt.neutronia.base.groups.Group;
import net.hdt.neutronia.groups.building.features.*;
import net.hdt.neutronia.groups.client.features.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class NGroups {

    public static Group building, client, decoration, dimensions, experimental, management, tweaks, vanity, world;

    public static void registerGroups() {
        building = Group.builder()
                .withName("Building")
                .withDesc("This group adds new structural building blocks and building utensils.")
                .withIcon(new ItemStack(Items.IRON_PICKAXE))
                .withFeature(new BarkBlocks())
                .withFeature(new CarvedWood())
                .withFeature(new LogBlocks())
                .withFeature(new MoreStoneBlocks())
                .withFeature(new VanillaStairsAndSlabs())
                .withFeature(new VanillaWalls())
                .withFeature(new WoodBlocks())
                .withFeature(new WorldStoneBricks())
                .register();

        client = Group.builder()
                .withName("Client")
                .withDesc("This group adds features that alter the client, not needing Quark to be loaded on the server.")
                .withIcon(new ItemStack(Items.ENDER_EYE))
                .withFeature(new FoodTooltip())
                .withFeature(new GreenerGrass())
                .withFeature(new ImprovedSignEdit())
                .withFeature(new MapTooltip())
                .withFeature(new NewMenuScreenBackgrounds())
                .withFeature(new ShulkerBoxTooltip())
                .withFeature(new UsageTicker())
                .withFeature(new VisualStatDisplay())
                .register();

        decoration = Group.builder()
                .withName("Decoration")
                .withDesc("This group adds new decorative building blocks and improves vanilla ones.")
                .withIcon(new ItemStack(Blocks.RED_FLOWER))
                .register();

        Group.builder()
                .withName("Example Group")
                .withDesc("This is an example group")
                .withIcon(new ItemStack(Blocks.STONE))
                .register();
    }

}
