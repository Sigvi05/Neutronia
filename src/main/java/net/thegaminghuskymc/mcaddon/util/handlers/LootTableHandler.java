package net.thegaminghuskymc.mcaddon.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.thegaminghuskymc.mcaddon.util.Reference;

public class LootTableHandler {

    public static final ResourceLocation MUMMY = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mummy"));
    public static final ResourceLocation MUMMY_VILLAGER = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "mummy_villager"));
    public static final ResourceLocation SCORP = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "scorp"));
}
