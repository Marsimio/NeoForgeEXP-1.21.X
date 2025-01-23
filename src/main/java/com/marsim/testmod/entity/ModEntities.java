package com.marsim.testmod.entity;

import com.marsim.testmod.TestMod;
import com.marsim.testmod.entity.custom.DieEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, TestMod.MODID);

    public static final Supplier<EntityType<DieEntity>> LIVING_DIE =
            ENTITIES.register("livingdie", () -> EntityType.Builder.of(DieEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build(ResourceKey.create(ENTITIES.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "livingdie"))));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}