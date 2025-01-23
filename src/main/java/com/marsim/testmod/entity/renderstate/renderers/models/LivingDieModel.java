package com.marsim.testmod.entity.renderstate.renderers.models;

import com.marsim.testmod.TestMod;
import com.marsim.testmod.entity.renderstate.LivingDieRenderState;
import com.marsim.testmod.entity.renderstate.animations.LivingDieAnimations;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

	public class LivingDieModel extends EntityModel<LivingDieRenderState> {
		// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
		public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "textures/entity/dieentity.png"), "main");
		private final ModelPart hitbox;
		private final ModelPart die;
		private final ModelPart dietop;
		private final ModelPart diebottom;

		public LivingDieModel(ModelPart root) {
			super(root);
			this.hitbox = root.getChild("hitbox");
			this.die = root.getChild("die");
			this.dietop = this.die.getChild("dietop");
			this.diebottom = this.die.getChild("diebottom");
		}

		public static LayerDefinition createBodyLayer() {
			MeshDefinition meshdefinition = new MeshDefinition();
			PartDefinition partdefinition = meshdefinition.getRoot();

			PartDefinition hitbox = partdefinition.addOrReplaceChild("hitbox", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

			PartDefinition die = partdefinition.addOrReplaceChild("die", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));

			PartDefinition dietop = die.addOrReplaceChild("dietop", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

			PartDefinition cube_r1 = dietop.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.25F, -0.5F, -1.5708F, 0.0F, 1.5708F));

			PartDefinition cube_r2 = dietop.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.25F, -0.5F, -1.5708F, 0.0F, 1.5708F));

			PartDefinition cube_r3 = dietop.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -4.0F, -0.5F, -1.5708F, 0.0F, 1.5708F));

			PartDefinition cube_r4 = dietop.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(6, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -4.0F, -0.5F, -1.5708F, 0.0F, 1.5708F));

			PartDefinition cube_r5 = dietop.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(4, 18).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
					.texOffs(2, 18).addBox(-2.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
					.texOffs(0, 18).addBox(-4.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.5F, -0.5F, -1.5708F, 0.0F, 0.0F));

			PartDefinition cube_r6 = dietop.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

			PartDefinition diebottom = die.addOrReplaceChild("diebottom", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

			return LayerDefinition.create(meshdefinition, 32, 32);
		}
		@Override
		public void setupAnim(LivingDieRenderState state) {
			this.root().getAllParts().forEach(ModelPart::resetPose);

			this.animateWalk(LivingDieAnimations.MOVE, 0f, 1F, 4.0F, 1f);
			this.animate(state.attackAnimationState, LivingDieAnimations.ATTACK, state.ageInTicks, 1.0F);
		}

	}
