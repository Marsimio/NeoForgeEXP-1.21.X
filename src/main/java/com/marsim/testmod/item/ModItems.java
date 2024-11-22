package com.marsim.testmod.item;

import com.marsim.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> TESTMAT = ITEMS.registerItem(
            "testmat",
            Item::new,
            new Item.Properties()
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
