package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.groups.Component;
import net.hdt.neutronia.base.util.player.PlayerHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by primetoxinz on 5/13/17.
 */
public class HeadDrops extends Component {

    @Override
    public String getFeatureDescription() {
        return "Heads and Skulls can drop when killed";
    }

    @SubscribeEvent
    public void onLivingDrop(LivingDropsEvent event) {
        addHead(event, 3);
    }

    public void addDrop(LivingDropsEvent evt, ItemStack drop) {
        EntityItem item = new EntityItem(evt.getEntityLiving().getEntityWorld(), evt.getEntityLiving().posX, evt.getEntityLiving().posY, evt.getEntityLiving().posZ, drop);
        item.setDefaultPickupDelay();
        evt.getDrops().add(item);
    }

    public void addHead(LivingDropsEvent evt, int chance) {
        if (chance > 0 && evt.getEntity().getEntityWorld().rand.nextInt(chance) != 0)
            return;
        if (evt.getEntityLiving() instanceof EntitySkeleton)
            addDrop(evt, new ItemStack(Items.SKULL, 1, 0));
        else if (evt.getEntityLiving() instanceof EntityWitherSkeleton)
            addDrop(evt, new ItemStack(Items.SKULL, 1, 1));
        else if (evt.getEntityLiving() instanceof EntityZombie)
            addDrop(evt, new ItemStack(Items.SKULL, 1, 2));
        else if (evt.getEntityLiving() instanceof EntityCreeper)
            addDrop(evt, new ItemStack(Items.SKULL, 1, 4));
        else if (evt.getEntityLiving() instanceof EntityPlayer) {
            addDrop(evt, PlayerHelper.getPlayerHead((EntityPlayer) evt.getEntityLiving()));
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
