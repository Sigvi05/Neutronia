package net.hdt.neutronia.entity;

import net.hdt.neutronia.base.util.handlers.LootTableHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityEnderPhantom extends EntityPhantomBase {

    public EntityEnderPhantom(World worldIn) {
        super(worldIn);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.ENDER_PHANTOM;
    }

}