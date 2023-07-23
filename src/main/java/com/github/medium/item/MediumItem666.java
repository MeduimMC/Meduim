package com.github.medium.item;

import com.github.medium.ItemMedium;
import com.google.common.collect.Multimap;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import net.minecraft.network.chat.Component;

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

    @Override
    public void appendHoverText(ItemStack p_41421, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424) {
        p_41423_.add(Component.translatable("tooltip.medium_item666.desc"));
        p_41423_.add(Component.translatable("tooltip.medium_item666_1.desc"));
        p_41423_.add(Component.translatable("tooltip.medium_item666_2.desc"));
    }

}
