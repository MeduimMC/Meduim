package com.github.medium.item;

import com.github.medium.ItemMedium;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;

public class MediumItem258 extends ItemMedium {
    public MediumItem258(Properties properties){
        super(properties);
    }


    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        if(slotContext.entity() instanceof Player){
            Player player = (Player) slotContext.entity();
            player.getAbilities().mayfly=true;
            player.getAbilities().flying=true;
            player.onUpdateAbilities();
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        if(slotContext.entity() instanceof Player){
            Player player = (Player) slotContext.entity();
            player.getAbilities().mayfly=false;
            player.getAbilities().flying=false;
            player.onUpdateAbilities();
        }
    }
    @Override
    public void appendHoverText(ItemStack p_41421, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424 )
    {
        p_41423_.add(Component.translatable("tooltip.medium_item258.desc"
        + " " + "tooltip.medium_item258_1.desc"
        + " " + "tooltip.medium_item258_2.desc"));
    }
}
