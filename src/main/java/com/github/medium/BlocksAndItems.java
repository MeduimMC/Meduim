package com.github.medium;

import com.github.medium.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlocksAndItems {
    public static final DeferredRegister<net.minecraft.world.level.block.Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS.getRegistryName(), Medium.MODID);
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS.getRegistryName(), Medium.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Medium.MODID);

    public static final RegistryObject<Item> Medium68 = ITEM.register("medium68", () -> new MediumItem68(new Item.Properties()));
    public static final RegistryObject<Item> Medium480 = ITEM.register("medium480", () -> new MediumItem480(new Item.Properties()));
    public static final RegistryObject<Item> Medium08 = ITEM.register("medium08", () -> new MediumItem08(new Item.Properties()));
    public static final RegistryObject<Item> Medium35 = ITEM.register("medium35", () -> new MediumItem35(new Item.Properties()));
    public static final RegistryObject<Item> Medium258 = ITEM.register("medium258", () -> new MediumItem258(new Item.Properties()));
    public static final RegistryObject<Item> Medium165 = ITEM.register("medium165", () -> new MediumItem165(new Item.Properties()));
}
