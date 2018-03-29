package net.thegaminghuskymc.mcaddon.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.thegaminghuskymc.mcaddon.entity.EntityScorp;

public class EntityAIScorpTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
{
    public EntityAIScorpTarget(EntityScorp scorp, Class<T> classTarget)
    {
        super(scorp, classTarget, true);
    }

    public boolean shouldExecute()
    {
        float f = this.taskOwner.getBrightness();
        return f >= 0.5F ? false : super.shouldExecute();
    }
}
