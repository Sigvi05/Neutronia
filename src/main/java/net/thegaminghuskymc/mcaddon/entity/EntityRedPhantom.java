package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityRedPhantom extends EntityLiving {

    public EntityRedPhantom(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        setSize(0.5F, 0.5F);
    }

    protected void entityInit() {
        super.entityInit();
    }

}