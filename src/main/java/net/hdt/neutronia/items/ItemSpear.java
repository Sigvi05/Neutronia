package net.hdt.neutronia.items;

import net.hdt.neutronia.items.base.tools.BaseSword;

public class ItemSpear extends BaseSword implements IExtendedReach {

    public ItemSpear(String name, ToolMaterial material) {
        super(name, material);
    }

    @Override
    public float getReach() {
        return 7.0F;
    }

}
