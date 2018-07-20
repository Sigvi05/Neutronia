package net.hdt.neutronia.items.base.tools;

import net.hdt.neutronia.base.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.hdt.huskylib2.items.ItemModAxe;

public class BaseAxe extends ItemModAxe {

    public BaseAxe(String name, ToolMaterial material) {
        super(material.getAttackDamage(), 1.0f, material, name, Reference.MOD_ID);
        setCreativeTab(CreativeTabs.TOOLS);
    }
}
