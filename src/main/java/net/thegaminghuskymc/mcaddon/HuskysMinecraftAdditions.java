package net.thegaminghuskymc.mcaddon;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thegaminghuskymc.mcaddon.init.BiomeInit;
import net.thegaminghuskymc.mcaddon.init.MCAddonBlocks;
import net.thegaminghuskymc.mcaddon.init.NetherExBiomes;
import net.thegaminghuskymc.mcaddon.proxy.CommonProxy;
import net.thegaminghuskymc.mcaddon.world.gen.WorldGenCustomStructures;
import net.thegaminghuskymc.mcaddon.world.utils.ClayGenerator;
import net.thegaminghuskymc.mcaddon.world.utils.FormationCaveGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.*;

import static net.thegaminghuskymc.mcaddon.Reference.MOD_ID;

@Mod(modid = MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class HuskysMinecraftAdditions {

    @Mod.Instance
    public static HuskysMinecraftAdditions instance;
    private List<String> allowedBlocks;
    public static boolean isInDevEnv = false;

    private File configDirectory;

    private static final Logger LOGGER = LogManager.getLogger("Husky's Minecraft Additions | Main");

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    public static final CreativeTabs OVERWORLD_EXPANSION_TAB = new CreativeTabs("overworld_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(MCAddonBlocks.brain_coral[0]));
        }
    };

    public static final CreativeTabs NETHER_EXPANSION_TAB = new CreativeTabs("nether_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Blocks.NETHER_BRICK));
        }
    };

    public static final CreativeTabs END_EXPANSION_TAB = new CreativeTabs("end_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Blocks.END_BRICKS));
        }
    };

    public static final CreativeTabs WEAPON_EXPANSION_TAB = new CreativeTabs("weapons_expansion") {
        @Override
        public ItemStack getTabIconItem() {
            return ItemStack.EMPTY;
        }
    };

    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        LOGGER.info("PreInitialization started.");

        GameRegistry.registerWorldGenerator(new ClayGenerator(20, 3), 0);
        GameRegistry.registerWorldGenerator(new FormationCaveGenerator(), 1);
        proxy.preInit(event);

        LOGGER.info("PreInitialization completed.");

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

        LOGGER.info("Initialization started.");

        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
        Biome.SpawnListEntry blazeEntry = new Biome.SpawnListEntry(EntityBlaze.class, 5, 1, 2);
        BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).forEach(biome -> biome.getSpawnableList(EnumCreatureType.MONSTER).add(blazeEntry));
        BiomeInit.registerBiomes();
        NetherExBiomes.init();
        proxy.init(event);

        LOGGER.info("Initialization completed.");

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

        LOGGER.info("PostInitialization started.");

        NetherExBiomes.postInit();
        proxy.postInit(event);

        LOGGER.info("PostInitialization completed.");

    }

    @Mod.EventHandler
    public void onSpawn(LivingSpawnEvent.CheckSpawn event) {
        allowedBlocks = Arrays.asList(Objects.requireNonNull(Blocks.NETHERRACK.getRegistryName()).toString(),
                Objects.requireNonNull(Blocks.SOUL_SAND.getRegistryName()).toString(),
                Objects.requireNonNull(Blocks.MAGMA.getRegistryName()).toString());
        if(!event.isSpawner() && event.getEntityLiving() instanceof EntityBlaze && event.getResult() != Event.Result.DENY && event.getEntityLiving().world instanceof WorldServer) {
            EntityBlaze blaze = (EntityBlaze) event.getEntityLiving();
            WorldServer world = (WorldServer) blaze.world;
            BlockPos pos = blaze.getPosition();
            Block block = world.getBlockState(pos.down()).getBlock();
            ResourceLocation res = block.getRegistryName();
            if(res != null) {
                boolean allowedBlock = allowedBlocks.contains(res.toString());
                boolean fortress = world.getChunkProvider().isInsideStructure(world, "Fortress", pos);
                if(!fortress && !allowedBlock)
                    event.setResult(Event.Result.DENY);
            }
        }
    }

    @Mod.EventHandler
    public void decorate(DecorateBiomeEvent.Decorate event) {
        World world = event.getWorld();
        Biome biome = world.getBiome(event.getPos());
        Random rand = event.getRand();
        double bigMushroomsPerChunk = 0.5;
        WorldGenerator bigMushroomGen = new WorldGenBigMushroom();

        if((biome == Biomes.SWAMPLAND || biome == Biomes.MUTATED_SWAMPLAND) && event.getType() == DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM) {
            if(rand.nextDouble() > bigMushroomsPerChunk)
                return;

            int amount = (int) Math.max(1, bigMushroomsPerChunk);
            for(int i = 0; i < amount; i++) {
                int x = rand.nextInt(16) + 8;
                int y = rand.nextInt(16) + 8;
                bigMushroomGen.generate(world, rand, world.getHeight(event.getPos().add(x, 0, y)));
            }

            event.setResult(Event.Result.DENY);
        }
    }

    @Mod.EventHandler
    public void onDungeonSpawn(PopulateChunkEvent.Populate event) {
        if(event.getType() != PopulateChunkEvent.Populate.EventType.DUNGEON)
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
        if(couldDungeonGenerate(world, rand, generatePos) && world instanceof WorldServer) {
            placeDungeonAt((WorldServer) world, rand, generatePos);
            event.setResult(Event.Result.DENY);
        }
    }

    public boolean couldDungeonGenerate(World worldIn, Random rand, BlockPos position) {
        int i = 3;
        int j = rand.nextInt(2) + 2;
        int k = -j - 1;
        int l = j + 1;
        int i1 = -1;
        int j1 = 4;
        int k1 = rand.nextInt(2) + 2;
        int l1 = -k1 - 1;
        int i2 = k1 + 1;
        int j2 = 0;

        for(int k2 = k; k2 <= l; ++k2) {
            for(int l2 = -1; l2 <= 4; ++l2) {
                for(int i3 = l1; i3 <= i2; ++i3) {
                    BlockPos blockpos = position.add(k2, l2, i3);
                    Material material = worldIn.getBlockState(blockpos).getMaterial();
                    boolean flag = material.isSolid();

                    if(l2 == -1 && !flag)
                        return false;

                    if(l2 == 4 && !flag)
                        return false;

                    if((k2 == k || k2 == l || i3 == l1 || i3 == i2) && l2 == 0 && worldIn.isAirBlock(blockpos) && worldIn.isAirBlock(blockpos.up()))
                        ++j2;
                }
            }
        }

        return j2 >= 1 && j2 <= 5;
    }

    private void placeDungeonAt(WorldServer world, Random rand, BlockPos position) {
        int dungeonType = rand.nextInt(10);

        MinecraftServer server = world.getMinecraftServer();
        Template template = world.getStructureTemplateManager().getTemplate(server, new ResourceLocation(MOD_ID,"dungeon_" + dungeonType));
        PlacementSettings settings = new PlacementSettings();
        settings.setRotation(Rotation.values()[rand.nextInt(Rotation.values().length)]);

        BlockPos size = template.getSize();
        for(int x = 0; x < size.getX(); x++)
            for(int y = 0; y < size.getY(); y++)
                for(int z = 0; z < size.getZ(); z++) {
                    BlockPos checkPos = position.add(Template.transformedBlockPos(settings, new BlockPos(x, y, z)));
                    IBlockState checkState = world.getBlockState(checkPos);
                    if(checkState.getBlock().getBlockHardness(checkState, world, checkPos) == -1 || world.canBlockSeeSky(checkPos))
                        return; // Obstructed or exposed, can't generate here
                }

        template.addBlocksToWorld(world, position, settings);

        int spawners = 0;
        List<BlockPos> chests = new ArrayList<>();
        Map<BlockPos, String> dataBlocks = template.getDataBlocks(position, settings);

        for(Map.Entry<BlockPos, String> entry : dataBlocks.entrySet()) {
            BlockPos pos = entry.getKey();
            String data = entry.getValue();

            if(data.equals("spawner")) {
                spawners++;
                world.setBlockState(pos, Blocks.MOB_SPAWNER.getDefaultState(), 2);
                TileEntity tile = world.getTileEntity(pos);

                if(tile instanceof TileEntityMobSpawner) {
                    if(Loader.isModLoaded("dungeontweaks")) {
                        try {
                            Constructor<? extends Event> constructor = (Constructor<? extends Event>) Class.forName("com.EvilNotch.dungeontweeks.main.Events.EventDungeon$Post").getConstructor(TileEntity.class, BlockPos.class, Random.class, ResourceLocation.class, World.class);
                            Event event = constructor.newInstance(tile, tile.getPos(), world.rand, new ResourceLocation(MOD_ID,"dungeon"), world);
                            MinecraftForge.EVENT_BUS.post(event);
                        } catch(Throwable t) {
                            t.printStackTrace();
                        }
                    } else ((TileEntityMobSpawner) tile).getSpawnerBaseLogic().setEntityId(DungeonHooks.getRandomDungeonMob(rand));
                }
            }
            else if(data.equals("chest"))
                chests.add(pos);
        }

        int maxChests = spawners * 2 + rand.nextInt(spawners + 2);
        while(chests.size() > maxChests) {
            int i = rand.nextInt(chests.size());
            BlockPos chestPos = chests.get(i);
            chests.remove(i);
            world.setBlockToAir(chestPos);
        }

        for(BlockPos pos : chests) {
            world.setBlockState(pos, Blocks.CHEST.correctFacing(world, pos, Blocks.CHEST.getDefaultState()), 2);
            TileEntity tile = world.getTileEntity(pos);
            String lootTableStr = "";
            ResourceLocation lootTable =  lootTableStr.isEmpty() ? null : new ResourceLocation(lootTableStr);

            if(tile instanceof TileEntityChest) {
                if(lootTable == null)
                    ((TileEntityChest) tile).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
                else ((TileEntityChest) tile).setLootTable(lootTable, rand.nextLong());
            }
        }
    }

}