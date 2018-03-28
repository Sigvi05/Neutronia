package net.thegaminghuskymc.mcaddon.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.mcaddon.entity.ai.EntityAIMummyAttack;
import net.thegaminghuskymc.mcaddon.init.MCAddonItems;

import javax.annotation.Nullable;
import java.util.Calendar;

public class EntityMummy extends EntityMob {

    private static final DataParameter<Integer> VILLAGER_TYPE = EntityDataManager.<Integer>createKey(EntityMummy.class, DataSerializers.VARINT);
    public static final DataParameter<Boolean> ARMS_RAISED = EntityDataManager.<Boolean>createKey(EntityMummy.class, DataSerializers.BOOLEAN);

    private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);
    private boolean isBreakDoorsTaskSet;

    private float mummyWidth = 0.6F;
    private float mummyHeight = 1.95F;

    public EntityMummy(World worldIn) {
        super(worldIn);
        this.setSize(mummyWidth, mummyHeight);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMummyAttack(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 7.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
    }
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(1.0D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(VILLAGER_TYPE, Integer.valueOf(0));
        this.getDataManager().register(ARMS_RAISED, Boolean.valueOf(false));
    }

    public void setArmsRaised(boolean armsRaised) {
        this.getDataManager().set(ARMS_RAISED, Boolean.valueOf(armsRaised));
    }

    @SideOnly(Side.CLIENT)
    public boolean isArmsRaised() {
        return ((Boolean)this.getDataManager().get(ARMS_RAISED)).booleanValue();
    }

    public boolean isBreakDoorsTaskSet() {
        return this.isBreakDoorsTaskSet;
    }

    public void setBreakDoorAItask(boolean enabled) {
        if (this.isBreakDoorsTaskSet != enabled) {
            this.isBreakDoorsTaskSet = enabled;
            ((PathNavigateGround)this.getNavigator()).setBreakDoors(enabled);

            if (enabled)
                this.tasks.addTask(1, this.breakDoor);
            else
                this.tasks.removeTask(this.breakDoor);
        }
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return super.getExperiencePoints(player);
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (super.attackEntityFrom(source, amount)) {
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);

        if (flag) {
            float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();

            if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F)
                entityIn.setFire(2 * (int)f);
        }
        return flag;
    }

    /**
     *  TODO: Change Sounds...
     */
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BLOCK_ANVIL_USE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DONKEY_DEATH;
    }

    protected SoundEvent getStepSound()
    {
        return SoundEvents.ENTITY_ZOMBIE_STEP;
    }

    // TODO ^


    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ZOMBIE;
    }

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        super.setEquipmentBasedOnDifficulty(difficulty);

        if (this.rand.nextFloat() < (this.world.getDifficulty() == EnumDifficulty.HARD ? 0.05F : 0.01F)) {
            int i = this.rand.nextInt(3);

            if (i == 0)
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(MCAddonItems.ANCIENT_SWORD));
            else
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Item.getItemFromBlock(Blocks.SAND)));
        }
    }

    public static void registerFixesmummy(DataFixer fixer) {
        EntityLiving.registerFixesMob(fixer, EntityMummy.class);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setBreakDoorAItask(compound.getBoolean("CanBreakDoors"));
    }

    @Override
    public void onKillEntity(EntityLivingBase entityLivingIn) {
        super.onKillEntity(entityLivingIn);

        if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager) {
            if (this.world.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean())
                return;

            EntityVillager entityVillager = (EntityVillager) entityLivingIn;
            EntityMummyVillager entityMummyVillager = new EntityMummyVillager(this.world);
            entityMummyVillager.copyLocationAndAnglesFrom(entityVillager);
            this.world.removeEntity(entityVillager);
            entityMummyVillager.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entityMummyVillager)), null);
            entityMummyVillager.setProfession(entityVillager.getProfession());
            entityMummyVillager.setNoAI(entityVillager.isAIDisabled());

            if (entityVillager.hasCustomName()) {
                entityMummyVillager.setCustomNameTag(entityVillager.getCustomNameTag());
                entityMummyVillager.setAlwaysRenderNameTag(entityVillager.getAlwaysRenderNameTag());
            }

            this.world.spawnEntity(entityMummyVillager);
            this.world.playEvent((EntityPlayer)null, 1026, new BlockPos(this), 0);
        }
    }

    @Override
    public float getEyeHeight() {
        return 1.74F;
    }

    @Override
    protected boolean canEquipItem(ItemStack stack) {
        return stack.getItem() == MCAddonItems.ANCIENT_SWORD;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && world.getBiome(new BlockPos(this)) == Biomes.DESERT || world.getBiome(new BlockPos(this)) == Biomes.DESERT_HILLS;
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
       if (!getCanSpawnHere())
           despawnEntity();
       else {
           livingdata = super.onInitialSpawn(difficulty, livingdata);
           float f = difficulty.getClampedAdditionalDifficulty();
           this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
           this.setBreakDoorAItask(this.rand.nextFloat() < f * 0.1F);
           this.setEquipmentBasedOnDifficulty(difficulty);
           this.setEnchantmentBasedOnDifficulty(difficulty);

           if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()) {
               Calendar calendar = this.world.getCurrentDate();
               if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F) {
                   this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
                   this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
               }
           }

           this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Spawn Bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
           double d0 = this.rand.nextDouble() * 1.5D * (double) f;

           if (d0 > 1.0D)
               this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random mummy-spawn bonus", d0, 2));

           if (this.rand.nextFloat() < f * 0.0F && this.world.getDifficulty() == EnumDifficulty.HARD) {
               this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Leader mummy bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
               this.setBreakDoorAItask(true);
           }
       }
       return livingdata;
    }

    public double getYOffset() {
        return -0.45D;
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);

        if (cause.getTrueSource() instanceof EntityCreeper) {
            EntityCreeper entityCreeper = (EntityCreeper)cause.getTrueSource();

            if (entityCreeper.getPowered() && entityCreeper.ableToCauseSkullDrop()) {
                entityCreeper.incrementDroppedSkulls();
                ItemStack itemStack = this.getSkullDrop();

                if(!itemStack.isEmpty())
                    this.entityDropItem(itemStack, 0.0F);
            }
        }
    }

    protected ItemStack getSkullDrop() {
        return new ItemStack(Items.SKULL, 1, 2);
    }

}