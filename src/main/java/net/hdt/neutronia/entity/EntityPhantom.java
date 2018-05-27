package net.hdt.neutronia.entity;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.world.World;

public class EntityPhantom extends EntityUndeadBase {

    public EntityPhantom(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        setSize(0.5F, 0.5F);
    }

    protected void entityInit() {
        this.tasks.addTask(1, new EntityAILookIdle(this));
    }

}