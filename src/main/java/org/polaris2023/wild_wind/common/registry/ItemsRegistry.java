package org.polaris2023.wild_wind.common.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;

import static org.polaris2023.wild_wind.common.registry.AllRegistry.items;

public class ItemsRegistry {
    public static final DeferredItem<DeferredSpawnEggItem> fireflyEgg = items.registerItem("firefly_egg", properties ->
            new DeferredSpawnEggItem(EntitiesRegistry.firefly, 0x000000, 0x000000, properties));

    public static final DeferredItem<Item> glowGoop = items.registerItem("glow_goop", Item::new);

    public static void register() {

    }
}
