package net.hdt.neutronia.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;

import java.util.ArrayList;
import java.util.List;

public class BiomeUtils {

    public static List<Biome> getAllowedBiomes() {
        final List<Biome> biomes = new ArrayList<>();
        for (Biome biome : Biome.REGISTRY) {
            if (biome != null) {
                biomes.add(biome);
            }
        }

        return biomes;
    }

    public static BlockPos spiralOutwardsLookingForBiome(ICommandSender sender, World world, Biome biomeToFind, double startX, double startZ, int timeout) {
        double a = 16 / Math.sqrt(Math.PI);
        double b = 2 * Math.sqrt(Math.PI);
        double x;
        double z;
        double dist = 0;
        int n;
        long start = System.currentTimeMillis();
        BlockPos.PooledMutableBlockPos pos = BlockPos.PooledMutableBlockPos.retain();
        int previous = 0;
        int i = 0;
        for (n = 0; dist < Integer.MAX_VALUE; ++n) {
            if ((System.currentTimeMillis() - start) > timeout) {
                return null;
            }
            double rootN = Math.sqrt(n);
            dist = a * rootN;
            x = startX + (dist * Math.sin(b * rootN));
            z = startZ + (dist * Math.cos(b * rootN));
            pos.setPos(x, 0, z);
            if (sender instanceof EntityPlayer) {
                if (previous == 3)
                    previous = 0;
                String s = (previous == 0 ? "." : previous == 1 ? ".." : "...");
                ((EntityPlayer) sender).sendStatusMessage(new TextComponentString("Scanning" + s), true);
                if (i == 1501) {
                    previous++;
                    i = 0;
                }
                i++;
            }
            if (world.getBiome(pos).equals(biomeToFind)) {
                pos.release();
                if (sender instanceof EntityPlayer)
                    ((EntityPlayer) sender).sendStatusMessage(new TextComponentString("Found Biome"), true);
                return new BlockPos((int) x, 0, (int) z);
            }
        }
        return null;
    }

    public static SearchResult searchForBiome(World world, Biome biome, BlockPos startPos) {
        final int sampleSpace = 16 * getBiomeSize(world);
        final int maxDistance = 250000 * getBiomeSize(world);
        if (maxDistance <= 0 || sampleSpace <= 0) {
            return new SearchResult(0, 0, maxDistance, 0, false);
        }

        final BiomeProvider biomeProvider = world.getBiomeProvider();
        int direction = -1;
        int samples = 0;
        int nextLength = sampleSpace;
        int x = startPos.getX();
        int z = startPos.getZ();
        while (nextLength / 2 <= maxDistance && samples <= 100000) {
            final int fixedDirection = direction == -1 ? -1 : direction % 4;
            for (int i = 0; i < nextLength; i += sampleSpace) {
                if (fixedDirection == 0) {
                    x += sampleSpace;
                } else if (fixedDirection == 1) {
                    z -= sampleSpace;
                } else if (fixedDirection == 2) {
                    x -= sampleSpace;
                } else if (fixedDirection == 3) {
                    z += sampleSpace;
                }

                final Biome[] biomes = biomeProvider.getBiomes(null, x, z, 1, 1, false);
                if (biomes[0] == biome) {
                    return new SearchResult(x, z, nextLength / 2, samples, true);
                }

                samples++;
            }

            if (direction >= 0) {
                nextLength += sampleSpace;
            }
            direction++;
        }

        return new SearchResult(0, 0, nextLength / 2, samples, false);
    }

    public static int getBiomeSize(World world) {
        final String settings = world.getWorldInfo().getGeneratorOptions();
        return ChunkGeneratorSettings.Factory.jsonToFactory(settings).build().biomeSize;
    }

    public static int getDistanceToBiome(EntityPlayer player, int x, int z) {
        return (int) player.getDistance(x, player.posY, z);
    }

    public static String getBiomeName(Biome biome) {
        if (biome != null) {
            final String original = biome.getBiomeName();
            StringBuilder fixed = new StringBuilder();
            char pre = ' ';
            for (int i = 0; i < original.length(); i++) {
                final char c = original.charAt(i);
                if (Character.isUpperCase(c) && Character.isLowerCase(pre) && Character.isAlphabetic(pre)) {
                    fixed.append(" ");
                }
                fixed.append(String.valueOf(c));
                pre = c;
            }

            return fixed.toString();

        }

        return "";
    }

    public static String getBiomeName(int biomeID) {
        return getBiomeName(Biome.getBiomeForId(biomeID));
    }

}