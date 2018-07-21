package net.hdt.neutronia.base.module_new;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Module implements Comparable<Module> {

    private String name, description;
    private ItemStack iconStack;

    public String getName() {
        if(name != null) {
            return name;
        } else {
            return makeName();
        }
    }

    private String makeName() {
        return getClass().getSimpleName().replaceAll("Neutronia", "").toLowerCase();
    }

    public ItemStack getIconStack() {
        if(iconStack != null)
            return iconStack;
        else
            return new ItemStack(Blocks.BARRIER);
    }

    @Override
    public int compareTo(Module module) {
        return name.compareTo(module.name);
    }

}
