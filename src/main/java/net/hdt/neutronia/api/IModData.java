package net.hdt.neutronia.api;

import net.minecraft.creativetab.CreativeTabs;

public interface IModData
{
    String getModId();

    CreativeTabs getCreativeTab();
}