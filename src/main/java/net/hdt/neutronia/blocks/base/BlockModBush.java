package net.hdt.neutronia.blocks.base;

import net.hdt.huskylib2.item.ItemModBlock;
import net.hdt.huskylib2.util.ProxyRegistry;
import net.hdt.neutronia.base.blocks.INeutroniaBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class BlockModBush extends BlockBush implements INeutroniaBlock {

    private final String[] variants;
    private final String bareName;

    public BlockModBush(String name, Material material) {
        super(material);
        variants = new String[]{name};
        bareName = name;

        setTranslationKey(name);
        setCreativeTab(CreativeTabs.SEARCH);
    }

    public Block setTranslationKey(String name) {
        super.setTranslationKey(name);
        this.setRegistryName(getPrefix(), name);
        ProxyRegistry.register(this);
        ProxyRegistry.register(createItemBlock(new ResourceLocation(getPrefix(), name)));
        return this;
    }

    private ItemBlock createItemBlock(ResourceLocation res) {
        return new ItemModBlock(this, res);
    }

    @Override
    public String getBareName() {
        return bareName;
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

    @Override
    public IProperty[] getIgnoredProperties() {
        return new IProperty[0];
    }

    @Override
    public IProperty getVariantProp() {
        return null;
    }

    @Override
    public Class getVariantEnum() {
        return null;
    }

    /*public static class Builder
    {
        private Material material;
        private MapColor mapColor;
        private boolean field_200955_c = true;
        private SoundType soundType = SoundType.STONE;
        private int field_200957_e;
        private float field_200958_f;
        private float field_200959_g;
        private boolean field_200960_h;
        private float field_200961_i = 0.6F;
        private boolean field_208772_j;

        private Builder(Material p_i48616_1_, MapColor p_i48616_2_)
        {
            this.material = p_i48616_1_;
            this.mapColor = p_i48616_2_;
        }

        public static BlockModBush.Builder func_200945_a(Material p_200945_0_)
        {
            return func_200949_a(p_200945_0_, p_200945_0_.getMaterialMapColor());
        }

        public static BlockModBush.Builder func_200949_a(Material p_200949_0_, MapColor p_200949_1_)
        {
            return new BlockModBush.Builder(p_200949_0_, p_200949_1_);
        }

        public static BlockModBush.Builder func_200950_a(Block p_200950_0_)
        {
            BlockModBush.Builder block$builder = new BlockModBush.Builder(p_200950_0_.blockMa, p_200950_0_.blockMapColor);
            block$builder.field_200953_a = p_200950_0_.material;
            block$builder.field_200959_g = p_200950_0_.blockHardness;
            block$builder.field_200958_f = p_200950_0_.blockResistance;
            block$builder.field_200955_c = p_200950_0_.field_196274_w;
            block$builder.field_200960_h = p_200950_0_.needsRandomTick;
            block$builder.field_200957_e = p_200950_0_.lightValue;
            block$builder.field_200953_a = p_200950_0_.material;
            block$builder.field_200954_b = p_200950_0_.blockMapColor;
            block$builder.field_200956_d = p_200950_0_.blockSoundType;
            block$builder.field_200961_i = p_200950_0_.func_208618_m();
            block$builder.field_208772_j = p_200950_0_.field_208621_p;
            return block$builder;
        }

        public BlockModBush.Builder func_200942_a()
        {
            this.field_200955_c = false;
            return this;
        }

        public BlockModBush.Builder func_200941_a(float p_200941_1_)
        {
            this.field_200961_i = p_200941_1_;
            return this;
        }

        protected BlockModBush.Builder func_200947_a(SoundType p_200947_1_)
        {
            this.field_200956_d = p_200947_1_;
            return this;
        }

        protected BlockModBush.Builder func_200951_a(int p_200951_1_)
        {
            this.field_200957_e = p_200951_1_;
            return this;
        }

        public BlockModBush.Builder func_200948_a(float p_200948_1_, float p_200948_2_)
        {
            this.field_200959_g = p_200948_1_;
            this.field_200958_f = Math.max(0.0F, p_200948_2_);
            return this;
        }

        protected BlockModBush.Builder func_200946_b()
        {
            return this.func_200943_b(0.0F);
        }

        protected BlockModBush.Builder func_200943_b(float p_200943_1_)
        {
            this.func_200948_a(p_200943_1_, p_200943_1_);
            return this;
        }

        protected BlockModBush.Builder func_200944_c()
        {
            this.field_200960_h = true;
            return this;
        }

        protected BlockModBush.Builder func_208770_d()
        {
            this.field_208772_j = true;
            return this;
        }
    }*/

}