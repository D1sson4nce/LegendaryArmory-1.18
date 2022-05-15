package com.dissonance.legendaryarmory.mixin;

import com.dissonance.legendaryarmory.setup.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerListener {
    @Shadow @Final
    private PlayerInventory inventory;

    @Inject(method = "addExperienceLevels", at = @At("HEAD"))
    protected void injectLevelMethod(int levels, CallbackInfo info){
        var spiritShards = new ItemStack(ModItems.SPIRIT_SHARD, levels);
        inventory.insertStack(spiritShards);
    }
}


