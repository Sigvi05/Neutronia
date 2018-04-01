package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityAtmosColourfulFish extends EntityLiving {

    private static final DataParameter<Integer> FISH_VARIANTS = EntityDataManager.createKey(EntityAtmosColourfulFish.class, DataSerializers.VARINT);

    public EntityAtmosColourfulFish(World world) {
        super(world);
        setSize(0.5F, 0.5F);
        setHealth(5);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
    }

}
