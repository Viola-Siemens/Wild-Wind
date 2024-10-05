package org.polaris2023.wild_wind.common.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import org.polaris2023.wild_wind.common.goals.firefly.Base;

public class Firefly extends AmbientCreature implements FlyingAnimal {

    public Firefly(EntityType<? extends AmbientCreature> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Base(this));

    }

    public static AttributeSupplier createAttributes() {
        return AmbientCreature.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8f)
                .add(Attributes.FLYING_SPEED, 0.6f)
                .build();
    }



    @Override
    public boolean isFlying() {
        return true;
    }
}
