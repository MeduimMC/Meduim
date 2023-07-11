package com.github.medium.effect;

import com.github.medium.ModPotions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;

import javax.management.Attribute;

public class FlightEffect extends MobEffect {
    public FlightEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x00FF00);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity,int amplifier) {
        if(entity instanceof Player player){
            player.getAbilities().mayfly = (player.isCreative() || entity.isSpectator()) || entity.getEffect(ModPotions.FLIGHT_EFFECT.get()).getDuration() > 2;
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap map,int amplifier) {
        super.removeAttributeModifiers(entity, map, amplifier);
        if(entity instanceof Player player){
            boolean canFly = player.isCreative() || player.isSpectator();
            player.getAbilities().mayfly = canFly;
            player.getAbilities().flying = canFly;
            player.onUpdateAbilities();
        }
    }
}
