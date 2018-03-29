package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraft.block.BlockMobSpawner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.Biomes;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thegaminghuskymc.huskylib2.HuskyLib;
import net.thegaminghuskymc.mcaddon.Reference;
import net.thegaminghuskymc.mcaddon.entity.EntityMummy;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EntityEventHandler {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof EntityMob) {
            EntityMob entityMob = (EntityMob) event.getEntity();
            World world = entityMob.world;
            BlockPos pos = entityMob.getPosition();
            if (entityMob.getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.DESERT && !world.isRemote) {
                if (entityMob instanceof EntitySpider || entityMob instanceof EntityMummy)
                    return;

                EntityMummy mummy = new EntityMummy(world);
                if (mummy.isAIDisabled())
                    mummy.setNoAI(false);
                mummy.setPositionAndRotation(pos.getX() + 1D, pos.getY() + 0.5D, pos.getZ() + 1D, mummy.rotationYaw, mummy.cameraPitch);
                mummy.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mummy)), null);
                mummy.setLootTable(LootTableHandler.MUMMY);
                world.spawnEntity(mummy);
            }
        }
    }

}