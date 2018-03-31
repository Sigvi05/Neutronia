package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.thegaminghuskymc.mcaddon.util.handlers.LootTableHandler;

import javax.annotation.Nullable;
import java.util.Calendar;

public class EntityEnderPhantom extends EntityLiving implements IEntityMultiPart, IMob {

    /** An array containing all body parts of this dragon */
    public MultiPartEntityPart[] phantomPartArray;
    /** The head bounding box of a dragon */
    public MultiPartEntityPart phantomPartHead = new MultiPartEntityPart(this, "head", 6.0F, 6.0F);
    /** The body bounding box of a dragon */
    public MultiPartEntityPart phantomPartBody = new MultiPartEntityPart(this, "body", 8.0F, 8.0F);
    public MultiPartEntityPart phantomPartWing1 = new MultiPartEntityPart(this, "wing", 4.0F, 4.0F);
    public MultiPartEntityPart phantomPartWing2 = new MultiPartEntityPart(this, "wing", 4.0F, 4.0F);
    public MultiPartEntityPart phantomPartTail1 = new MultiPartEntityPart(this, "tail", 4.0F, 4.0F);
    public MultiPartEntityPart phantomPartTail2 = new MultiPartEntityPart(this, "tail", 4.0F, 4.0F);
    /** Animation time at previous tick. */
    public float prevAnimTime;
    /** Animation time, used to control the speed of the animation cycles (wings flapping, jaw opening, etc.) */
    public float animTime;


    /**
     * Coordinates of where the bat spawned.
     */
    private BlockPos spawnPosition;

    public EntityEnderPhantom(World worldIn) {
        super(worldIn);
        this.phantomPartArray = new MultiPartEntityPart[] {this.phantomPartHead, this.phantomPartBody, this.phantomPartWing1, this.phantomPartWing2, this.phantomPartTail1, this.phantomPartTail2};
        this.setHealth(this.getMaxHealth());
        this.setSize(16.0F, 8.0F);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.ignoreFrustumCheck = true;
    }

    protected void entityInit() {
        super.entityInit();
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.1F;
    }

    /**
     * Gets the pitch of living sounds in living entities.
     */
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Nullable
    public SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_BAT_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    /**
     * Return all subparts of this entity. These parts are not saved in the chunk and do not tick, but are detected by
     * getEntitiesInAABB and are put in the entity ID map. Vanilla makes the assumption that the entities in this array
     * have consecutive entity ID's after their owner ID, so you must construct all parts in the constructor of the
     * parent.
     */
    public Entity[] getParts()
    {
        return this.phantomPartArray;
    }
    
    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(Entity entityIn) {
    }

    protected void collideWithNearbyEntities() {
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6000000238418579D;
    }

    protected void updateAITasks() {
        super.updateAITasks();
        BlockPos blockpos = new BlockPos(this);
        BlockPos blockpos1 = blockpos.up();

        if (this.spawnPosition != null && (!this.world.isAirBlock(this.spawnPosition) || this.spawnPosition.getY() < 1)) {
            this.spawnPosition = null;
        }

        if (this.spawnPosition == null || this.rand.nextInt(30) == 0 || this.spawnPosition.distanceSq((double) ((int) this.posX), (double) ((int) this.posY), (double) ((int) this.posZ)) < 4.0D) {
            this.spawnPosition = new BlockPos((int) this.posX + this.rand.nextInt(7) - this.rand.nextInt(7), (int) this.posY + this.rand.nextInt(6) - 2, (int) this.posZ + this.rand.nextInt(7) - this.rand.nextInt(7));
        }

        double d0 = (double) this.spawnPosition.getX() + 0.5D - this.posX;
        double d1 = (double) this.spawnPosition.getY() + 0.1D - this.posY;
        double d2 = (double) this.spawnPosition.getZ() + 0.5D - this.posZ;
        this.motionX += (Math.signum(d0) * 0.5D - this.motionX) * 0.10000000149011612D;
        this.motionY += (Math.signum(d1) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
        this.motionZ += (Math.signum(d2) * 0.5D - this.motionZ) * 0.10000000149011612D;
        float f = (float) (MathHelper.atan2(this.motionZ, this.motionX) * (180D / Math.PI)) - 90.0F;
        float f1 = MathHelper.wrapDegrees(f - this.rotationYaw);
        this.moveForward = 0.5F;
        this.rotationYaw += f1;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the animations.blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking() {
        return false;
    }

    public void fall(float distance, float damageMultiplier) {
    }

    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    /**
     * Return whether this entity should NOT trigger a pressure plate or a tripwire.
     */
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            return super.attackEntityFrom(source, amount);
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere() {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (blockpos.getY() >= this.world.getSeaLevel()) {
            return false;
        } else {
            int i = this.world.getLightFromNeighbors(blockpos);
            int j = 4;

            if (this.isDateAroundHalloween(this.world.getCurrentDate())) {
                j = 7;
            } else if (this.rand.nextBoolean()) {
                return false;
            }

            return i <= this.rand.nextInt(j) && super.getCanSpawnHere();
        }
    }

    private boolean isDateAroundHalloween(Calendar p_175569_1_) {
        return p_175569_1_.get(2) + 1 == 10 && p_175569_1_.get(5) >= 20 || p_175569_1_.get(2) + 1 == 11 && p_175569_1_.get(5) <= 3;
    }

    public float getEyeHeight() {
        return this.height / 2.0F;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableHandler.ENDER_PHANTOM;
    }

    @Override
    public World getWorld() {
        return null;
    }

    @Override
    public boolean attackEntityFromPart(MultiPartEntityPart phantomPart, DamageSource source, float damage) {
        return false;
    }
}