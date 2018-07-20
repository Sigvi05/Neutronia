package net.hdt.neutronia.items.base.tools;

import net.hdt.neutronia.base.util.Reference;
import net.hdt.huskylib2.items.ItemModPickaxe;

public class BasePickaxe extends ItemModPickaxe {

    public BasePickaxe(String name, ToolMaterial material) {
        super(material, name, Reference.MOD_ID);
    }

}
