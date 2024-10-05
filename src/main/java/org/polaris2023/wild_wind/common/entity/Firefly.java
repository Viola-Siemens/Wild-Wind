package org.polaris2023.wild_wind.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import org.polaris2023.wild_wind.common.goals.firefly.Base;
import org.polaris2023.wild_wind.common.goals.firefly.Fly;
import org.polaris2023.wild_wind.common.goals.firefly.Roost;

public class Firefly extends AmbientCreature implements FlyingAnimal {
    public boolean isRoost;
    public Firefly(EntityType<? extends AmbientCreature> type, Level level) {
        super(type, level);
        this.moveControl = new FlyingMoveControl(this, 10, false);
    }

    public void setRoost(boolean roost) {
        isRoost = roost;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        isRoost = compound.getBoolean("roost");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("roost", isRoost);
    }

    @Override
    public void tick() {
        super.tick();

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new Base(this));
        this.goalSelector.addGoal(1, new Roost(this));
        this.goalSelector.addGoal(2, new Fly(this));

    }



    public static AttributeSupplier createAttributes() {
        return AmbientCreature.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8f)
                .add(Attributes.FLYING_SPEED, 0.6f)
                .build();
    }



    @Override
    public boolean isFlying() {
        return !onGround();
    }
}
