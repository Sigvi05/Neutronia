package net.hdt.neutronia.events;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.lang.reflect.Constructor;
import java.util.*;

import static net.hdt.neutronia.base.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class EventHandler {

    private List<String> allowedBlocks;

    // This is mostly copied from the EntityRenderer#getMouseOver() method
    private static RayTraceResult getMouseOverExtended(float dist) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        Entity theRenderViewEntity = mc.getRenderViewEntity();
        AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
                Objects.requireNonNull(theRenderViewEntity).posX - 0.5D,
                theRenderViewEntity.posY - 0.0D,
                theRenderViewEntity.posZ - 0.5D,
                theRenderViewEntity.posX + 0.5D,
                theRenderViewEntity.posY + 1.5D,
                theRenderViewEntity.posZ + 0.5D
        );
        RayTraceResult returnMOP = null;
        if (mc.world != null) {
            double var2 = dist;
            returnMOP = theRenderViewEntity.rayTrace(var2, 0);
            double calcdist = var2;
            Vec3d pos = theRenderViewEntity.getPositionEyes(0);
            var2 = calcdist;
            if (returnMOP != null) {
                calcdist = returnMOP.hitVec.distanceTo(pos);
            }

            Vec3d lookvec = theRenderViewEntity.getLook(0);
            Vec3d var8 = pos.add(lookvec.x * var2,
                    lookvec.y * var2,
                    lookvec.z * var2);
            Entity pointedEntity = null;
            float var9 = 1.0F;
            @SuppressWarnings("unchecked")
            List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(
                    theRenderViewEntity,
                    theViewBoundingBox.grow(
                            lookvec.x * var2,
                            lookvec.y * var2,
                            lookvec.z * var2).expand(var9, var9, var9));
            double d = calcdist;

            for (Entity entity : list) {
                if (entity.canBeCollidedWith()) {
                    float bordersize = entity.getCollisionBorderSize();
                    AxisAlignedBB aabb = new AxisAlignedBB(
                            entity.posX - entity.width / 2,
                            entity.posY,
                            entity.posZ - entity.width / 2,
                            entity.posX + entity.width / 2,
                            entity.posY + entity.height,
                            entity.posZ + entity.width / 2);
                    aabb.expand(bordersize, bordersize, bordersize);
                    RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);

                    if (aabb.contains(pos)) {
                        if (0.0D < d || d == 0.0D) {
                            pointedEntity = entity;
                            d = 0.0D;
                        }
                    } else if (mop0 != null) {
                        double d1 = pos.distanceTo(mop0.hitVec);

                        if (d1 < d || d == 0.0D) {
                            pointedEntity = entity;
                            d = d1;
                        }
                    }
                }
            }

            if (pointedEntity != null && (d < calcdist || returnMOP == null)) {
                returnMOP = new RayTraceResult(pointedEntity);
            }
        }
        return returnMOP;
    }

    @SubscribeEvent
    public void onSpawn(LivingSpawnEvent.CheckSpawn event) {
        allowedBlocks = Arrays.asList(Objects.requireNonNull(Blocks.NETHERRACK.getRegistryName()).toString(),
                Objects.requireNonNull(Blocks.SOUL_SAND.getRegistryName()).toString(),
                Objects.requireNonNull(Blocks.MAGMA.getRegistryName()).toString());
        if (!event.isSpawner() && event.getEntityLiving() instanceof EntityBlaze && event.getResult() != Event.Result.DENY && event.getEntityLiving().world instanceof WorldServer) {
            EntityBlaze blaze = (EntityBlaze) event.getEntityLiving();
            WorldServer world = (WorldServer) blaze.world;
            BlockPos pos = blaze.getPosition();
            Block block = world.getBlockState(pos.down()).getBlock();
            ResourceLocation res = block.getRegistryName();
            if (res != null) {
                boolean allowedBlock = allowedBlocks.contains(res.toString());
                boolean fortress = world.getChunkProvider().isInsideStructure(world, "Fortress", pos);
                if (!fortress && !allowedBlock)
                    event.setResult(Event.Result.DENY);
            }
        }
    }

    @SubscribeEvent
    public void decorate(DecorateBiomeEvent.Decorate event) {
        World world = event.getWorld();
        Biome biome = world.getBiome(event.getPos());
        Random rand = event.getRand();
        double bigMushroomsPerChunk = 0.5;
        WorldGenerator bigMushroomGen = new WorldGenBigMushroom();

        if ((biome == Biomes.SWAMPLAND || biome == Biomes.MUTATED_SWAMPLAND) && event.getType() == DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM) {
            if (rand.nextDouble() > bigMushroomsPerChunk)
                return;

            int amount = (int) Math.max(1, bigMushroomsPerChunk);
            for (int i = 0; i < amount; i++) {
                int x = rand.nextInt(16) + 8;
                int y = rand.nextInt(16) + 8;
                bigMushroomGen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
            }

            event.setResult(Event.Result.DENY);
        }
    }

    @SubscribeEvent
    public void onDungeonSpawn(PopulateChunkEvent.Populate event) {
        if (event.getType() != PopulateChunkEvent.Populate.EventType.DUNGEON)
            return;

        int i = event.getChunkX() * 16;
        int j = event.getChunkZ() * 16;

        BlockPos blockpos = new BlockPos(i, 0, j);
        World world = event.getWorld();
        Random rand = event.getRand();

        int x = rand.nextInt(16) + 8;
        int y = rand.nextInt(256);
        int z = rand.nextInt(16) + 8;
        BlockPos generatePos = blockpos.add(x, y, z);
        if (couldDungeonGenerate(world, rand, generatePos) && world instanceof WorldServer) {
            placeDungeonAt((WorldServer) world, rand, generatePos);
            event.setResult(Event.Result.DENY);
        }
    }

    private boolean couldDungeonGenerate(World worldIn, Random rand, BlockPos position) {
        int j = rand.nextInt(2) + 2;
        int k = -j - 1;
        int l = j + 1;
        int k1 = rand.nextInt(2) + 2;
        int l1 = -k1 - 1;
        int i2 = k1 + 1;
        int j2 = 0;

        for (int k2 = k; k2 <= l; ++k2) {
            for (int l2 = -1; l2 <= 4; ++l2) {
                for (int i3 = l1; i3 <= i2; ++i3) {
                    BlockPos blockpos = position.add(k2, l2, i3);
                    Material material = worldIn.getBlockState(blockpos).getMaterial();
                    boolean flag = material.isSolid();

                    if (l2 == -1 && !flag)
                        return false;

                    if (l2 == 4 && !flag)
                        return false;

                    if ((k2 == k || k2 == l || i3 == l1 || i3 == i2) && l2 == 0 && worldIn.isAirBlock(blockpos) && worldIn.isAirBlock(blockpos.up()))
                        ++j2;
                }
            }
        }

        return j2 >= 1 && j2 <= 5;
    }

    private void placeDungeonAt(WorldServer world, Random rand, BlockPos position) {
        int dungeonType = rand.nextInt(10);

        MinecraftServer server = world.getMinecraftServer();
        Template template = world.getStructureTemplateManager().getTemplate(server, new ResourceLocation(MOD_ID, "dungeon_" + dungeonType));
        PlacementSettings settings = new PlacementSettings();
        settings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

        BlockPos size = template.getSize();
        for (int x = 0; x < size.getX(); x++)
            for (int y = 0; y < size.getY(); y++)
                for (int z = 0; z < size.getZ(); z++) {
                    BlockPos checkPos = position.add(Template.transformedBlockPos(settings, new BlockPos(x, y, z)));
                    IBlockState checkState = world.getBlockState(checkPos);
                    if (checkState.getBlock().getBlockHardness(checkState, world, checkPos) == -1 || world.canBlockSeeSky(checkPos))
                        return; // Obstructed or exposed, can't generate here
                }

        template.addBlocksToWorld(world, position, settings);

        int spawners = 0;
        List<BlockPos> chests = new ArrayList<>();
        Map<BlockPos, String> dataBlocks = template.getDataBlocks(position, settings);

        for (Map.Entry<BlockPos, String> entry : dataBlocks.entrySet()) {
            BlockPos pos = entry.getKey();
            String data = entry.getValue();

            if (data.equals("spawner")) {
                spawners++;
                world.setBlockState(pos, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                TileEntity tile = world.getTileEntity(pos);

                if (tile instanceof TileEntityMobSpawner) {
                    if (Loader.isModLoaded("dungeontweaks")) {
                        try {
                            Constructor<? extends Event> constructor = (Constructor<? extends Event>) Class.forName("com.EvilNotch.dungeontweeks.main.Events.EventDungeon$Post").getConstructor(TileEntity.class, BlockPos.class, Random.class, ResourceLocation.class, World.class);
                            Event event = constructor.newInstance(tile, tile.getPos(), world.rand, new ResourceLocation(MOD_ID, "dungeon"), world);
                            MinecraftForge.EVENT_BUS.post(event);
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    } else
                        ((TileEntityMobSpawner) tile).getSpawnerBaseLogic().setEntityId(DungeonHooks.getRandomDungeonMob(rand));
                }
            } else if (data.equals("chests"))
                chests.add(pos);
        }

        int maxChests = spawners * 2 + rand.nextInt(spawners + 2);
        while (chests.size() > maxChests) {
            int i = rand.nextInt(chests.size());
            BlockPos chestPos = chests.get(i);
            chests.remove(i);
            world.setBlockToAir(chestPos);
        }

        for (BlockPos pos : chests) {
            world.setBlockState(pos, Blocks.CHEST.correctFacing(world, pos, Blocks.CHEST.getDefaultState()), 2);
            TileEntity tile = world.getTileEntity(pos);
            String lootTableStr = "";
            ResourceLocation lootTable = lootTableStr.isEmpty() ? null : new ResourceLocation(lootTableStr);

            if (tile instanceof TileEntityChest) {
                if (lootTable == null)
                    ((TileEntityChest) tile).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
                else ((TileEntityChest) tile).setLootTable(lootTable, rand.nextLong());
            }
        }
    }

}