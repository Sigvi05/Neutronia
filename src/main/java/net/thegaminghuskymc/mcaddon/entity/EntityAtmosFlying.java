package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.world.World;

public class EntityAtmosFlying extends EntityAtmosCreature {

    public EntityAtmosFlying(World world) {
        super(world);
        flyingMode = true;
        speed = 1.0F;
        chanceFly = 200;
        chanceLand = 200;
        i = 0;
        j = 0;
        k = 0;
        wingSpeed = 0.4F;
    }

    public boolean isFlying()
    {
        return flyingMode;
    }

    protected boolean be()
    {
        return isFlying();
    }

    protected void a(float f)
    {
    }

    public boolean flyingMode;
    public float speed;
    public int chanceFly;
    public int chanceLand;
    int i;
    int j;
    int k;
    public float wingSpeed;
}
