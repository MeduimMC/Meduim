package com.github.medium.mixin;

import com.github.medium.BlocksAndItems;
import com.github.medium.Medium;
import com.github.medium.events.CurioHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Creeper.class)
public abstract class MixinCreeper extends Monster {
    protected MixinCreeper(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }

//    @Shadow
//    GoalSelector goalSelector;


    /**
     * @author
     * @reason
     */
    @Inject(method = "registerGoals", at = @At("HEAD"))
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
