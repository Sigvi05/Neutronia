package net.thegaminghuskymc.mcaddon.items.base.tools;

import net.thegaminghuskymc.huskylib2.items.ItemModPickaxe;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class BasePickaxe extends ItemModPickaxe {

    public BasePickaxe(String name, ToolMaterial material)  {
        super(material, name, MOD_ID);
    }

}
