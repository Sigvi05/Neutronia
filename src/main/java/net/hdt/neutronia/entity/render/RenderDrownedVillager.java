package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntityMummyVillager;
import net.hdt.neutronia.entity.render.model.ModelMummyVillager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDrownedVillager extends RenderBiped<EntityMummyVillager> {
    /**
     * TODO: Change Textures
     * Set to Zombie Villager for now
     */
    private static final ResourceLocation ZOMBIE_VILLAGER_TEXTURES = new ResourceLocation("minecraft:textures/entity/zombie_villager/zombie_villager.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_FARMER_LOCATION = new ResourceLocation("minecraft:textures/entity/zombie_villager/zombie_farmer.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_LIBRARIAN_LOC = new ResourceLocation("minecraft:textures/entity/zombie_villager/zombie_librarian.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_PRIEST_LOCATION = new ResourceLocation("minecraft:textures/entity/zombie_villager/zombie_priest.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_SMITH_LOCATION = new ResourceLocation("minecraft:textures/entity/zombie_villager/zombie_smith.png");
    private static final ResourceLocation ZOMBIE_VILLAGER_BUTCHER_LOCATION = new ResourceLocation("minecraft:textures/entity/zombie_villager/zombie_butcher.png");

    public RenderDrownedVillager(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelMummyVillager(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMummyVillager entity) {
        if (true) return entity.getForgeProfession().getZombieSkin();

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
            rotationYaw += (float) (Math.cos((double) entityLiving.ticksExisted * 3.25D) * Math.PI * 0.25D);
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }
}
