package net.thegaminghuskymc.mcaddon;

import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thegaminghuskymc.mcaddon.init.BiomeInit;

public class TerrainEventHandlers {

    @SubscribeEvent
    public void onCreateDecorate(DecorateBiomeEvent.Decorate event) {
        World world = event.getWorld();
        if(world.getBiome(event.getPos()) == BiomeInit.BASALT) {
            if (!world.isRemote) {
                switch (event.getType()) {
                    case CLAY:
                        event.setResult(Event.Result.DENY);
                        break;
                    case DEAD_BUSH:
                        event.setResult(Event.Result.DENY);
                        break;
                    case ICE:
                        event.setResult(Event.Result.DENY);
                        break;
                    case LAKE_LAVA:
                        event.setResult(Event.Result.ALLOW);
                        break;
                    case ROCK:
                        event.setResult(Event.Result.DENY);
                        break;
                    case SAND:
                        event.setResult(Event.Result.DENY);
                        break;
                    case SAND_PASS2:
                        event.setResult(Event.Result.DENY);
                        break;
                    case CUSTOM:
                        break;
                    case FOSSIL:
                        event.setResult(Event.Result.DENY);
                        break;
                    case DESERT_WELL:
                        event.setResult(Event.Result.DENY);
                        break;
                    case LAKE_WATER:
                        event.setResult(Event.Result.DENY);
                        break;
                    case PUMPKIN:
                        event.setResult(Event.Result.DENY);
                        break;
                    case GRASS:
                        event.setResult(Event.Result.DENY);
                        break;
                    case SHROOM:
                        event.setResult(Event.Result.DENY);
                        break;
                    case BIG_SHROOM:
                        event.setResult(Event.Result.DENY);
                        break;
                    case CACTUS:
                        event.setResult(Event.Result.DENY);
                        break;
                    case REED:
                        event.setResult(Event.Result.DENY);
                        break;
                    case LILYPAD:
                        event.setResult(Event.Result.DENY);
                        break;
                    case FLOWERS:
                        event.setResult(Event.Result.DENY);
                        break;
                    case TREE:
                        event.setResult(Event.Result.DENY);
                        break;
                }
            }
        }
    }

}
