package net.thegaminghuskymc.mcaddon.world;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.World;

public interface IGeneratable {
    void generateIn(World var1, int var2, int var3, int var4, Rotation var5, Mirror var6, boolean var7);

    void calcDimensions();

    int getWidth();

    int getLength();
}
