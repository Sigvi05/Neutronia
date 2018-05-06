package net.hdt.neutronia.util;

import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorldUtil {

    public static RayTraceResult rayTraceFromEntity(World world, Entity entity, boolean countNonSolidBlock, double range) {
        float f = 1.0F;
        float f1 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f;
        float f2 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f;
        double d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double) f;
        double d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double) f;

        if (!world.isRemote && entity instanceof EntityPlayer) {
            d1 += 1.62D;
        }

        double d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) f;
        Vec3d vec3 = new Vec3d(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = range;

        if (entity instanceof EntityPlayerMP) {
            d3 = ((EntityPlayerMP) entity).interactionManager.getBlockReachDistance();
        }

        Vec3d vec31 = vec3.addVector((double) f7 * d3, (double) f6 * d3, (double) f8 * d3);
        return world.rayTraceBlocks(vec3, vec31, countNonSolidBlock, !countNonSolidBlock, countNonSolidBlock);
    }

    public static void setEntityPosition(Entity e, double posX, double posY, double posZ) {
        if (e instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) e;
            player.connection.setPlayerLocation(posX, posY, posZ, player.rotationYaw, player.rotationPitch);
        } else {
            e.setPositionAndUpdate(posX, posY, posZ);
        }
    }

    public static boolean isValidPosition(BlockPos pos) {
        return pos.getX() >= -30000000 && pos.getZ() >= -30000000 && pos.getX() < 30000000 && pos.getZ() < 30000000 && pos.getY() >= 0 && pos.getY() < 256;
    }

    public static BlockPos getHeighestPos(World worldObj, int x, int z) {
        int startY = worldObj.getChunkFromBlockCoords(new BlockPos(x, 0, z)).getTopFilledSegment() + 16;

        for (int y = startY; y >= 0; y--) {
            BlockPos toCheck = new BlockPos(x, y, z);
            if (!worldObj.isAirBlock(toCheck)) {
                return toCheck;
            }
        }

        return null;
    }

    public static List<Entity> getEntitiesWithinAABBs(World worldObj, Class classEntity, AxisAlignedBB... bbs) {
        return getEntitiesWithinAABBs(worldObj, classEntity, EntitySelectors.NOT_SPECTATING, bbs);
    }

    public static List<Entity> getEntitiesWithinAABBs(World worldObj, Class clazz, Predicate<Entity> filter, AxisAlignedBB... bbs) {
        ArrayList<Entity> arraylist = new ArrayList<Entity>();

        HashMap<Vec3i, ArrayList<AxisAlignedBB>> boxMap = new HashMap<>();

        for (AxisAlignedBB bb : bbs) {
            int minChunkX = MathHelper.floor((bb.minX - World.MAX_ENTITY_RADIUS) / 16.0D);
            int maxChunkX = MathHelper.floor((bb.maxX + World.MAX_ENTITY_RADIUS) / 16.0D);
            int minChunkZ = MathHelper.floor((bb.minZ - World.MAX_ENTITY_RADIUS) / 16.0D);
            int maxChunkZ = MathHelper.floor((bb.maxZ + World.MAX_ENTITY_RADIUS) / 16.0D);
            int minChunkY = MathHelper.floor((bb.minY - World.MAX_ENTITY_RADIUS) / 16.0D);
            int maxChunkY = MathHelper.floor((bb.maxY + World.MAX_ENTITY_RADIUS) / 16.0D);

            for (int x = minChunkX; x <= maxChunkX; x++) {
                for (int z = minChunkZ; z <= maxChunkZ; z++) {
                    for (int y = minChunkY; y <= maxChunkY; y++) {
                        if (y >= 0 && y < worldObj.getHeight() / 16) {
                            Vec3i chunkVec = new Vec3i(x, y, z);

                            ArrayList<AxisAlignedBB> boxList = boxMap.computeIfAbsent(chunkVec, k -> new ArrayList<>());

                            boxList.add(bb);
                        }
                    }
                }
            }
        }

        for (Vec3i chunkVec : boxMap.keySet()) {
            Chunk chunk = worldObj.getChunkFromChunkCoords(chunkVec.getX(), chunkVec.getZ());

            ClassInheritanceMultiMap[] entityMapArray = chunk.getEntityLists();

            for (Entity entity : (Iterable<Entity>) entityMapArray[chunkVec.getY()].getByClass(clazz)) {
                for (AxisAlignedBB bb : boxMap.get(chunkVec)) {
                    if (entity.getEntityBoundingBox().intersects(bb) && (filter == null || filter.apply(entity))) {
                        arraylist.add(entity);

                        Entity[] entityParts = entity.getParts();

                        if (entityParts != null) {
                            int i = 0;
                            while (i < entityParts.length) {
                                entity = entityParts[i];

                                if (entity.getEntityBoundingBox().intersects(bb) && (filter == null || filter.apply(entity))) {
                                    arraylist.add(entity);
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }

        return arraylist;
    }

    public static void spawnItemStack(World worldIn, BlockPos pos, ItemStack stack) {
        spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
    }

    public static void spawnItemStack(World worldIn, double x, double y, double z, ItemStack stack) {
        double d0 = worldIn.rand.nextFloat() * 0.5F + 0.25D;
        double d1 = worldIn.rand.nextFloat() * 0.5F + 0.25D;
        double d2 = worldIn.rand.nextFloat() * 0.5F + 0.25D;
        EntityItem entityitem = new EntityItem(worldIn, x + d0, y + d1, z + d2, stack);
        entityitem.setDefaultPickupDelay();
        worldIn.spawnEntity(entityitem);
    }

}