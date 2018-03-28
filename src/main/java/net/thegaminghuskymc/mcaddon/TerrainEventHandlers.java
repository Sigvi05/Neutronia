package net.thegaminghuskymc.mcaddon;

import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.init.BiomeInit;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CUSTOM;

public class TerrainEventHandlers {

    @SubscribeEvent
    public void onCreateDecorate(DecorateBiomeEvent.Decorate event) {
        World world = event.getWorld();
        if(world.getBiome(event.getPos()) == BiomeInit.BASALT) {
            if (!world.isRemote) {
                if(event.getType() != CUSTOM) event.setResult(Event.Result.DENY);
            }
        }
    }

}
