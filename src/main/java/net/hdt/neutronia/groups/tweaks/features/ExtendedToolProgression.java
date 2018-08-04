package net.hdt.neutronia.groups.tweaks.features;

import net.hdt.neutronia.base.groups.Component;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ExtendedToolProgression extends Component {

    private float attackDamage;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        /*try {
            Class<Item.ToolMaterial> toolMaterial = Item.ToolMaterial.class;
            Constructor<Item.ToolMaterial> con = toolMaterial.getDeclaredConstructor();
            con.setAccessible(true);
            con.newInstance((Object) null);
            System.out.println(con.toGenericString());
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }*/
    }

}
