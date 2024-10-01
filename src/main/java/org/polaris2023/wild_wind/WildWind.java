package org.polaris2023.wild_wind;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.polaris2023.wild_wind.client.WWClient;
import org.polaris2023.wild_wind.common.WWContent;

@Mod(WildWind.MODID)
public class WildWind {
	public static final String MODID = "wild_wind";
	public static final String MODNAME = "Wild Wind";
	public static final String VERSION = ModList.get().getModFileById(MODID).versionString();

	public WildWind(IEventBus modBus, ModContainer modContainer) {
		WWContent.modConstruction(modBus);
		WWClient.modConstruction(modBus);
		modBus.addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	public static ResourceLocation location(String path) {
		return ResourceLocation.fromNamespaceAndPath(MODID, path);
	}


}
