package com.marsim.testmod.entity.renderstate;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LivingDieRenderState extends LivingEntityRenderState {

    public final AnimationState moveAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
}
