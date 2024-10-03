package org.polaris2023.wild_wind.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.Level;

public class Firefly extends AmbientCreature {

    public Firefly(EntityType<? extends AmbientCreature> type, Level level) {
        super(type, level);
    }
}
