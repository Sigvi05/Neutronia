package net.hdt.neutronia.base.tags;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Tag<T>
{
    private final ResourceLocation field_199888_a;
    private final Set<T> field_199889_b;
    private final Collection<ITagEntry<T>> field_200150_c;

    public Tag(ResourceLocation p_i48236_1_)
    {
        this.field_199888_a = p_i48236_1_;
        this.field_199889_b = Collections.<T>emptySet();
        this.field_200150_c = Collections.<Tag.ITagEntry<T>>emptyList();
    }

    public Tag(ResourceLocation p_i48224_1_, Collection<ITagEntry<T>> p_i48224_2_, boolean p_i48224_3_)
    {
        this.field_199888_a = p_i48224_1_;
        this.field_199889_b = (Set<T>)(p_i48224_3_ ? Sets.newLinkedHashSet() : Sets.newHashSet());
        this.field_200150_c = p_i48224_2_;

        for (Tag.ITagEntry<T> itagentry : p_i48224_2_)
        {
            itagentry.func_200162_a(this.field_199889_b);
        }
    }

    public JsonObject func_200571_a(Function<T, ResourceLocation> p_200571_1_)
    {
        JsonObject jsonobject = new JsonObject();
        JsonArray jsonarray = new JsonArray();

        for (Tag.ITagEntry<T> itagentry : this.field_200150_c)
        {
            itagentry.func_200576_a(jsonarray, p_200571_1_);
        }

        jsonobject.addProperty("replace", false);
        jsonobject.add("values", jsonarray);
        return jsonobject;
    }

    public boolean func_199685_a_(T p_199685_1_)
    {
        return this.field_199889_b.contains(p_199685_1_);
    }

    public Collection<T> func_199885_a()
    {
        return this.field_199889_b;
    }

    public Collection<ITagEntry<T>> func_200570_b()
    {
        return this.field_200150_c;
    }

    public T func_205596_a(Random p_205596_1_)
    {
        List<T> list = Lists.newArrayList(this.func_199885_a());
        return list.get(p_205596_1_.nextInt(list.size()));
    }

    public ResourceLocation func_199886_b()
    {
        return this.field_199888_a;
    }

    public static class Builder<T>
    {
        private final Set<ITagEntry<T>> field_200052_a = Sets.<Tag.ITagEntry<T>>newLinkedHashSet();
        private boolean field_200053_b;

        public static <T> Tag.Builder<T> func_200047_a()
        {
            return new Tag.Builder<T>();
        }

        public Tag.Builder<T> func_200575_a(Tag.ITagEntry<T> p_200575_1_)
        {
            this.field_200052_a.add(p_200575_1_);
            return this;
        }

        public Tag.Builder<T> func_200048_a(T p_200048_1_)
        {
            this.field_200052_a.add(new Tag.ListEntry<T>(Collections.singleton(p_200048_1_)));
            return this;
        }

        @SafeVarargs
        public final Tag.Builder<T> func_200573_a(T... p_200573_1_)
        {
            this.field_200052_a.add(new Tag.ListEntry<T>(Lists.newArrayList(p_200573_1_)));
            return this;
        }

        public Tag.Builder<T> func_200046_a(Collection<T> p_200046_1_)
        {
            this.field_200052_a.add(new Tag.ListEntry<T>(p_200046_1_));
            return this;
        }

        public Tag.Builder<T> func_200159_a(ResourceLocation p_200159_1_)
        {
            this.field_200052_a.add(new Tag.TagEntry<T>(p_200159_1_));
            return this;
        }

        public Tag.Builder<T> func_200574_a(Tag<T> p_200574_1_)
        {
            this.field_200052_a.add(new Tag.TagEntry<T>(p_200574_1_));
            return this;
        }

        public Tag.Builder<T> func_200045_a(boolean p_200045_1_)
        {
            this.field_200053_b = p_200045_1_;
            return this;
        }

        public boolean func_200160_a(Function<ResourceLocation, Tag<T>> p_200160_1_)
        {
            for (Tag.ITagEntry<T> itagentry : this.field_200052_a)
            {
                if (!itagentry.func_200161_a(p_200160_1_))
                {
                    return false;
                }
            }

            return true;
        }

        public Tag<T> func_200051_a(ResourceLocation p_200051_1_)
        {
            return new Tag<T>(p_200051_1_, this.field_200052_a, this.field_200053_b);
        }

        public Tag.Builder<T> func_200158_a(Predicate<ResourceLocation> p_200158_1_, Function<ResourceLocation, T> p_200158_2_, JsonObject p_200158_3_)
        {
            JsonArray jsonarray = JsonUtils.getJsonArray(p_200158_3_, "values");

            if (JsonUtils.getBoolean(p_200158_3_, "replace", false))
            {
                this.field_200052_a.clear();
            }

            for (JsonElement jsonelement : jsonarray)
            {
                String s = JsonUtils.getString(jsonelement, "value");

                if (!s.startsWith("#"))
                {
                    ResourceLocation resourcelocation = new ResourceLocation(s);
                    T t = p_200158_2_.apply(resourcelocation);

                    if (t == null || !p_200158_1_.test(resourcelocation))
                    {
                        throw new JsonParseException("Unknown value '" + resourcelocation + "'");
                    }

                    this.func_200048_a(t);
                }
                else
                {
                    this.func_200159_a(new ResourceLocation(s.substring(1)));
                }
            }

            return this;
        }
    }

    public interface ITagEntry<T>
    {
    default boolean func_200161_a(Function<ResourceLocation, Tag<T>> p_200161_1_)
        {
            return true;
        }

        void func_200162_a(Collection<T> p_200162_1_);

        void func_200576_a(JsonArray p_200576_1_, Function<T, ResourceLocation> p_200576_2_);
    }

    public static class ListEntry<T> implements Tag.ITagEntry<T>
    {
        private final Collection<T> field_200165_a;

        public ListEntry(Collection<T> p_i48227_1_)
        {
            this.field_200165_a = p_i48227_1_;
        }

        public void func_200162_a(Collection<T> p_200162_1_)
        {
            p_200162_1_.addAll(this.field_200165_a);
        }

        public void func_200576_a(JsonArray p_200576_1_, Function<T, ResourceLocation> p_200576_2_)
        {
            for (T t : this.field_200165_a)
            {
                ResourceLocation resourcelocation = p_200576_2_.apply(t);

                if (resourcelocation == null)
                {
                    throw new IllegalStateException("Unable to serialize an anonymous value to json!");
                }

                p_200576_1_.add(resourcelocation.toString());
            }
        }

        public Collection<T> func_200578_a()
        {
            return this.field_200165_a;
        }
    }

    public static class TagEntry<T> implements Tag.ITagEntry<T>
    {
        @Nullable
        private final ResourceLocation field_200163_a;
        @Nullable
        private Tag<T> field_200164_b;

        public TagEntry(ResourceLocation p_i48228_1_)
        {
            this.field_200163_a = p_i48228_1_;
        }

        public TagEntry(Tag<T> p_i48229_1_)
        {
            this.field_200163_a = p_i48229_1_.func_199886_b();
            this.field_200164_b = p_i48229_1_;
        }

        public boolean func_200161_a(Function<ResourceLocation, Tag<T>> p_200161_1_)
        {
            if (this.field_200164_b == null)
            {
                this.field_200164_b = p_200161_1_.apply(this.field_200163_a);
            }

            return this.field_200164_b != null;
        }

        public void func_200162_a(Collection<T> p_200162_1_)
        {
            if (this.field_200164_b == null)
            {
                throw new IllegalStateException("Cannot build unresolved tag entry");
            }
            else
            {
                p_200162_1_.addAll(this.field_200164_b.func_199885_a());
            }
        }

        public ResourceLocation func_200577_a()
        {
            if (this.field_200164_b != null)
            {
                return this.field_200164_b.func_199886_b();
            }
            else if (this.field_200163_a != null)
            {
                return this.field_200163_a;
            }
            else
            {
                throw new IllegalStateException("Cannot serialize an anonymous tag to json!");
            }
        }

        public void func_200576_a(JsonArray p_200576_1_, Function<T, ResourceLocation> p_200576_2_)
        {
            p_200576_1_.add("#" + this.func_200577_a());
        }
    }
}
