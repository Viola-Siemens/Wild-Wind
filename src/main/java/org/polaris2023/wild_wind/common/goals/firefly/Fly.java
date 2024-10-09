package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.polaris2023.wild_wind.common.entity.Firefly;

import javax.annotation.Nullable;

public class Fly extends RandomStrollGoal {
    private final Firefly firefly;
    protected final float probability;
    public Fly(Firefly firefly, double speedModifier) {
        super(firefly, speedModifier);
        this.firefly = firefly;
        probability = 0.001F;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Nullable
    @Override
    protected Vec3 getPosition() {
        if (this.mob.isInWaterOrBubble() && this.mob.isInLava()) {
            Vec3 vec3 = LandRandomPos.getPos(this.mob, 15, 7);
            return vec3 == null ? super.getPosition() : vec3;
        } else {
            return this.mob.getRandom().nextFloat() >= this.probability ? LandRandomPos.getPos(this.mob, 10, 7) : super.getPosition();
        }
    }

    @Override
    public boolean canUse() {
        Level level = firefly.level();
        if (!level.isRaining() || level.getDayTime() < 13000) {
            firefly.setRoost(false);
        }
        return !firefly.isRoost() && !level.isRaining() && level.dayTime() < 13000;
    }


}
