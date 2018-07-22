package net.hdt.neutronia.base.tags;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;

public class TagCollection<T>
{
    private static final Logger field_199918_a = LogManager.getLogger();
    private static final Gson field_199919_b = new Gson();
    private static final int field_199920_c = ".json".length();
    private final Map<ResourceLocation, Tag<T>> field_199921_d = Maps.newHashMap();
    private final Function<ResourceLocation, T> field_200040_e;
    private final Predicate<ResourceLocation> field_200156_f;
    private final String field_199923_f;
    private final boolean field_200041_g;
    private final String field_200157_i;

    public TagCollection(Predicate<ResourceLocation> p_i48235_1_, Function<ResourceLocation, T> p_i48235_2_, String p_i48235_3_, boolean p_i48235_4_, String p_i48235_5_)
    {
        this.field_200156_f = p_i48235_1_;
        this.field_200040_e = p_i48235_2_;
        this.field_199923_f = p_i48235_3_;
        this.field_200041_g = p_i48235_4_;
        this.field_200157_i = p_i48235_5_;
    }

    public void func_199912_a(Tag<T> p_199912_1_)
    {
        if (this.field_199921_d.containsKey(p_199912_1_.func_199886_b()))
        {
            throw new IllegalArgumentException("Duplicate " + this.field_200157_i + " tag '" + p_199912_1_.func_199886_b() + "'");
        }
        else
        {
            this.field_199921_d.put(p_199912_1_.func_199886_b(), p_199912_1_);
        }
    }

    @Nullable
    public Tag<T> func_199910_a(ResourceLocation p_199910_1_)
    {
        return this.field_199921_d.get(p_199910_1_);
    }

    public Tag<T> func_199915_b(ResourceLocation p_199915_1_)
    {
        Tag<T> tag = this.field_199921_d.get(p_199915_1_);
        return tag == null ? new Tag(p_199915_1_) : tag;
    }

    public Collection<ResourceLocation> func_199908_a()
    {
        return this.field_199921_d.keySet();
    }

    public Collection<ResourceLocation> func_199913_a(T p_199913_1_)
    {
        List<ResourceLocation> list = Lists.newArrayList();

        for (Entry<ResourceLocation, Tag<T>> entry : this.field_199921_d.entrySet())
        {
            if (entry.getValue().func_199685_a_(p_199913_1_))
            {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    public void func_199917_b()
    {
        this.field_199921_d.clear();
    }

    public void func_199909_a(IResourceManager p_199909_1_)
    {
        Map<ResourceLocation, Tag.Builder<T>> map = Maps.newHashMap();

        try {
            for (IResource resourcelocation : p_199909_1_.getAllResources(new ResourceLocation(this.field_199923_f)))
            {
                String s = resourcelocation.getResourceLocation().getPath();
                ResourceLocation resourcelocation1 = new ResourceLocation(resourcelocation.getResourceLocation().getNamespace(), s.substring(this.field_199923_f.length() + 1, s.length() - field_199920_c));

                try
                {
                    for (IResource iresource : p_199909_1_.getAllResources(resourcelocation.getResourceLocation()))
                    {
                        try
                        {
                            JsonObject jsonobject = JsonUtils.gsonDeserialize(field_199919_b, IOUtils.toString(iresource.getInputStream(), StandardCharsets.UTF_8), JsonObject.class);

                            if (jsonobject == null)
                            {
                                field_199918_a.error("Couldn't load {} tag list {} from {} in data pack {} as it's empty or null", this.field_200157_i, resourcelocation1, resourcelocation, iresource.getInputStream());
                            }
                            else
                            {
                                Tag.Builder<T> builder = map.getOrDefault(resourcelocation1, Tag.Builder.func_200047_a());
                                builder.func_200158_a(this.field_200156_f, this.field_200040_e, jsonobject);
                                map.put(resourcelocation1, builder);
                            }
                        }
                        catch (RuntimeException | IOException ioexception)
                        {
                            field_199918_a.error("Couldn't read {} tag list {} from {} in data pack {}", this.field_200157_i, resourcelocation1, resourcelocation, iresource.getInputStream(), ioexception);
                        }
                        finally
                        {
                            IOUtils.closeQuietly(iresource);
                        }
                    }
                }
                catch (IOException ioexception1)
                {
                    field_199918_a.error("Couldn't read {} tag list {} from {}", this.field_200157_i, resourcelocation1, resourcelocation, ioexception1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        label149:

        while (!map.isEmpty())
        {
            boolean flag = false;
            Iterator<Entry<ResourceLocation, Tag.Builder<T>>> iterator = map.entrySet().iterator();

            while (iterator.hasNext())
            {
                Entry<ResourceLocation, Tag.Builder<T>> entry1 = iterator.next();

                if (entry1.getValue().func_200160_a(this::func_199910_a))
                {
                    flag = true;
                    this.func_199912_a((entry1.getValue()).func_200051_a(entry1.getKey()));
                    iterator.remove();
                }
            }

            if (!flag)
            {
                iterator = map.entrySet().iterator();

                while (true)
                {
                    if (!iterator.hasNext())
                    {
                        break label149;
                    }

                    Entry<ResourceLocation, Tag.Builder<T>> entry2 = iterator.next();
                    field_199918_a.error("Couldn't load {} tag {} as it either references another tag that doesn't exist, or ultimately references itself", this.field_200157_i, entry2.getKey());
                }
            }
        }

        for (Entry<ResourceLocation, Tag.Builder<T>> entry : map.entrySet())
        {
            this.func_199912_a((entry.getValue()).func_200045_a(this.field_200041_g).func_200051_a(entry.getKey()));
        }
    }

    public Map<ResourceLocation, Tag<T>> func_200039_c()
    {
        return this.field_199921_d;
    }
}
