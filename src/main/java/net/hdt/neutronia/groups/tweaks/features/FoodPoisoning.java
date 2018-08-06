package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.util.player.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FoodPoisoning extends Component {
    @Override
    public boolean hasSubscriptions() {
        return true;
    }

    @Override
    public String getFeatureDescription() {
        return "No one wants to eat when they have food poisoning. When you have the Hunger effect you can't eat.";
    }

    //Stops Eating if Hunger Effect is active
    @SubscribeEvent
    public void onFood(LivingEntityUseItemEvent.Start event) {
        if (event.getItem().getItem() instanceof ItemFood && event.getEntityLiving() instanceof EntityPlayer && PlayerHelper.isSurvival((EntityPlayer) event.getEntityLiving())) {
            if (event.getEntityLiving().isPotionActive(MobEffects.HUNGER)) {
                event.setCanceled(true);
            }
        }
    }
}
