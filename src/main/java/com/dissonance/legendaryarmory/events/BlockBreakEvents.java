package com.dissonance.legendaryarmory.events;

import com.dissonance.legendaryarmory.setup.ModEnchantments;
import com.dissonance.legendaryarmory.setup.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBreakEvents {
    public static boolean replaceObsidianDrop(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity){
        if(player.isSpectator() && player.isCreative()){
            return true;
        }

        var block = state.getBlock();
        if(!block.equals(Blocks.OBSIDIAN)){
            return true;
        }

        var itemStackInHand = player.getInventory().getMainHandStack();
        var carvingEnchantmentLevel = EnchantmentHelper.getLevel(ModEnchantments.CARVING, itemStackInHand);

        if(carvingEnchantmentLevel == 0){
            return true;
        }

        var dropAmount = 1;
        var itemInHand = (ToolItem)itemStackInHand.getItem();
        if(itemInHand.isSuitableFor(state)){
            var rng = new Random();
            var fortuneEnchantmentLevel = EnchantmentHelper.getLevel(Enchantments.FORTUNE, itemStackInHand);
            switch (fortuneEnchantmentLevel) {
                case 0 -> dropAmount = rng.nextInt(3, 5);
                case 1 -> dropAmount = rng.nextInt(3) < 2 ? 4 : 4 * 2;
                case 2 -> {
                    var chance = rng.nextInt(4);
                    dropAmount = chance < 2 ? 4 : chance < 3 ? 4 * 2 : 4 * 3;
                }
                case 3 -> {
                    var chance = rng.nextInt(5);
                    dropAmount = chance < 2 ? 4 : chance < 3 ? 4 * 2 : chance < 4 ? 4 * 3 : 4 * 4;
                }
            }
        }

        world.removeBlock(pos, true);

        var stack = new ItemStack(ModItems.OBSIDIAN_SHARD, dropAmount);
        var itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
        world.spawnEntity(itemEntity);

        return false;
    }
}
