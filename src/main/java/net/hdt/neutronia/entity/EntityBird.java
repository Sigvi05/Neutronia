package net.hdt.neutronia.entity;

import net.minecraft.entity.EntityFlying;
import net.minecraft.world.World;

public class EntityBird extends EntityFlying {

    public EntityBird(World worldIn) {
        super(worldIn);
        setSize(0.5F, 0.5F);
    }

}
