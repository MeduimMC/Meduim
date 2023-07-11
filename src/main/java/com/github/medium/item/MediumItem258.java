package com.github.medium.item;

import com.github.medium.ItemMedium;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

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
}
