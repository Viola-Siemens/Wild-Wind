package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.world.level.Level;
import org.polaris2023.wild_wind.common.entity.Firefly;

import static net.minecraft.world.level.GameRules.RULE_DAYLIGHT;
import static net.minecraft.world.level.GameRules.RULE_WEATHER_CYCLE;

public class Roost extends Fly {
    public Roost(Firefly Firefly) {
        super(Firefly);
    }

    @Override
    public boolean canUse() {
        Level level = firefly.level();
        if (!level.isClientSide
                && level.getGameRules().getBoolean(RULE_DAYLIGHT)
                && level.getGameRules().getBoolean(RULE_WEATHER_CYCLE)) {

        }
        return super.canUse();
    }
}
