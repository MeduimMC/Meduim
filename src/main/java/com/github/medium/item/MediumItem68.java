package com.github.medium.item;

import com.github.medium.ItemMeduim;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class MediumItem68 extends ItemMeduim {
    public MediumItem68(Properties properties) {
        super(properties);
    }

    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack){
        if(livingEntity instanceof Player){
            List<MobEffectInstance> effects = Lists.newArrayList(livingEntity.getActiveEffects());
            for(MobEffectInstance effect : Collections2.filter(effects,buff -> buff.getEffect() == MobEffects.POISON || buff.getEffect() == MobEffects.CONFUSION)){
                livingEntity.removeEffect(effect.getEffect());
            }
        }
    }
}