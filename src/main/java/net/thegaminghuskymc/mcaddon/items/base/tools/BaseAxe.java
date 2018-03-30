package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.thegaminghuskymc.huskylib2.items.ItemModAxe;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BaseAxe extends ItemModAxe  {

    public BaseAxe(String name, ToolMaterial material)  {
        super(material.getAttackDamage(), 1.0f, material, name, MOD_ID);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
