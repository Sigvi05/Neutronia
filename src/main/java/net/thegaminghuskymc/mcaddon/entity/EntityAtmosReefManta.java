package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.world.World;

public class EntityAtmosReefManta extends EntityWaterMob {

    public EntityAtmosReefManta(World world) {
        super(world);
        setSize(0.5F, 0.5F);
        setHealth(25);
    }

}
