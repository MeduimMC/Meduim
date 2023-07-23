package com.github.medium.item;

import com.github.medium.ItemMedium;
import com.github.medium.events.CurioHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

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
        @Override
    public void appendHoverText(ItemStack p_41421, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424 )
    {
        p_41423_.add(Component.translatable("tooltip.medium_item689.desc"
        + " " + "tooltip.medium_item689_1.desc"
        + " " + "tooltip.medium_item689_2.desc"));
    }
}
