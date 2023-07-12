package com.github.medium.item;

import com.github.medium.ItemMedium;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class MediumItem666 extends ItemMedium {
    public MediumItem666(Properties properties) {
        super(properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
//        Attribute armor = ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation())
        attributeModifiers.put(ForgeMod.SWIM_SPEED.get(), new AttributeModifier("Armor modifier", 0.5, AttributeModifier.Operation.ADDITION));
        return attributeModifiers;
    }

}
