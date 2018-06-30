package net.hdt.neutronia.world.biome.overworld;

import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.world.biome.overworld.decorator.BiomeDesertDecorator;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeBlackDesert extends Biome {

    public BiomeBlackDesert() {
        super((new BiomeProperties("Black Desert")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setWaterColor(0x1b1b1b).setRainDisabled());
        topBlock = NBlocks.test.getDefaultState();
        fillerBlock = NBlocks.newStoneVariants[2].getDefaultState();
        setMobSpawns();
    }

    public final void setMobSpawns() {
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 4, 2, 3));
        this.spawnableMonsterList.removeIf(biome$spawnlistentry -> biome$spawnlistentry.entityClass == EntityZombie.class || biome$spawnlistentry.entityClass == EntityZombieVillager.class);
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombie.class, 19, 4, 4));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityZombieVillager.class, 1, 1, 1));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityHusk.class, 80, 4, 4));
    }

    @Override
    public int getWaterColorMultiplier() {
        return 0x2c3445;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 0x2c452e;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 0x2c452e;
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDesertDecorator(topBlock.getBlock(), fillerBlock.getBlock());
    }

    /*@Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180622_4_, int p_180622_5_, double p_180622_6_)
    {
        generateAbyssalWastelandTerrain(worldIn, rand, chunkPrimerIn, p_180622_4_, p_180622_5_, p_180622_6_);
    }

    public final void generateAbyssalWastelandTerrain(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180628_4_, int p_180628_5_, double p_180628_6_)
    {
        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = topBlock;
        IBlockState iblockstate1 = fillerBlock;
        int j = -1;
        int k = (int)(p_180628_6_ / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = p_180628_4_ & 15;
        int i1 = p_180628_5_ & 15;
        new BlockPos.MutableBlockPos();

        for (int j1 = 255; j1 >= 0; --j1)
            if (j1 <= rand.nextInt(5))
                chunkPrimerIn.setBlockState(i1, j1, l, Blocks.BEDROCK.getDefaultState());
            else
            {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR)
                    j = -1;
                else if (iblockstate2 == ACBlocks.stone.getStateFromMeta(1))
                    if (j == -1)
                    {
                        if (k <= 0)
                        {
                            iblockstate = null;
                            iblockstate1 = ACBlocks.stone.getStateFromMeta(1);
                        }
                        else if (j1 >= i - 4 && j1 <= i + 1)
                        {
                            iblockstate = topBlock;
                            iblockstate1 = fillerBlock;
                        }

                        j = k;

                        if (j1 >= i - 1)
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                        else if (j1 < i - 7 - k)
                        {
                            iblockstate = null;
                            iblockstate1 = ACBlocks.stone.getStateFromMeta(1);
                            chunkPrimerIn.setBlockState(i1, j1, l, ACBlocks.stone.getStateFromMeta(1));
                        } else
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                    }
                    else if (j > 0)
                    {
                        --j;
                        chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                    }
            }
    }*/

}
