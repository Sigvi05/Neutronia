package net.hdt.neutronia.module.thaumcraft;

import net.hdt.neutronia.init.NBlocks;
import net.hdt.neutronia.module.IModule;
import net.hdt.neutronia.properties.EnumCoralColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ModuleThaumcraft implements IModule {

    @Override
    public String getName() {
        return "Thaumcraft";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void handlePreInit(FMLPreInitializationEvent event) {
        ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.soulGlass), (new AspectList()).add(Aspect.SOUL, 1).add(Aspect.AURA, 1));
        for(EnumCoralColor coralColor : EnumCoralColor.values()) {
            ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.brain_coral[coralColor.getMetadata()]), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.EARTH, 4));
            ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.normal_coral[coralColor.getMetadata()]), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.EARTH, 4));
            ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.coral_fan[coralColor.getMetadata()]), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.EARTH, 4));
            ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.dead_brain_coral[coralColor.getMetadata()]), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.EARTH, 4).add(Aspect.DEATH, 2));
            ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.dead_normal_coral[coralColor.getMetadata()]), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.EARTH, 4).add(Aspect.DEATH, 2));
            ThaumcraftApi.registerObjectTag(new ItemStack(NBlocks.dead_coral_fan[coralColor.getMetadata()]), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.EARTH, 4).add(Aspect.DEATH, 2));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handlePreInitClient(FMLPreInitializationEvent event) {

    }

    @Override
    public void handlePostPreInit(FMLPreInitializationEvent event) {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handlePostPreInitClient(FMLPreInitializationEvent event) {

    }

    @Override
    public void handleInit(FMLInitializationEvent event) {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleInitClient(FMLInitializationEvent event) {

    }

    @Override
    public void handlePostInit(FMLPostInitializationEvent event) {

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handlePostInitClient(FMLPostInitializationEvent event) {

    }
}