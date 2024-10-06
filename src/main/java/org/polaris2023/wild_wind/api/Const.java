package org.polaris2023.wild_wind.api;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;


public class Const {
    public static final String MODID = "wild_wind";
    public static final String MODNAME = "Wild Wind";
    public static final String VERSION = ModList.get().getModFileById(MODID).versionString();

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
    public static <T> TagKey<T> tags(ResourceKey<Registry<T>> resourceKey, String name) {
        return TagKey.create(resourceKey, location(name));
    }
}
