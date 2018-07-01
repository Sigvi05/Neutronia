package net.hdt.neutronia.entity.render;

import net.hdt.neutronia.entity.EntityDrownedScubaVillager;
import net.hdt.neutronia.entity.render.model.ModelDrownedScubaVillager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.hdt.neutronia.util.Reference.MOD_ID;

@SideOnly(Side.CLIENT)
public class RenderDrownedScubaVillager extends RenderLivingBase<EntityDrownedScubaVillager> {

    private static final ResourceLocation MUMMY_TEXTURE = new ResourceLocation(MOD_ID, "textures/entity/villagers/professions/drowned_scuba_diver.png");

    public RenderDrownedScubaVillager(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDrownedScubaVillager(), 0.5F);
    }

    @Override
    public ModelBase getMainModel() {
        return super.getMainModel();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDrownedScubaVillager entity) {
        return MUMMY_TEXTURE;
    }

}
