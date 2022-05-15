package com.dissonance.legendaryarmory.events;

import com.dissonance.legendaryarmory.setup.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class UseBlockEvents {
    public static ActionResult LodestoneConversion(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult){
        if(player.isSpectator()){
            return ActionResult.PASS;
        }

        if(hand.name().equals("OFF_HAND")){
            return ActionResult.PASS;
        }

        var block = world.getBlockState(hitResult.getBlockPos()).getBlock();
        var usedLodeStone = block.toString().contains("minecraft:lodestone");

        var heldItem = player.getStackInHand(hand);
        var holdingObsidianShard = heldItem.getItem().equals(ModItems.OBSIDIAN_SHARD);
        var amountHolding = heldItem.getCount();

        if(usedLodeStone && holdingObsidianShard && amountHolding >= 8){
            var stack = ModItems.ONYX_LODESTONE.getDefaultStack();
            player.giveItemStack(stack);
            player.getInventory().removeStack(player.getInventory().selectedSlot, 8);
        }

        return ActionResult.PASS;
    }
}
