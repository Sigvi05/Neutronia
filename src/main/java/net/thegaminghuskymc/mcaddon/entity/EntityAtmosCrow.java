package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityAtmosCrow extends EntityLiving {

    public EntityAtmosCrow(World world1) {
        super(world1);
        setSize(0.5F, 0.5F);
        setCustomNameTag("Crow");
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

}
