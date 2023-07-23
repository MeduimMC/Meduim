package com.github.medium.item;


import com.github.medium.ItemMedium;
import com.github.medium.Medium;
import com.github.medium.events.CurioHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
@Mod.EventBusSubscriber(modid = Medium.MODID)
public class MediumItem480 extends ItemMedium {
    public MediumItem480(Properties properties) {
        super(properties);
    }

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() != null) {
            Player player = event.getPlayer();
            if (CurioHelper.findAnyItem(player, itemStack -> itemStack.getItem() instanceof MediumItem480) != null) {
                BlockState blocks = event.getState();
                Block block = blocks.getBlock();
                if (block == Blocks.GRASS || blocks.is(BlockTags.BASE_STONE_OVERWORLD) || block == Blocks.COAL_ORE) {
                    Random r = new Random();
                    if (block == Blocks.GRASS && r.nextFloat() < 0.05f) {
                        if (r.nextFloat() > 0.5f) player.addItem(new ItemStack(Items.IRON_INGOT));
                        else player.addItem(new ItemStack(Items.EMERALD));
                    }
                    if (blocks.is(BlockTags.BASE_STONE_OVERWORLD) && r.nextFloat() < 0.25f) {
                        player.addItem(new ItemStack(Items.COAL));
                    }
                    if (block == Blocks.COAL_ORE && r.nextFloat() < 0.01f) {
                        player.addItem(new ItemStack(Items.DIAMOND));
                    }
                }
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack p_41421, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424 )
    {
        p_41423_.add(Component.translatable("tooltip.medium_item480.desc"
        + " " + "tooltip.medium_item480_1.desc"
        + " " + "tooltip.medium_item480_2.desc"));
    }
}
