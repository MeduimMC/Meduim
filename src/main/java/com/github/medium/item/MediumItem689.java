package com.github.medium.item;

import com.github.medium.ItemMedium;
import com.github.medium.events.CurioHelper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MediumItem689 extends ItemMedium {
    public MediumItem689(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        if (event.getEntity() != null) {
            if (event.getEntity() instanceof Player) {
                Player player = (Player) event.getEntity();
                if (CurioHelper.findAnyItem(player, itemStack -> itemStack.getItem() instanceof MediumItem689) != null) {
                    if(event.getSource().is(DamageTypes.ON_FIRE)||event.getSource().is(DamageTypes.IN_FIRE)|| event.getSource().is(DamageTypes.LAVA)) event.setCanceled(true);
                }
            }
        }
    }
}
