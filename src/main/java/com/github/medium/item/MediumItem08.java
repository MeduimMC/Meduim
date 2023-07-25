package com.github.medium.item;

import java.util.List;

import com.github.medium.ItemMedium;
import com.github.medium.Medium;
import com.github.medium.events.CurioHelper;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

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
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level worldIn, List<Component> p_41423_, @NotNull TooltipFlag flagIn)
    {
        p_41423_.add(Component.translatable("tooltip.medium_item08.desc"));
        p_41423_.add(Component.translatable("tooltip.medium_item08_1.desc"));
        p_41423_.add(Component.translatable("tooltip.medium_item08_2.desc"));
    }

}
