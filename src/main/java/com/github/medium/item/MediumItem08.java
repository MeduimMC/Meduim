package com.github.medium.item;

import com.github.medium.ItemMedium;
import com.github.medium.Medium;
import com.github.medium.events.CurioHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Medium.MODID)
public class MediumItem08 extends ItemMedium {
    public MediumItem08(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void EndEat(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (CurioHelper.findAnyItem(player, itemStack -> itemStack.getItem() instanceof MediumItem08) != null) {
                ItemStack stack = event.getResultStack();
                if(stack.getItem().getFoodProperties() != null){
                    player.getFoodData().eat(1,0);
                }
            }
        }

    }
}
