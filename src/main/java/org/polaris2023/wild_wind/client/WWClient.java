package org.polaris2023.wild_wind.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.polaris2023.annotation.AutoInfo;
import org.polaris2023.wild_wind.client.renderer.entity.FireflyRenderer;
import org.polaris2023.wild_wind.common.registry.EntitiesRegistry;

import static org.polaris2023.wild_wind.api.Const.MODID;

@Mod(value = MODID, dist = Dist.CLIENT)
@AutoInfo
public class WWClient {

    public WWClient(IEventBus modBus, ModContainer modContainer) {
        modBus.addListener(WWClient::renderRegister);

    }

    public static void renderRegister(EntityRenderersEvent.RegisterRenderers event)  {
        event.registerEntityRenderer(EntitiesRegistry.firefly.get(), FireflyRenderer::new);
    }

}
