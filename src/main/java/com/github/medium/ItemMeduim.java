package com.github.medium;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import javax.annotation.Nullable;

public class ItemMeduim extends Item implements ICurioItem {
    public ItemMeduim(Properties properties){
        super(properties.stacksTo(1).rarity(Rarity.RARE).fireResistant());
    }
    public boolean isEquippedBy(@Nullable LivingEntity entity){
        return entity != null && CuriosApi.getCuriosHelper().findFirstCurio(entity,this).isPresent();
    }
}
