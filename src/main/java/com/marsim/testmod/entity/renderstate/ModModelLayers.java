package com.marsim.testmod.entity.renderstate;

import com.marsim.testmod.TestMod;
import com.marsim.testmod.entity.ModEntities;
import com.marsim.testmod.entity.renderstate.renderers.LivingDieRenderer;
import com.marsim.testmod.entity.renderstate.renderers.models.LivingDieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod(value = TestMod.MODID, dist = Dist.CLIENT)
public class ModModelLayers {

    public ModModelLayers(IEventBus modBus) {
        modBus.addListener(this::registerLayerDefinitions);
        modBus.addListener(this::registerEntityRenderers);
    }

    public void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LivingDieModel.LAYER_LOCATION, LivingDieModel::createBodyLayer);
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.LIVING_DIE.get(),LivingDieRenderer::new);
    }
}
