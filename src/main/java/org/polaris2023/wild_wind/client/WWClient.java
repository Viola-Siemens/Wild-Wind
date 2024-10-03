package org.polaris2023.wild_wind.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;

import static org.polaris2023.wild_wind.WildWind.MODID;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class WWClient {
    @OnlyIn(Dist.CLIENT)
    public static void modConstruction(IEventBus bus) {
        // TODO: Add client-side mod construction code here
    }
}
