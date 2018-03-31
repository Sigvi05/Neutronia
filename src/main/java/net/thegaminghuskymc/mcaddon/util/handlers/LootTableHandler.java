package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class LootTableHandler {

    public static final ResourceLocation MUMMY = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mummy"));
    public static final ResourceLocation MUMMY_VILLAGER = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mummy_villager"));
    public static final ResourceLocation SCORPION = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "scorpion"));
    public static final ResourceLocation PHANTOM = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "phantom"));
    public static final ResourceLocation RED_PHANTOM = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "red_phantom"));
    public static final ResourceLocation ENDER_PHANTOM = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "ender_phantom"));
}
