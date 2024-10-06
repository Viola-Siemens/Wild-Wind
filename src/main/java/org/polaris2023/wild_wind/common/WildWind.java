package org.polaris2023.wild_wind.common;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import org.polaris2023.wild_wind.common.entity.Firefly;
import org.polaris2023.wild_wind.common.registry.AllRegistry;
import org.polaris2023.wild_wind.common.registry.EntitiesRegistry;
import org.polaris2023.wild_wind.common.registry.ItemsRegistry;

import static org.polaris2023.wild_wind.api.Const.MODID;

@Mod(value = MODID)
public class WildWind {

	public WildWind(IEventBus modBus, ModContainer modContainer) {
		AllRegistry.register(modBus);
		modBus.addListener(this::setup);
		modBus.addListener(WildWind::buildGroup);
		modBus.addListener(EntityAttributeCreationEvent.class, event -> {
			event.put(EntitiesRegistry.firefly.get(), Firefly.createAttributes());
		});
	}


	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(WildWind::init);
	}

	public static void init() {
		ModVanillaCompat.init();
	}

	public static void buildGroup(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ItemsRegistry.glowGoop);
		}
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			event.accept(ItemsRegistry.fireflyEgg);
		}
		if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			event.accept(ItemsRegistry.fireflyEgg);
		}
	}
}
