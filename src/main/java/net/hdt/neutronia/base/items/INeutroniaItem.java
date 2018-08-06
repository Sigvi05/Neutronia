package net.hdt.neutronia.base.items;

import net.hdt.huskylib2.interf.IVariantHolder;
import net.hdt.neutronia.base.lib.LibMisc;

public interface INeutroniaItem extends IVariantHolder {

    @Override
    default String getModNamespace() {
        return LibMisc.MOD_ID;
    }

}