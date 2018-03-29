package net.thegaminghuskymc.mcaddon.util;

import net.minecraft.util.WeightedRandom;

import java.util.List;
import java.util.Random;

public class WeightedUtil
{
    public static NamedItem getRandomNamedItem(Random rand, List<NamedItem> variants)
    {
        return WeightedRandom.getRandomItem(rand, variants);
    }

    public static class NamedItem extends WeightedRandom.Item
    {
        public String name;

        public NamedItem(String nameIn, int weight)
        {
            super(weight);
            name = nameIn;
        }
    }
}