package net.thegaminghuskymc.mcaddon.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.blocks.overworld.BlockCoral;
import net.thegaminghuskymc.mcaddon.blocks.overworld.BlockCoralPlant;
import net.thegaminghuskymc.mcaddon.blocks.overworld.BlockDoubleCoralPlant;
import net.thegaminghuskymc.mcaddon.blocks.overworld.BlockOverworldBase;
import net.thegaminghuskymc.mcaddon.properties.EnumCoralColor;

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
        }
        dried_kelp_block = new BlockOverworldBase(Material.LEAVES, "dried_kelp_block");
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

}
