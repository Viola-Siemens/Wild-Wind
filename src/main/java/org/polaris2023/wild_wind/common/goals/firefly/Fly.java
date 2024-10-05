package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.Util;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;
import org.polaris2023.wild_wind.common.entity.Firefly;

public class Fly extends Base {
    public Fly(Firefly Firefly) {
        super(Firefly);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean canUse() {
        if (firefly.isFlying()) {
            return true;
        }
        return super.canUse();
    }
}
