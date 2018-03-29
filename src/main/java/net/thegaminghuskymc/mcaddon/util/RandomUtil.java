package net.thegaminghuskymc.mcaddon.util;

import java.util.Random;

public class RandomUtil
{
    public static int getNumberInRange(int min, int max, Random rand)
    {
        return rand.nextInt(max - min + 1) + min;
    }
}