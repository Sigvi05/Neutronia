package net.hdt.neutronia.entity;

import net.hdt.neutronia.base.util.handlers.LootTableHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityBloodPhantom extends EntityPhantomBase {

    public EntityBloodPhantom(World worldIn) {
        super(worldIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.RED_PHANTOM;
    }

}