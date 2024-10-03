package org.polaris2023.wild_wind.common;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.polaris2023.wild_wind.common.registry.AllRegistry;
import org.polaris2023.wild_wind.common.registry.ItemsRegistry;

import static org.polaris2023.wild_wind.WildWind.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class WWContent {
	public static void modConstruction(IEventBus bus) {
		AllRegistry.register(bus);
	}

	public static void init() {
		ModVanillaCompat.init();
	}

	@SubscribeEvent
	public static void buildGroup(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ItemsRegistry.glowGoop);
		}
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			event.accept(ItemsRegistry.fireflyEgg);
		}
	}
}
