package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.thegaminghuskymc.huskylib2.items.ItemModSword;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BaseSword extends ItemModSword  {

    public BaseSword(String name, ToolMaterial material) {
        super(name, MOD_ID, material);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

}
