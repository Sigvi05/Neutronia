package net.hdt.neutronia.util.handlers;

import net.hdt.neutronia.entity.EntityMummyVillager;
import net.hdt.neutronia.util.Reference;
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

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof EntityVillager || event.getEntity() instanceof EntityZombie) {
            World world = event.getEntity().world;
            BlockPos pos = event.getEntity().getPosition();
            if (event.getEntity().getEntityWorld().getBiome(new BlockPos(pos)) == Biomes.DESERT && !world.isRemote) {
                EntityMummyVillager mummy = new EntityMummyVillager(world);
                if (mummy.isAIDisabled())
                    mummy.setNoAI(false);
                mummy.setPositionAndRotation(pos.getX() + 1D, pos.getY() + 0.5D, pos.getZ() + 1D, mummy.rotationYaw, mummy.cameraPitch);
                mummy.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mummy)), null);
                world.spawnEntity(mummy);
            }
        }
    }

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
