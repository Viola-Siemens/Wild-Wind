package org.polaris2023.wild_wind.common.goals.firefly;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import org.polaris2023.wild_wind.common.entity.Firefly;
import org.polaris2023.wild_wind.common.registry.TagRegister;

import static net.minecraft.world.level.GameRules.RULE_DAYLIGHT;
import static net.minecraft.world.level.GameRules.RULE_WEATHER_CYCLE;

public class Roost extends MoveToBlockGoal {
    private final Firefly firefly;
    public Roost(Firefly firefly, double speedModifier) {
        super(firefly, speedModifier, 22);
        this.firefly = firefly;
    }

    @Override
    public boolean canUse() {
        if (firefly.isRoost()) return false;// roost is false
        Level level = firefly.level();
        if (!level.isRaining()) return false;// no rain is false
        if (level.dimensionType().hasFixedTime()) return false;// time is fix time is false
        if (level.dayTime() < 13000) return false;// no night is false
        return super.canUse();
    }

    /**
     * Return {@code true} to set given position as destination
     *
     * @param level
     * @param pos
     */
    @Override
    protected boolean isValidTarget(LevelReader level, BlockPos pos) {
        if (level.getBlockState(pos).is(TagRegister.BlockTags.firefly_roost_block.get())) {

            return true;
        }
        return false;
    }

    @Override
    public void start() {
        super.start();
        firefly.setRoost(true);
    }
}
