/*
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.hdt.neutronia.entity;

import java.util.List;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIBreathAir;
import net.minecraft.entity.ai.EntityAIFindWater;
import net.minecraft.entity.ai.EntityAIFollowBoat;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIJump;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWanderSwim;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityDolphinHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.EntityMoveHelper.Action;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.MobEffects;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityDolphin extends EntityWaterMob {
    private static final DataParameter<BlockPos> field_208014_b;
    private static final DataParameter<Boolean> field_208013_bB;
    private static final DataParameter<Integer> field_211138_bB;
    public static final Predicate<EntityItem> field_205025_a;

    public EntityDolphin(World p_i48935_1_) {
        super(p_i48935_1_);
        this.setSize(0.9F, 0.6F);
        this.moveHelper = new EntityDolphin.MoveHelper(this);
        this.lookHelper = new EntityDolphinHelper(this, 10);
        this.setCanPickUpLoot(true);
    }

    @Nullable
    public IEntityLivingData func_204210_a(DifficultyInstance p_204210_1_, @Nullable IEntityLivingData p_204210_2_, @Nullable NBTTagCompound p_204210_3_) {
        this.setAir(this.getMaxAir());
        this.rotationPitch = 0.0F;
        return super.func_204210_a(p_204210_1_, p_204210_2_, p_204210_3_);
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    protected void func_209207_l(int p_209207_1_) {
    }

    public void func_208012_g(BlockPos p_208012_1_) {
        this.dataManager.set(field_208014_b, p_208012_1_);
    }

    public BlockPos func_208010_l() {
        return (BlockPos)this.dataManager.get(field_208014_b);
    }

    public boolean func_208011_dD() {
        return (Boolean)this.dataManager.get(field_208013_bB);
    }

    public void func_208008_s(boolean p_208008_1_) {
        this.dataManager.set(field_208013_bB, p_208008_1_);
    }

    public int func_211136_dB() {
        return (Integer)this.dataManager.get(field_211138_bB);
    }

    public void func_211137_b(int p_211137_1_) {
        this.dataManager.set(field_211138_bB, p_211137_1_);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(field_208014_b, BlockPos.ORIGIN);
        this.dataManager.register(field_208013_bB, false);
        this.dataManager.register(field_211138_bB, 2400);
    }

    public void writeEntityToNBT(NBTTagCompound p_writeEntityToNBT_1_) {
        super.writeEntityToNBT(p_writeEntityToNBT_1_);
        p_writeEntityToNBT_1_.setInteger("TreasurePosX", this.func_208010_l().getX());
        p_writeEntityToNBT_1_.setInteger("TreasurePosY", this.func_208010_l().getY());
        p_writeEntityToNBT_1_.setInteger("TreasurePosZ", this.func_208010_l().getZ());
        p_writeEntityToNBT_1_.setBoolean("GotFish", this.func_208011_dD());
        p_writeEntityToNBT_1_.setInteger("Moistness", this.func_211136_dB());
    }

    public void readEntityFromNBT(NBTTagCompound p_readEntityFromNBT_1_) {
        int lvt_2_1_ = p_readEntityFromNBT_1_.getInteger("TreasurePosX");
        int lvt_3_1_ = p_readEntityFromNBT_1_.getInteger("TreasurePosY");
        int lvt_4_1_ = p_readEntityFromNBT_1_.getInteger("TreasurePosZ");
        this.func_208012_g(new BlockPos(lvt_2_1_, lvt_3_1_, lvt_4_1_));
        super.readEntityFromNBT(p_readEntityFromNBT_1_);
        this.func_208008_s(p_readEntityFromNBT_1_.getBoolean("GotFish"));
        this.func_211137_b(p_readEntityFromNBT_1_.getInteger("Moistness"));
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAIBreathAir(this));
        this.tasks.addTask(0, new EntityAIFindWater(this));
        this.tasks.addTask(1, new EntityDolphin.AISwimToTreasure(this));
        this.tasks.addTask(2, new EntityDolphin.AISwimWithPlayer(this, 4.0D));
        this.tasks.addTask(4, new EntityAIWanderSwim(this, 1.0D, 10));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(5, new EntityAIJump(this, 10));
        this.tasks.addTask(6, new EntityAIAttackMelee(this, 1.2000000476837158D, true));
        this.tasks.addTask(8, new EntityDolphin.AIPlayWithItems());
        this.tasks.addTask(8, new EntityAIFollowBoat(this));
        this.tasks.addTask(9, new EntityAIAvoidEntity(this, EntityGuardian.class, 8.0F, 1.0D, 1.0D));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityGuardian.class}));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.2000000476837158D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    protected PathNavigate createNavigator(World p_createNavigator_1_) {
        return new PathNavigateSwimmer(this, p_createNavigator_1_);
    }

    public boolean attackEntityAsMob(Entity p_attackEntityAsMob_1_) {
        boolean lvt_2_1_ = p_attackEntityAsMob_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
        if (lvt_2_1_) {
            this.applyEnchantments(this, p_attackEntityAsMob_1_);
            this.playSound(SoundEvents.ENTITY_DOLPHIN_ATTACK, 1.0F, 1.0F);
        }

        return lvt_2_1_;
    }

    public int getMaxAir() {
        return 4800;
    }

    protected int determineNextAir(int p_determineNextAir_1_) {
        return this.getMaxAir();
    }

    public float getEyeHeight() {
        return 0.3F;
    }

    public int getVerticalFaceSpeed() {
        return 1;
    }

    public int getHorizontalFaceSpeed() {
        return 1;
    }

    protected boolean canBeRidden(Entity p_canBeRidden_1_) {
        return true;
    }

    protected void updateEquipmentIfNeeded(EntityItem p_updateEquipmentIfNeeded_1_) {
        if (this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
            ItemStack lvt_2_1_ = p_updateEquipmentIfNeeded_1_.getItem();
            if (this.canEquipItem(lvt_2_1_)) {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, lvt_2_1_);
                this.inventoryHandsDropChances[EntityEquipmentSlot.MAINHAND.getIndex()] = 2.0F;
                this.onItemPickup(p_updateEquipmentIfNeeded_1_, lvt_2_1_.getCount());
                p_updateEquipmentIfNeeded_1_.setDead();
            }
        }

    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.isAIDisabled()) {
            if (this.isInWaterRainOrBubbleColumn()) {
                this.func_211137_b(2400);
            } else {
                this.func_211137_b(this.func_211136_dB() - 1);
                if (this.func_211136_dB() <= 0) {
                    this.attackEntityFrom(DamageSource.field_205132_u, 1.0F);
                }

                if (this.onGround) {
                    this.motionY += 0.5D;
                    this.motionX += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F);
                    this.motionZ += (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F);
                    this.rotationYaw = this.rand.nextFloat() * 360.0F;
                    this.onGround = false;
                    this.isAirBorne = true;
                }
            }

            if (this.world.isRemote && this.isInWater() && this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ > 0.03D) {
                Vec3d lvt_1_1_ = this.getLook(0.0F);
                float lvt_2_1_ = MathHelper.cos(this.rotationYaw * 0.017453292F) * 0.3F;
                float lvt_3_1_ = MathHelper.sin(this.rotationYaw * 0.017453292F) * 0.3F;
                float lvt_4_1_ = 1.2F - this.rand.nextFloat() * 0.7F;

                for(int lvt_5_1_ = 0; lvt_5_1_ < 2; ++lvt_5_1_) {
                    this.world.addParticle(Particles.DOLPHIN, this.posX - lvt_1_1_.x * (double)lvt_4_1_ + (double)lvt_2_1_, this.posY - lvt_1_1_.y, this.posZ - lvt_1_1_.z * (double)lvt_4_1_ + (double)lvt_3_1_, 0.0D, 0.0D, 0.0D);
                    this.world.addParticle(Particles.DOLPHIN, this.posX - lvt_1_1_.x * (double)lvt_4_1_ - (double)lvt_2_1_, this.posY - lvt_1_1_.y, this.posZ - lvt_1_1_.z * (double)lvt_4_1_ - (double)lvt_3_1_, 0.0D, 0.0D, 0.0D);
                }
            }

        }
    }

    public void handleStatusUpdate(byte p_handleStatusUpdate_1_) {
        if (p_handleStatusUpdate_1_ == 38) {
            this.func_208401_a(Particles.HAPPY_VILLAGER);
        } else {
            super.handleStatusUpdate(p_handleStatusUpdate_1_);
        }

    }

    private void func_208401_a(IParticleData p_208401_1_) {
        for(int lvt_2_1_ = 0; lvt_2_1_ < 7; ++lvt_2_1_) {
            double lvt_3_1_ = this.rand.nextGaussian() * 0.01D;
            double lvt_5_1_ = this.rand.nextGaussian() * 0.01D;
            double lvt_7_1_ = this.rand.nextGaussian() * 0.01D;
            this.world.addParticle(p_208401_1_, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.20000000298023224D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, lvt_3_1_, lvt_5_1_, lvt_7_1_);
        }

    }

    protected boolean processInteract(EntityPlayer p_processInteract_1_, EnumHand p_processInteract_2_) {
        ItemStack lvt_3_1_ = p_processInteract_1_.getHeldItem(p_processInteract_2_);
        if (!lvt_3_1_.isEmpty() && lvt_3_1_.getItem().isTagged(ItemTags.FISHES)) {
            if (!this.world.isRemote) {
                this.playSound(SoundEvents.ENTITY_DOLPHIN_EAT, 1.0F, 1.0F);
            }

            this.func_208008_s(true);
            if (!p_processInteract_1_.capabilities.isCreativeMode) {
                lvt_3_1_.shrink(1);
            }

            return true;
        } else {
            return super.processInteract(p_processInteract_1_, p_processInteract_2_);
        }
    }

    @Nullable
    public EntityItem func_205024_f(ItemStack p_205024_1_) {
        if (p_205024_1_.isEmpty()) {
            return null;
        } else {
            double lvt_2_1_ = this.posY - 0.30000001192092896D + (double)this.getEyeHeight();
            EntityItem lvt_4_1_ = new EntityItem(this.world, this.posX, lvt_2_1_, this.posZ, p_205024_1_);
            lvt_4_1_.setPickupDelay(40);
            lvt_4_1_.func_200216_c(this.getUniqueID());
            float lvt_5_1_ = 0.3F;
            lvt_4_1_.motionX = (double)(-MathHelper.sin(this.rotationYaw * 0.017453292F) * MathHelper.cos(this.rotationPitch * 0.017453292F) * lvt_5_1_);
            lvt_4_1_.motionY = (double)(MathHelper.sin(this.rotationPitch * 0.017453292F) * lvt_5_1_ * 1.5F);
            lvt_4_1_.motionZ = (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * MathHelper.cos(this.rotationPitch * 0.017453292F) * lvt_5_1_);
            float lvt_6_1_ = this.rand.nextFloat() * 6.2831855F;
            lvt_5_1_ = 0.02F * this.rand.nextFloat();
            lvt_4_1_.motionX += (double)(MathHelper.cos(lvt_6_1_) * lvt_5_1_);
            lvt_4_1_.motionZ += (double)(MathHelper.sin(lvt_6_1_) * lvt_5_1_);
            this.world.spawnEntity(lvt_4_1_);
            return lvt_4_1_;
        }
    }

    public boolean func_205020_a(IWorld p_205020_1_) {
        return this.posY > 45.0D && this.posY < (double)p_205020_1_.getSeaLevel() && p_205020_1_.getBiome(new BlockPos(this)) != Biomes.OCEAN || p_205020_1_.getBiome(new BlockPos(this)) != Biomes.DEEP_OCEAN && super.func_205020_a(p_205020_1_);
    }

    protected SoundEvent getHurtSound(DamageSource p_getHurtSound_1_) {
        return SoundEvents.ENTITY_DOLPHIN_HURT;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return this.isInWater() ? SoundEvents.ENTITY_DOLPHIN_AMBIENT_WATER : SoundEvents.ENTITY_DOLPHIN_AMBIENT;
    }

    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_DOLPHIN_SPLASH;
    }

    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_DOLPHIN_SWIM;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableList.field_205214_aN;
    }

    protected boolean func_208006_dE() {
        BlockPos lvt_1_1_ = this.getNavigator().func_208485_j();
        if (lvt_1_1_ != null) {
            return this.getDistanceSq(lvt_1_1_) < 144.0D;
        } else {
            return false;
        }
    }

    public void travel(float p_travel_1_, float p_travel_2_, float p_travel_3_) {
        if (this.isServerWorld() && this.isInWater()) {
            this.moveRelative(p_travel_1_, p_travel_2_, p_travel_3_, this.getAIMoveSpeed());
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.8999999761581421D;
            this.motionY *= 0.8999999761581421D;
            this.motionZ *= 0.8999999761581421D;
            if (this.getAttackTarget() == null) {
                this.motionY -= 0.005D;
            }
        } else {
            super.travel(p_travel_1_, p_travel_2_, p_travel_3_);
        }

    }

    public boolean canBeLeashedTo(EntityPlayer p_canBeLeashedTo_1_) {
        return true;
    }

    static {
        field_208014_b = EntityDataManager.createKey(EntityDolphin.class, DataSerializers.BLOCK_POS);
        field_208013_bB = EntityDataManager.createKey(EntityDolphin.class, DataSerializers.BOOLEAN);
        field_211138_bB = EntityDataManager.createKey(EntityDolphin.class, DataSerializers.VARINT);
        field_205025_a = (p_205023_0_) -> {
            return !p_205023_0_.cannotPickup() && p_205023_0_.isEntityAlive() && p_205023_0_.isInWater();
        };
    }

    static class AISwimToTreasure extends EntityAIBase {
        private final EntityDolphin field_208057_a;
        private boolean field_208058_b;

        AISwimToTreasure(EntityDolphin p_i49344_1_) {
            this.field_208057_a = p_i49344_1_;
            this.setMutexBits(3);
        }

        public boolean isInterruptible() {
            return false;
        }

        public boolean shouldExecute() {
            return this.field_208057_a.func_208011_dD() && this.field_208057_a.getAir() >= 100;
        }

        public boolean shouldContinueExecuting() {
            BlockPos lvt_1_1_ = this.field_208057_a.func_208010_l();
            return this.field_208057_a.getDistanceSq(new BlockPos((double)lvt_1_1_.getX(), this.field_208057_a.posY, (double)lvt_1_1_.getZ())) > 16.0D && !this.field_208058_b && this.field_208057_a.getAir() >= 100;
        }

        public void startExecuting() {
            this.field_208058_b = false;
            this.field_208057_a.getNavigator().clearPath();
            World lvt_1_1_ = this.field_208057_a.world;
            BlockPos lvt_2_1_ = new BlockPos(this.field_208057_a);
            String lvt_3_1_ = (double)lvt_1_1_.rand.nextFloat() >= 0.5D ? "Ocean_Ruin" : "Shipwreck";
            BlockPos lvt_4_1_ = lvt_1_1_.findNearestStructure(lvt_3_1_, lvt_2_1_, 50);
            if (lvt_4_1_ == null) {
                BlockPos lvt_5_1_ = lvt_1_1_.findNearestStructure(lvt_3_1_.equals("Ocean_Ruin") ? "Shipwreck" : "Ocean_Ruin", lvt_2_1_, 50);
                if (lvt_5_1_ == null) {
                    this.field_208058_b = true;
                    return;
                }

                this.field_208057_a.func_208012_g(lvt_5_1_);
            } else {
                this.field_208057_a.func_208012_g(lvt_4_1_);
            }

            lvt_1_1_.setEntityState(this.field_208057_a, (byte)38);
        }

        public void resetTask() {
            BlockPos lvt_1_1_ = this.field_208057_a.func_208010_l();
            if (this.field_208057_a.getDistanceSq(new BlockPos((double)lvt_1_1_.getX(), this.field_208057_a.posY, (double)lvt_1_1_.getZ())) <= 16.0D || this.field_208058_b) {
                this.field_208057_a.func_208008_s(false);
            }

        }

        public void updateTask() {
            BlockPos lvt_1_1_ = this.field_208057_a.func_208010_l();
            World lvt_2_1_ = this.field_208057_a.world;
            if (this.field_208057_a.func_208006_dE() || this.field_208057_a.getNavigator().noPath()) {
                Vec3d lvt_3_1_ = RandomPositionGenerator.func_203155_a(this.field_208057_a, 16, 1, new Vec3d((double)lvt_1_1_.getX(), (double)lvt_1_1_.getY(), (double)lvt_1_1_.getZ()), 0.39269909262657166D);
                if (lvt_3_1_ == null) {
                    lvt_3_1_ = RandomPositionGenerator.findRandomTargetBlockTowards(this.field_208057_a, 8, 4, new Vec3d((double)lvt_1_1_.getX(), (double)lvt_1_1_.getY(), (double)lvt_1_1_.getZ()));
                }

                if (lvt_3_1_ != null) {
                    BlockPos lvt_4_1_ = new BlockPos(lvt_3_1_);
                    if (!lvt_2_1_.getFluidState(lvt_4_1_).isTagged(FluidTags.WATER) || !lvt_2_1_.getBlockState(lvt_4_1_).allowsMovement(lvt_2_1_, lvt_4_1_, PathType.WATER)) {
                        lvt_3_1_ = RandomPositionGenerator.findRandomTargetBlockTowards(this.field_208057_a, 8, 5, new Vec3d((double)lvt_1_1_.getX(), (double)lvt_1_1_.getY(), (double)lvt_1_1_.getZ()));
                    }
                }

                if (lvt_3_1_ == null) {
                    this.field_208058_b = true;
                    return;
                }

                this.field_208057_a.getLookHelper().setLookPosition(lvt_3_1_.x, lvt_3_1_.y, lvt_3_1_.z, (float)(this.field_208057_a.getHorizontalFaceSpeed() + 20), (float)this.field_208057_a.getVerticalFaceSpeed());
                this.field_208057_a.getNavigator().tryMoveToXYZ(lvt_3_1_.x, lvt_3_1_.y, lvt_3_1_.z, 1.3D);
                if (lvt_2_1_.rand.nextInt(80) == 0) {
                    lvt_2_1_.setEntityState(this.field_208057_a, (byte)38);
                }
            }

        }
    }

    static class AISwimWithPlayer extends EntityAIBase {
        private final EntityDolphin field_206834_a;
        private final double field_206835_b;
        private EntityPlayer field_206836_c;

        AISwimWithPlayer(EntityDolphin p_i48994_1_, double p_i48994_2_) {
            this.field_206834_a = p_i48994_1_;
            this.field_206835_b = p_i48994_2_;
            this.setMutexBits(3);
        }

        public boolean shouldExecute() {
            this.field_206836_c = this.field_206834_a.world.getClosestPlayerToEntity(this.field_206834_a, 10.0D);
            return this.field_206836_c == null ? false : this.field_206836_c.func_203007_ba();
        }

        public boolean shouldContinueExecuting() {
            return this.field_206836_c != null && this.field_206836_c.func_203007_ba() && this.field_206834_a.getDistanceSq(this.field_206836_c) < 256.0D;
        }

        public void startExecuting() {
            this.field_206836_c.func_195064_c(new PotionEffect(MobEffects.DOLPHINS_GRACE, 100));
        }

        public void resetTask() {
            this.field_206836_c = null;
            this.field_206834_a.getNavigator().clearPath();
        }

        public void updateTask() {
            this.field_206834_a.getLookHelper().setLookPositionWithEntity(this.field_206836_c, (float)(this.field_206834_a.getHorizontalFaceSpeed() + 20), (float)this.field_206834_a.getVerticalFaceSpeed());
            if (this.field_206834_a.getDistanceSq(this.field_206836_c) < 6.25D) {
                this.field_206834_a.getNavigator().clearPath();
            } else {
                this.field_206834_a.getNavigator().tryMoveToEntityLiving(this.field_206836_c, this.field_206835_b);
            }

            if (this.field_206836_c.func_203007_ba() && this.field_206836_c.world.rand.nextInt(6) == 0) {
                this.field_206836_c.func_195064_c(new PotionEffect(MobEffects.DOLPHINS_GRACE, 100));
            }

        }
    }

    class AIPlayWithItems extends EntityAIBase {
        private int field_205154_b;

        private AIPlayWithItems() {
        }

        public boolean shouldExecute() {
            if (this.field_205154_b > EntityDolphin.this.ticksExisted) {
                return false;
            } else {
                List<EntityItem> lvt_1_1_ = EntityDolphin.this.world.getEntitiesWithinAABB(EntityItem.class, EntityDolphin.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityDolphin.field_205025_a);
                return !lvt_1_1_.isEmpty() || !EntityDolphin.this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty();
            }
        }

        public void startExecuting() {
            List<EntityItem> lvt_1_1_ = EntityDolphin.this.world.getEntitiesWithinAABB(EntityItem.class, EntityDolphin.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityDolphin.field_205025_a);
            if (!lvt_1_1_.isEmpty()) {
                EntityDolphin.this.getNavigator().tryMoveToEntityLiving((Entity)lvt_1_1_.get(0), 1.2000000476837158D);
                EntityDolphin.this.playSound(SoundEvents.ENTITY_DOLPHIN_PLAY, 1.0F, 1.0F);
            }

            this.field_205154_b = 0;
        }

        public void resetTask() {
            ItemStack lvt_1_1_ = EntityDolphin.this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
            if (!lvt_1_1_.isEmpty()) {
                EntityDolphin.this.func_205024_f(lvt_1_1_);
                EntityDolphin.this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
                this.field_205154_b = EntityDolphin.this.ticksExisted + EntityDolphin.this.rand.nextInt(100);
            }

        }

        public void updateTask() {
            List<EntityItem> lvt_1_1_ = EntityDolphin.this.world.getEntitiesWithinAABB(EntityItem.class, EntityDolphin.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityDolphin.field_205025_a);
            ItemStack lvt_2_1_ = EntityDolphin.this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
            if (!lvt_2_1_.isEmpty()) {
                EntityDolphin.this.func_205024_f(lvt_2_1_);
                EntityDolphin.this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
            } else if (!lvt_1_1_.isEmpty()) {
                EntityDolphin.this.getNavigator().tryMoveToEntityLiving((Entity)lvt_1_1_.get(0), 1.2000000476837158D);
            }

        }
    }

    static class MoveHelper extends EntityMoveHelper {
        private final EntityDolphin field_205138_i;

        public MoveHelper(EntityDolphin p_i48945_1_) {
            super(p_i48945_1_);
            this.field_205138_i = p_i48945_1_;
        }

        public void onUpdateMoveHelper() {
            if (this.field_205138_i.isInWater()) {
                this.field_205138_i.motionY += 0.005D;
            }

            if (this.action == Action.MOVE_TO && !this.field_205138_i.getNavigator().noPath()) {
                double lvt_1_1_ = this.posX - this.field_205138_i.posX;
                double lvt_3_1_ = this.posY - this.field_205138_i.posY;
                double lvt_5_1_ = this.posZ - this.field_205138_i.posZ;
                double lvt_7_1_ = lvt_1_1_ * lvt_1_1_ + lvt_3_1_ * lvt_3_1_ + lvt_5_1_ * lvt_5_1_;
                if (lvt_7_1_ < 2.500000277905201E-7D) {
                    this.entity.setMoveForward(0.0F);
                } else {
                    float lvt_9_1_ = (float)(MathHelper.atan2(lvt_5_1_, lvt_1_1_) * 57.2957763671875D) - 90.0F;
                    this.field_205138_i.rotationYaw = this.limitAngle(this.field_205138_i.rotationYaw, lvt_9_1_, 10.0F);
                    this.field_205138_i.renderYawOffset = this.field_205138_i.rotationYaw;
                    this.field_205138_i.rotationYawHead = this.field_205138_i.rotationYaw;
                    float lvt_10_1_ = (float)(this.speed * this.field_205138_i.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                    if (this.field_205138_i.isInWater()) {
                        this.field_205138_i.setAIMoveSpeed(lvt_10_1_ * 0.02F);
                        float lvt_11_1_ = -((float)(MathHelper.atan2(lvt_3_1_, (double)MathHelper.sqrt(lvt_1_1_ * lvt_1_1_ + lvt_5_1_ * lvt_5_1_)) * 57.2957763671875D));
                        lvt_11_1_ = MathHelper.clamp(MathHelper.wrapDegrees(lvt_11_1_), -85.0F, 85.0F);
                        this.field_205138_i.rotationPitch = this.limitAngle(this.field_205138_i.rotationPitch, lvt_11_1_, 5.0F);
                        float lvt_12_1_ = MathHelper.cos(this.field_205138_i.rotationPitch * 0.017453292F);
                        float lvt_13_1_ = MathHelper.sin(this.field_205138_i.rotationPitch * 0.017453292F);
                        this.field_205138_i.moveForward = lvt_12_1_ * lvt_10_1_;
                        this.field_205138_i.moveVertical = -lvt_13_1_ * lvt_10_1_;
                    } else {
                        this.field_205138_i.setAIMoveSpeed(lvt_10_1_ * 0.1F);
                    }

                }
            } else {
                this.field_205138_i.setAIMoveSpeed(0.0F);
                this.field_205138_i.setMoveStrafing(0.0F);
                this.field_205138_i.setMoveVertical(0.0F);
                this.field_205138_i.setMoveForward(0.0F);
            }
        }
    }
}
*/
