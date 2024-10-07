package org.polaris2023.wild_wind.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.polaris2023.wild_wind.common.registry.AllRegistry;
import org.polaris2023.wild_wind.common.registry.EntitiesRegistry;
import org.polaris2023.wild_wind.common.registry.ItemsRegistry;

import java.util.stream.Stream;

public class EntityTableSubProvider extends EntityLootSubProvider {
    public EntityTableSubProvider(HolderLookup.Provider registries) {
        super(FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return AllRegistry.entities.getEntries().stream().map(DeferredHolder::value);
    }

    @Override
    public void generate() {
        add(EntitiesRegistry.firefly.get(), LootTable
                .lootTable()
                .withPool(
                        LootPool
                                .lootPool()
                                .setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(ItemsRegistry.fluorescentPowder))));
    }
}
