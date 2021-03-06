package net.hdt.neutronia.entity;

import net.hdt.neutronia.util.handlers.LootTableHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityPhantom extends EntityPhantomBase {

    public EntityPhantom(World worldIn) {
        super(worldIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.PHANTOM;
    }
}