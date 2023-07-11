package com.github.medium.events;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.tuple.Triple;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.ISlotType;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;
import top.theillusivec4.curios.api.type.util.ISlotHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class CurioHelper {
    @Nullable
    public static Triple<String, Integer, ItemStack> findAnyItem(LivingEntity entity, Predicate<ItemStack> stackPredicate) {
        AtomicReference<Triple<String, Integer, ItemStack>> stack = new AtomicReference<>(null);
        CuriosApi.getCuriosHelper().getCuriosHandler(entity).ifPresent(iCuriosItemHandler -> {
            for (Map.Entry<String, ICurioStacksHandler> stringICurioStacksHandlerEntry : iCuriosItemHandler.getCurios().entrySet()) {
                IDynamicStackHandler stacks = stringICurioStacksHandlerEntry.getValue().getStacks();
                for (int i = 0; i < stacks.getSlots(); i++) {
                    ItemStack stackInSlot = stacks.getStackInSlot(i);
                    if (stackPredicate.test(stackInSlot)) {
                        stack.set(Triple.of(stringICurioStacksHandlerEntry.getKey(), i, stackInSlot));
                        return;
                    }
                }
            }
        });

        return stack.get();

    }

}
