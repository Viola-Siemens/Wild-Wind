package org.polaris2023.wild_wind.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.polaris2023.wild_wind.WildWind.MODID;

public class AllRegistry {
    public static final DeferredRegister.Items items = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<EntityType<?>> entities = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);
    public static final DeferredRegister.Blocks blocks = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister<BlockEntityType<?>> tiles = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static void register(IEventBus modEventBus) {
        BlocksRegistry.register();
        EntitiesRegistry.register();
        ItemsRegistry.register();
        entities.register(modEventBus);
        blocks.register(modEventBus);
        tiles.register(modEventBus);
        items.register(modEventBus);
    }
}
