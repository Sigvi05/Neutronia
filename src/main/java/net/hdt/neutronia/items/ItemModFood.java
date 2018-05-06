package net.hdt.neutronia.items;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.huskylib2.interf.IVariantHolder;
import net.thegaminghuskymc.huskylib2.utils.ProxyRegistry;

import java.util.ArrayList;

public class ItemModFood extends ItemFood implements IVariantHolder {

    public static final ArrayList<IVariantHolder> variantHolders = new ArrayList<>();

    private final String[] variants;
    private final String bareName, modid;

    public ItemModFood(String modid, String name, CreativeTabs creativeTabs, int amount, float saturation, boolean isWolfFood, String... variants) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(creativeTabs);
        if (variants.length > 1)
            setHasSubtypes(true);

        if (variants.length == 0)
            variants = new String[]{name};

        bareName = name;
        this.variants = variants;
        this.modid = modid;
        setUnlocalizedName(name);
        variantHolders.add(this);
    }

    public ItemModFood(String modid, String name, CreativeTabs creativeTabs, int amount, boolean isWolfFood, String... variants) {
        this(modid, name, creativeTabs, amount, 0.6F, isWolfFood, variants);
    }

    public Item setUnlocalizedName(String name) {
        super.setUnlocalizedName(name);
        this.setRegistryName(new ResourceLocation(getPrefix(), name));
        ProxyRegistry.register(this);
        return this;
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        int dmg = par1ItemStack.getItemDamage();
        String[] variants = getVariants();

        String name;
        if (dmg >= variants.length)
            name = bareName;
        else name = variants[dmg];

        return "item." + name;
    }

    @Override
    public String getPrefix() {
        return this.modid;
    }

    @Override
    public String getModNamespace() {
        return this.modid;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (isInCreativeTab(tab))
            for (int i = 0; i < getVariants().length; i++)
                subItems.add(new ItemStack(this, 1, i));
    }

    @Override
    public String[] getVariants() {
        return variants;
    }

    @Override
    public ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }

}