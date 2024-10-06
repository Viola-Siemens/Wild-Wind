package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
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

    private void checkMovement() {
        Vec3 vec3 = firefly.getDeltaMovement();
        if (Math.abs(vec3.x) > 0.1 || Math.abs(vec3.z) > 0.1) {
            double d = Math.abs(firefly.xo - firefly.getX());
            if (d < 0.1)
                firefly.getNavigation().stop();
        }
    }

    @Override
    public boolean canUse() {
        if (firefly.isFlying()) {
            return true;
        }
        return super.canUse();
    }
}
