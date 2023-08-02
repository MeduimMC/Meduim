package com.github.medium;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MediumTabs{
    public static final DeferredRegister<CreativeModeTab> TAB_REGISER = DeferredRegister
            .create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Medium.MODID);
    public static final RegistryObject<CreativeModeTab> ICON_TAB = TAB_REGISER.register(
            Medium.MODID, () ->
//                    CreativeModeTab.builder().icon(MMItems.ICON.get()::getDefaultInstance).build());
                    CreativeModeTab.builder().icon(() -> new ItemStack(BlocksAndItems.Medium08.get())).title(Component.translatable(Medium.MODID)).withTabsBefore(CreativeModeTabs.SPAWN_EGGS).build());
}
