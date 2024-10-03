package org.polaris2023.wild_wind.common.registry;

import com.mojang.datafixers.DSL;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.polaris2023.wild_wind.common.entity.Firefly;

import static org.polaris2023.wild_wind.common.registry.AllRegistry.entities;

public class EntitiesRegistry {
    public static final DeferredHolder<EntityType<?>, EntityType<Firefly>> firefly =
            entities.register("firefly", () -> EntityType.Builder.of(Firefly::new, MobCategory.AMBIENT).build("firefly"));
    public static void register() {

    }
}
