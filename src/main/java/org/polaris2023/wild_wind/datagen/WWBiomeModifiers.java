package org.polaris2023.wild_wind.datagen;

import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.polaris2023.wild_wind.api.Const;

public class WWBiomeModifiers {
    public static final ResourceKey<BiomeModifier> fireflyModifier = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            Const.location("firefly_modifier")
    );
}
