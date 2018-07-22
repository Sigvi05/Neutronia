package net.hdt.neutronia.base.tags;

import net.minecraft.block.Block;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;

public class NetworkTagManager implements IResourceManagerReloadListener
{
    private final NetworkTagCollection<Block> field_199719_a = new NetworkTagCollection<Block>(Block.REGISTRY, "tags/blocks", "block");
    private final NetworkTagCollection<Item> field_199720_b = new NetworkTagCollection<Item>(Item.REGISTRY, "tags/items", "item");
//    private final NetworkTagCollection<Fluid> field_205705_c = new NetworkTagCollection<Fluid>(ModelFluid.FluidLoader.INSTANCE, "tags/fluids", "fluid");

    public NetworkTagCollection<Block> func_199717_a()
    {
        return this.field_199719_a;
    }

    public NetworkTagCollection<Item> func_199715_b()
    {
        return this.field_199720_b;
    }

    /*public NetworkTagCollection<Fluid> func_205704_c()
    {
        return this.field_205705_c;
    }*/

    public void func_199718_c()
    {
        this.field_199719_a.func_199917_b();
        this.field_199720_b.func_199917_b();
//        this.field_205705_c.func_199917_b();
    }

    public void onResourceManagerReload(IResourceManager p_195410_1_)
    {
        this.func_199718_c();
        this.field_199719_a.func_199909_a(p_195410_1_);
        this.field_199720_b.func_199909_a(p_195410_1_);
//        this.field_205705_c.func_199909_a(p_195410_1_);
        BlockTags.func_199895_a(this.field_199719_a);
        ItemTags.func_199902_a(this.field_199720_b);
//        FluidTags.func_206953_a(this.field_205705_c);
    }

    public void func_199716_a(PacketBuffer p_199716_1_)
    {
        this.field_199719_a.func_200042_a(p_199716_1_);
        this.field_199720_b.func_200042_a(p_199716_1_);
//        this.field_205705_c.func_200042_a(p_199716_1_);
    }

    public static NetworkTagManager func_199714_b(PacketBuffer p_199714_0_)
    {
        NetworkTagManager networktagmanager = new NetworkTagManager();
        networktagmanager.func_199717_a().func_200043_b(p_199714_0_);
        networktagmanager.func_199715_b().func_200043_b(p_199714_0_);
//        networktagmanager.func_205704_c().func_200043_b(p_199714_0_);
        return networktagmanager;
    }

}
