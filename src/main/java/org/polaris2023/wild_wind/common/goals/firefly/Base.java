package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.polaris2023.wild_wind.common.entity.Firefly;

public class Base extends Goal {
    public final  Firefly firefly;
    protected final PathNavigation pathNavigation;
    public Base(Firefly Firefly) {
        this.firefly = Firefly;
        pathNavigation = firefly.getNavigation();
    }

    @Override
    public void tick() {
        Level level = firefly.level();

        if (firefly.isRoost()) {
            firefly.idle.stop();
            if (!level.isRaining() || level.getDayTime() < 13000) {
                firefly.setRoost(false);
            }
        } else {
            firefly.idle.startIfStopped(firefly.tickCount);
        }
    }

    @Override
    public boolean canUse() {
        return true;
    }
}
