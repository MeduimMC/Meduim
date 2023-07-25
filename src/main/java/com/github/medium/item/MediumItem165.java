package com.github.medium.item;

import com.github.medium.ItemMedium;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class MediumItem165 extends ItemMedium {
    public MediumItem165(Properties properties){
        super(properties);
    }

    public void curioTick(String identifier, int index, LivingEntity livingEntity, ItemStack stack){
        if(livingEntity instanceof Player){
            List<MobEffectInstance> effects = Lists.newArrayList(livingEntity.getActiveEffects());
            for(MobEffectInstance effect : Collections2.filter(effects, buff -> buff.getEffect() == MobEffects.BLINDNESS || buff.getEffect() == MobEffects.DARKNESS)){
                livingEntity.removeEffect(effect.getEffect());
            }
            if(livingEntity.level().isDay()){
                livingEntity.setSecondsOnFire(1);
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack p_41421, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424 )
    {
        p_41423_.add(Component.translatable("tooltip.medium_item165.desc"));
        p_41423_.add(Component.translatable("tooltip.medium_item165_1.desc"));
        p_41423_.add(Component.translatable("tooltip.medium_item165_2.desc"));
    }
}
