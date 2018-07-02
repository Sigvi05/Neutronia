package net.hdt.neutronia.util.handlers;

import net.hdt.neutronia.entity.*;
import net.hdt.neutronia.entity.render.model.ModelDrownedScubaVillager;
import net.hdt.neutronia.entity.render.model.ModelNecro;
import net.hdt.neutronia.entity.render.model.ModelScubaVillager;
import net.hdt.neutronia.util.Reference;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EntityEventHandler {

    private static final ModelNecro necroModel = new ModelNecro();
    private static final ModelScubaVillager scubaVillagerModel = new ModelScubaVillager();
    private static final ModelDrownedScubaVillager drownedScubaVillagerModel = new ModelDrownedScubaVillager();
    private static final ModelVillager defaultVillagerModel = new ModelVillager(0.0F);

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof EntityVillager || event.getEntity() instanceof EntityZombie) {
            World world = event.getEntity().world;
            BlockPos pos = event.getEntity().getPosition();
            if (event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.DESERT && !world.isRemote) {
                EntityMummyVillager mummyVillager = new EntityMummyVillager(world);
                if (mummyVillager.isAIDisabled())
                    mummyVillager.setNoAI(false);
                mummyVillager.setPositionAndRotation(pos.getX() + 1D, pos.getY() + 0.5D, pos.getZ() + 1D, mummyVillager.rotationYaw, mummyVillager.cameraPitch);
                mummyVillager.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mummyVillager)), null);
                world.spawnEntity(mummyVillager);
            }
        }
        if (event.getEntity() instanceof EntityZombie) {
            World world = event.getEntity().world;
            BlockPos pos = event.getEntity().getPosition();
            if (event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.DESERT && !world.isRemote) {
                EntityMummy mummy = new EntityMummy(world);
                if (mummy.isAIDisabled())
                    mummy.setNoAI(false);
                mummy.setPositionAndRotation(pos.getX() + 1D, pos.getY() + 0.5D, pos.getZ() + 1D, mummy.rotationYaw, mummy.cameraPitch);
                mummy.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mummy)), null);
                world.spawnEntity(mummy);
            }
        }
        if (event.getEntity() instanceof EntityScubaVillager) {
            World world = event.getEntity().world;
            BlockPos pos = event.getEntity().getPosition();
            if (event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.OCEAN || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.DEEP_OCEAN || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.FROZEN_OCEAN || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.RIVER || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.FROZEN_RIVER && !world.isRemote) {
                EntityDrownedScubaVillager drowned = new EntityDrownedScubaVillager(world);
                if (drowned.isAIDisabled())
                    drowned.setNoAI(false);
                drowned.setPositionAndRotation(pos.getX() + 1D, pos.getY() + 0.5D, pos.getZ() + 1D, drowned.rotationYaw, drowned.cameraPitch);
                drowned.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(drowned)), null);
                world.spawnEntity(drowned);
            }
        }
        if (event.getEntity() instanceof EntityZombie) {
            World world = event.getEntity().world;
            BlockPos pos = event.getEntity().getPosition();
            if (event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.OCEAN || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.DEEP_OCEAN || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.FROZEN_OCEAN || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.RIVER || event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.FROZEN_RIVER && !world.isRemote) {
                EntityDrowned drowned = new EntityDrowned(world);
                if (drowned.isAIDisabled())
                    drowned.setNoAI(false);
                drowned.setPositionAndRotation(pos.getX() + 1D, pos.getY() + 0.5D, pos.getZ() + 1D, drowned.rotationYaw, drowned.cameraPitch);
                drowned.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(drowned)), null);
                world.spawnEntity(drowned);
            }
        }
    }

    /*@SubscribeEvent
    public static void preRenderLivingEvent(RenderLivingEvent.Pre<EntityVillager> event) {
        Entity e = event.getEntity();
        if(e instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager)e;
            VillagerRegistry.VillagerProfession prof = villager.getProfessionForge();
            if (prof == NEntities.necroProfession)
                event.getRenderer().mainModel = necroModel;
            else if(prof == NEntities.scubaDiverProfession)
                event.getRenderer().mainModel = scubaVillagerModel;
            else if(prof == NEntities.drownedScubaDiverProfession)
                event.getRenderer().mainModel = drownedScubaVillagerModel;
        }
    }

    @SubscribeEvent
    public static void postRenderLivingEvent(RenderLivingEvent.Post<EntityVillager> event) {
        Entity e = event.getEntity();
        if(e instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager)e;
            VillagerRegistry.VillagerProfession prof = villager.getProfessionForge();
            if (prof == NEntities.necroProfession)
                event.getRenderer().mainModel = defaultVillagerModel;
            else if(prof == NEntities.scubaDiverProfession)
                event.getRenderer().mainModel = defaultVillagerModel;
            else if(prof == NEntities.drownedScubaDiverProfession)
                event.getRenderer().mainModel = defaultVillagerModel;
        }
    }*/

    @SubscribeEvent
    public void onHurt(LivingHurtEvent event) {
        Entity e = event.getEntity();
        if (e instanceof EntitySquid && !e.world.isRemote) {
            List<EntityPlayer> players = e.world.getEntitiesWithinAABB(EntityPlayer.class, e.getEntityBoundingBox().grow(4, 4, 4));
            for (EntityPlayer player : players)
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));

            WorldServer ws = (WorldServer) e.world;
            ws.spawnParticle(EnumParticleTypes.SMOKE_LARGE, e.posX + e.width / 2, e.posY + e.height / 2, e.posZ + e.width / 2, 100, 0, 0, 0, 0.02);
        }
    }

}
