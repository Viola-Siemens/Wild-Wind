package org.polaris2023.wild_wind;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(WildWind.MODID)
public class WildWind {
	public static final String MODID = "wild_wind";
	public static final String MODNAME = "Wild Wind";
	public static final String VERSION = ModList.get().getModFileById(MODID).versionString();

	public RealPeacefulMode(IEventBus modBus, ModContainer modContainer) {
		WWContent.modConstruction(modBus);

		modContainer.registerConfig(ModConfig.Type.COMMON, WWCommonConfig.getConfig());

		modBus.addListener(this::setup);
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(WWContent::init);
	}
}
