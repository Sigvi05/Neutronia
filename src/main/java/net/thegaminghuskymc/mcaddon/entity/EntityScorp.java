package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.mcaddon.entity.ai.EntityAIScorpAttack;
import net.thegaminghuskymc.mcaddon.entity.ai.EntityAIScorpTarget;
import net.thegaminghuskymc.mcaddon.util.handlers.LootTableHandler;

<<<<<<< HEAD
import java.util.Objects;

public class EntityScorp extends EntityMob
=======
/*
 *TODO:Optimize Mob, Add Custom Sounds, Add Animations
 */

public class EntityScorp extends EntitySpider
>>>>>>> 5f1d2f937279ddbf8c94a9a40841f09c781929c6
{
    private ResourceLocation loot_table = LootTableHandler.SCORP;

    public static final DataParameter<Boolean> TAIL_OUT = EntityDataManager.createKey(EntityScorp.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntityScorp.class, DataSerializers.BYTE);

    public EntityScorp(World worldIn)
    {
        super(worldIn);
    }

    protected ResourceLocation getLootTable() {
        return LootTableHandler.SCORP;
    }

    public void setLoot_table(ResourceLocation loot_table) { this.loot_table = loot_table; }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIScorpAttack(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this,0.8D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 7.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIScorpTarget<>(this, EntityPlayer.class));
    }

    protected PathNavigate createNavigator(World worldIn)
    {
        return new PathNavigateClimber(this, worldIn);
    }

    protected void applyEntityAI()
    {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityVillager.class, true));
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote)
        {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }
    }

    public void setBesideClimbableBlock(boolean climbing)
    {
        byte b0 = this.dataManager.get(CLIMBING);

        if (climbing)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 = (byte)(b0 & -2);
        }

        this.dataManager.set(CLIMBING, b0);
    }

    public float getEyeHeight()
    {
        return 0.65F;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0D);
    }

    public static void registerFixesScorp(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityScorp.class);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(TAIL_OUT, Boolean.valueOf(false));
        this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
    }

    public void setTailOut(boolean tailOut)
    {
        this.getDataManager().set(TAIL_OUT, tailOut);
    }

    @SideOnly(Side.CLIENT)
    public boolean isTailOut(){ return this.getDataManager().get(TAIL_OUT);}

    @Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return super.getExperiencePoints(player);
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key)
    {
        super.notifyDataManagerChange(key);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

<<<<<<< HEAD
    public void setLootTable(ResourceLocation loot_table)
    {
        this.loot_table = loot_table;
    }

=======
>>>>>>> 5f1d2f937279ddbf8c94a9a40841f09c781929c6
    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        if (super.attackEntityAsMob(entityIn))
        {
            if (entityIn instanceof EntityLivingBase)
            {
                ((EntityLivingBase)entityIn).addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionById(19)), 12 * 20, 0));
            }
            return true;
        } else
            return false;
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_SPIDER_STEP;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }

<<<<<<< HEAD
    public ResourceLocation getLootTable()
    {
        return loot_table;
    }

=======
>>>>>>> 5f1d2f937279ddbf8c94a9a40841f09c781929c6
    @Override
    public boolean getCanSpawnHere()
    {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && world.getBiome(new BlockPos(this)) == Biomes.DESERT || world.getBiome(new BlockPos(this)) == Biomes.DESERT_HILLS;
    }

}
