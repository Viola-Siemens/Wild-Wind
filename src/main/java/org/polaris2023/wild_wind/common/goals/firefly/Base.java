package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.polaris2023.wild_wind.common.entity.Firefly;

public class Base extends Goal {
    public final  Firefly firefly;
    public Base(Firefly Firefly) {
        this.firefly = Firefly;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean canUse() {
        return false;
    }
}
