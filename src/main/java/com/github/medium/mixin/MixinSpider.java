package com.github.medium.mixin;

import com.github.medium.BlocksAndItems;
import com.github.medium.events.CurioHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Spider.class)
public abstract class MixinSpider extends Monster {
    protected MixinSpider(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

//    @Shadow
//    GoalSelector goalSelector;


    /**
     * @author
     * @reason
     */
    @Inject(method = "registerGoals", at = @At("HEAD"),remap = false)
    protected void registerGoals(CallbackInfo ci) {
        goalSelector.addGoal(1, new AvoidEntityGoal<Player>(this, Player.class, 6.0F, 1.0D, 1.2D,
                        livingEntity -> CurioHelper
                                .findAnyItem(
                                        livingEntity,
                                        item -> item.is(BlocksAndItems.Medium35.get()))
                                != null
                )
        );
//        Medium.LOGGER.info("creeper mixined!");
    }
}
