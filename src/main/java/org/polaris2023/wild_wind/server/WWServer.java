package org.polaris2023.wild_wind.server;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.polaris2023.annotation.AutoInfo;

import static org.polaris2023.wild_wind.api.Const.MODID;

@Mod(value = MODID, dist = Dist.DEDICATED_SERVER)
@AutoInfo
public class WWServer {
    public WWServer(IEventBus modBus, ModContainer modContainer) {
        modConstruction(modBus);

    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void modConstruction(IEventBus bus) {
        // TODO: Add client-side mod construction code here

    }
}
