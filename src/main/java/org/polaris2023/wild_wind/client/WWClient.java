package org.polaris2023.wild_wind.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.polaris2023.wild_wind.client.model.entity.FireflyModel;
import org.polaris2023.wild_wind.client.renderer.entity.FireflyRenderer;
import org.polaris2023.wild_wind.common.registry.EntitiesRegistry;

import static org.polaris2023.wild_wind.api.Const.MODID;

@Mod(value = MODID, dist = Dist.CLIENT)
public class WWClient {

    public WWClient(IEventBus modBus, ModContainer modContainer) {
        modBus(modBus);
        forgeBus(NeoForge.EVENT_BUS);
    }

    public void modBus(IEventBus modBus) {
        modBus.addListener(EntityRenderersEvent.RegisterRenderers.class, event -> {
            event.registerEntityRenderer(EntitiesRegistry.firefly.get(), FireflyRenderer::new);
        });
        modBus.addListener(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            event.registerLayerDefinition(FireflyModel.LOCATION, FireflyModel::createBodyLayer);
        });
    }

    public void forgeBus(IEventBus forgeBus) {

    }


}
