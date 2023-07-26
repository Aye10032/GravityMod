package com.aye10032.gravitymod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WeightlessEffect extends MobEffect {

    public WeightlessEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public WeightlessEffect(){
        super(MobEffectCategory.BENEFICIAL, 3124687);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
