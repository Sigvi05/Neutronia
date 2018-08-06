package net.hdt.neutronia.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.hdt.neutronia.base.lib.LibMisc.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class BWSounds {
    @GameRegistry.ObjectHolder("neutronia:block.wood.creak")
    public static SoundEvent WOODCREAK = null;
    @GameRegistry.ObjectHolder("neutronia:block.stone.grind")
    public static SoundEvent STONEGRIND = null;
    @GameRegistry.ObjectHolder("neutronia:block.wood.bellow")
    public static SoundEvent BELLOW = null;
    @GameRegistry.ObjectHolder("neutronia:block.wood.chime")
    public static SoundEvent WOODCHIME = null;
    @GameRegistry.ObjectHolder("neutronia:block.metal.chime")
    public static SoundEvent METALCHIME = null;
    @GameRegistry.ObjectHolder("neutronia:entity.player.oof")
    public static SoundEvent OOF = null;
    @GameRegistry.ObjectHolder("neutronia:block.metal.hacksaw")
    public static SoundEvent METAL_HACKSAW = null;
    @GameRegistry.ObjectHolder("neutronia:block.millstone.netherrack")
    public static SoundEvent MILLSTONE_NETHERRACK = null;
    @GameRegistry.ObjectHolder("neutronia:block.saw.cut")
    public static SoundEvent SAW_CUT = null;
    @GameRegistry.ObjectHolder("neutronia:block.bloodwood.break")
    public static SoundEvent BLOODWOOD_BREAK = null;

    @GameRegistry.ObjectHolder("neutronia:block.mechanical.overpower")
    public static SoundEvent MECHANICAL_OVERPOWER = null;

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(registerSound("block.wood.creak"));
        event.getRegistry().register(registerSound("block.stone.grind"));
        event.getRegistry().register(registerSound("block.wood.bellow"));
        event.getRegistry().register(registerSound("block.wood.chime"));
        event.getRegistry().register(registerSound("block.metal.chime"));
        event.getRegistry().register(registerSound("block.metal.hacksaw"));
        event.getRegistry().register(registerSound("block.millstone.netherrack"));
        event.getRegistry().register(registerSound("block.saw.cut"));
        event.getRegistry().register(registerSound("block.mechanical.overpower"));
        event.getRegistry().register(registerSound("entity.player.oof"));

    }

    public static SoundEvent registerSound(String soundName) {
        ResourceLocation soundID = new ResourceLocation(MOD_ID, soundName);
        SoundEvent sound = new SoundEvent(soundID).setRegistryName(soundID);
        return sound;
    }
}
