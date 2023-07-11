package com.github.medium.events;

import com.github.medium.Medium;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CurioHandler {
//    public static final String SLOT_RING =

    @SubscribeEvent
    public static void onRegistryCurios(InterModEnqueueEvent event) {
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.HEAD.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.CURIO.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.BELT.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.BODY.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.BRACELET.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.CHARM.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.HANDS.getMessageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.NECKLACE.getMeuilder().size(2)::build);
////        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.BACK.getMessageBssageBuilder().size(2)::build);
//        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, SlotTypePreset.RING.getMessageBuilder().size(2)::build);
        for (SlotTypePreset value : SlotTypePreset.values()) {
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, value.getMessageBuilder().size(2)::build);
        }
    }


}
