package org.polaris2023.wild_wind.common.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;

import static org.polaris2023.wild_wind.common.registry.AllRegistry.items;

public class ItemsRegistry {
    public static final DeferredItem<DeferredSpawnEggItem> fireflySpawnEgg = items.registerItem("firefly_spawn_egg", properties ->
            new DeferredSpawnEggItem(EntitiesRegistry.firefly, 0x000000, 0x000000, properties));

    public static final DeferredItem<Item> glowGoop = items.registerItem("glow_goop", Item::new);
    public static final DeferredItem<Item> fluorescentPowder = items.registerItem("fluorescent_powder", Item::new);
    public static final DeferredItem<Item> fluorescentMucus = items.registerItem("fluorescent_mucus", Item::new);

    public static void register() {

    }
}
