package org.polaris2023.wild_wind.api;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
import org.polaris2023.annotation.AutoInfo;

@AutoInfo
public class Const {
    public static final String MODID = "wild_wind";
    public static final String MODNAME = "Wild Wind";
    public static final String VERSION = ModList.get().getModFileById(MODID).versionString();

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
