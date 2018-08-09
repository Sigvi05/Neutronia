package net.hdt.neutronia.groups.management.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.lib.LibMisc;
import net.hdt.neutronia.groups.management.capability.ShulkerBoxDropIn;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RightClickAddToShulkerBox extends Component {

    private static final ResourceLocation SHULKER_BOX_CAP = new ResourceLocation(LibMisc.MOD_ID, "shulker_box_drop_in");

    @SubscribeEvent
    public void onAttachCapability(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().getItem() instanceof ItemShulkerBox)
            event.addCapability(SHULKER_BOX_CAP, new ShulkerBoxDropIn());
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

}
