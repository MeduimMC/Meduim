package com.github.medium;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Medium.MODID)
public class Medium {

    public static final String MODID = "medium";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Medium() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MediumTabs.TAB_REGISER.register(modEventBus);
        BlocksAndItems.BLOCK.register(modEventBus);
        BlocksAndItems.ITEM.register(modEventBus);
        BlocksAndItems.BLOCK_ENTITIES.register(modEventBus);
        ModPotions.EFFECTS.register(modEventBus);
        ModPotions.POTIONS.register(modEventBus);
 //       modEventBus.addListener(DAtaGenerator::generate);
        // Register the Deferred Register to the mod event bus so tabs get registered

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

}
