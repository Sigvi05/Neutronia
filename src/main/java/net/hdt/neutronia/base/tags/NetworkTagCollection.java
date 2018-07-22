package net.hdt.neutronia.base.tags;

import com.google.common.collect.Lists;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

public class NetworkTagCollection<T> extends TagCollection<T>
{
    private final RegistryNamespaced<ResourceLocation, T> field_200044_a;

    public NetworkTagCollection(RegistryNamespaced<ResourceLocation, T> p_i48237_1_, String p_i48237_2_, String p_i48237_3_)
    {
        super(p_i48237_1_::containsKey, p_i48237_1_::getObject, p_i48237_2_, false, p_i48237_3_);
        this.field_200044_a = p_i48237_1_;
    }

    public void func_200042_a(PacketBuffer p_200042_1_)
    {
        p_200042_1_.writeVarInt(this.func_200039_c().size());

        for (Entry<ResourceLocation, Tag<T>> entry : this.func_200039_c().entrySet())
        {
            p_200042_1_.writeResourceLocation(entry.getKey());
            p_200042_1_.writeVarInt(((Tag)entry.getValue()).func_199885_a().size());

            for (T t : (entry.getValue()).func_199885_a())
            {
                p_200042_1_.writeVarInt(this.field_200044_a.getIDForObject(t));
            }
        }
    }

    public void func_200043_b(PacketBuffer p_200043_1_)
    {
        int i = p_200043_1_.readVarInt();

        for (int j = 0; j < i; ++j)
        {
            ResourceLocation resourcelocation = p_200043_1_.readResourceLocation();
            int k = p_200043_1_.readVarInt();
            List<T> list = Lists.<T>newArrayList();

            for (int l = 0; l < k; ++l)
            {
                list.add(this.field_200044_a.getObjectById(p_200043_1_.readVarInt()));
            }

            this.func_200039_c().put(resourcelocation, (Tag<T>) Tag.Builder.func_200047_a().func_200046_a(Collections.singleton(list)).func_200051_a(resourcelocation));
        }
    }
}
