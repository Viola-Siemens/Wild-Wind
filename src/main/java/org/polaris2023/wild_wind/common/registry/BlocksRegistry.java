package org.polaris2023.wild_wind.common.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlocksRegistry {

    public static class ItemsRegistry {
        public static void register() {}
    }

    public static class TileEntitiesRegistry {
        public static void register() {}
    }

    public static void register() {
        ItemsRegistry.register();
        TileEntitiesRegistry.register();
    }

    public static Item getBlockItem(Block block) {
        return block.asItem();
    }
}
