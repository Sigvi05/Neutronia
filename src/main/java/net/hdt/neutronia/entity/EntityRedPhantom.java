package net.hdt.neutronia.entity;

import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.world.World;

public class EntityRedPhantom extends EntityUndeadBase {

    public EntityRedPhantom(World worldIn) {
        super(worldIn);
        this.setHealth(this.getMaxHealth());
        setSize(0.5F, 0.5F);
    }

    protected void entityInit() {
        this.tasks.addTask(1, new EntityAILookIdle(this));
    }

}