package net.hdt.neutronia.base.tags;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import java.util.Collection;

public class FluidTags
{
    private static TagCollection<Fluid> field_206961_c = new TagCollection<Fluid>((p_206955_0_) -> false, (p_206957_0_) -> null, "", false, "");
    private static int field_206962_d;
    public static final Tag<Fluid> WATER = func_206956_a("water");
    public static final Tag<Fluid> LAVA = func_206956_a("lava");

    public static void func_206953_a(TagCollection<Fluid> p_206953_0_)
    {
        field_206961_c = p_206953_0_;
        ++field_206962_d;
    }

    private static Tag<Fluid> func_206956_a(String p_206956_0_)
    {
        return new FluidTags.Wrapper(new ResourceLocation(p_206956_0_));
    }

    public static class Wrapper extends Tag<Fluid>
    {
        private int field_206950_a = -1;
        private Tag<Fluid> field_206951_b;

        public Wrapper(ResourceLocation p_i49117_1_)
        {
            super(p_i49117_1_);
        }

        public boolean func_199685_a_(Fluid p_199685_1_)
        {
            if (this.field_206950_a != FluidTags.field_206962_d)
            {
                this.field_206951_b = FluidTags.field_206961_c.func_199915_b(this.func_199886_b());
                this.field_206950_a = FluidTags.field_206962_d;
            }

            return this.field_206951_b.func_199685_a_(p_199685_1_);
        }

        public Collection<Fluid> func_199885_a()
        {
            if (this.field_206950_a != FluidTags.field_206962_d)
            {
                this.field_206951_b = FluidTags.field_206961_c.func_199915_b(this.func_199886_b());
                this.field_206950_a = FluidTags.field_206962_d;
            }

            return this.field_206951_b.func_199885_a();
        }

        public Collection<ITagEntry<Fluid>> func_200570_b()
        {
            if (this.field_206950_a != FluidTags.field_206962_d)
            {
                this.field_206951_b = FluidTags.field_206961_c.func_199915_b(this.func_199886_b());
                this.field_206950_a = FluidTags.field_206962_d;
            }

            return this.field_206951_b.func_200570_b();
        }
    }
}
