package net.thegaminghuskymc.mcaddon.entity.render;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.thegaminghuskymc.mcaddon.entity.EntityMummyVillager;
import net.thegaminghuskymc.mcaddon.entity.render.model.ModelMummyVillager;

import static net.thegaminghuskymc.mcaddon.util.Reference.MOD_ID;

public class RenderMummyVillager extends RenderBiped<EntityMummyVillager> {

    private static final ResourceLocation ZOMBIE_VILLAGER_TEXTURES = new ResourceLocation(MOD_ID, "textures/entity/mummy_villagers/villager.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_FARMER_LOCATION = new ResourceLocation(MOD_ID, "textures/entity/mummy_villagers/farmer.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_LIBRARIAN_LOC = new ResourceLocation(MOD_ID, "textures/entity/mummy_villagers/librarian.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_PRIEST_LOCATION = new ResourceLocation(MOD_ID, "textures/entity/mummy_villagers/priest.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_SMITH_LOCATION = new ResourceLocation(MOD_ID, "textures/entity/mummy_villagers/smith.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_BUTCHER_LOCATION = new ResourceLocation(MOD_ID, "textures/entity/mummy_villagers/butcher.png");

    public RenderMummyVillager(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelMummyVillager(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMummyVillager entity) {
        switch (entity.getProfession()) {
            case 0:
                return ZOMBIE_VILLAGER_FARMER_LOCATION;
            case 1:
                return ZOMBIE_VILLAGER_LIBRARIAN_LOC;
            case 2:
                return ZOMBIE_VILLAGER_PRIEST_LOCATION;
            case 3:
                return ZOMBIE_VILLAGER_SMITH_LOCATION;
            case 4:
                return ZOMBIE_VILLAGER_BUTCHER_LOCATION;
            case 5:
            default:
                return ZOMBIE_VILLAGER_TEXTURES;
        }
    }

    @Override
    protected void applyRotations(EntityMummyVillager entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        if (entityLiving.isConverting())
            rotationYaw += (float)(Math.cos((double)entityLiving.ticksExisted * 3.25D) * Math.PI * 0.25D);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
