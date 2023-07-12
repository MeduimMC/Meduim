package com.github.medium.mixin;

import com.github.medium.events.CurioHelper;
import com.github.medium.item.MediumItem666;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.world.item.enchantment.EnchantmentHelper.getEnchantmentLevel;

@Mixin(EnchantmentHelper.class)
public abstract class MixinEnchantmentHelper {
    @Inject(method = "getRespiration", at = @At("HEAD"), remap = true, cancellable = true)
    private static void getRespiration(LivingEntity p_44919_, CallbackInfoReturnable<Integer> cir) {
        if(CurioHelper.findAnyItem(p_44919_, itemStack -> itemStack.getItem() instanceof MediumItem666) != null) {
            int i = getEnchantmentLevel(Enchantments.RESPIRATION, p_44919_) + 1;
            cir.setReturnValue(i);
        }
    }
}
