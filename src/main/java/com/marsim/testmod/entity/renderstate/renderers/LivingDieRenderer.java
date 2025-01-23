package com.marsim.testmod.entity.renderstate.renderers;

import com.marsim.testmod.TestMod;
import com.marsim.testmod.entity.renderstate.LivingDieRenderState;
import com.marsim.testmod.entity.renderstate.renderers.models.LivingDieModel;
import com.marsim.testmod.entity.custom.DieEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.BatModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@OnlyIn(Dist.CLIENT)
public class LivingDieRenderer extends MobRenderer<DieEntity, LivingDieRenderState, LivingDieModel> {

    private static final ResourceLocation DIE_LOCATION = ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "textures/entity/dieentity.png");

    public LivingDieRenderer(EntityRendererProvider.Context context) {
        super(context, new LivingDieModel(context.bakeLayer(LivingDieModel.LAYER_LOCATION)), 0.5F);
    }

    public LivingDieRenderState createRenderState() {
        return new LivingDieRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(LivingDieRenderState p_368654_) {
        return DIE_LOCATION;
    }

    public void extractRenderState(DieEntity entity, LivingDieRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.moveAnimationState.copyFrom(entity.moveAnimationState);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);

    }
}