package com.dissonance.legendaryarmory.mixin;

import com.dissonance.legendaryarmory.setup.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
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
        if(levels > 0){
            var spiritShards = ModItems.SPIRIT_SHARD.getDefaultStack();
            inventory.insertStack(spiritShards);
        }
    }
}


