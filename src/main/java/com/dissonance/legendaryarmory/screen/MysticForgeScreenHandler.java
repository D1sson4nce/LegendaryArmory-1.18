package com.dissonance.legendaryarmory.screen;

import com.dissonance.legendaryarmory.screen.slot.ResultSlot;
import com.dissonance.legendaryarmory.setup.ScreenHandlers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class MysticForgeScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate delegate;

    public MysticForgeScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(5), new ArrayPropertyDelegate(2));
    }

    public MysticForgeScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ScreenHandlers.MYSTIC_FORGE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 5);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.delegate = delegate;

        addSlot(new Slot(inventory, 0, 26, 61));
        addSlot(new Slot(inventory, 1, 62, 61));
        addSlot(new Slot(inventory, 2, 98, 61));
        addSlot(new Slot(inventory, 3, 134, 61));
        addSlot(new ResultSlot(inventory, 4, 81, 8));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    public boolean isCrafting(){
        return delegate.get(0) > 0;
    }

    public int getScaledProgress(){
        int progress = delegate.get(0);
        int maxProgress = delegate.get(1);
        int progressArrowSize = 30;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        var newStack = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if(slot.hasStack()){
            var originalStack = slot.getStack();
            newStack = originalStack.copy();
            if(index < inventory.size()){
                if(!insertItem(originalStack, inventory.size(), slots.size(), true)){
                    return ItemStack.EMPTY;
                }
            }else if(!insertItem(originalStack, 0, inventory.size(), false)){
                return ItemStack.EMPTY;
            }

            if(originalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            }else{
                slot.markDirty();
            }
        }
        
        return newStack;
    }
    
    private void addPlayerInventory(PlayerInventory playerInventory){
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 9; j++) {
                addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 86 + i * 18));
            }
        }
    }

    private void  addPlayerHotbar(PlayerInventory playerInventory){
        for (var i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));

        }
    }
}
