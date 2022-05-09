package com.dissonance.legendaryarmory.blocks.entities;

import com.dissonance.legendaryarmory.inventroy.ImplementedInventory;
import com.dissonance.legendaryarmory.recipes.MysticForgeRecipe;
import com.dissonance.legendaryarmory.screen.MysticForgeScreenHandler;
import com.dissonance.legendaryarmory.setup.Entities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MysticForgeEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public static final int inventorySize = 5;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 16;

    public MysticForgeEntity(BlockPos pos, BlockState state) {
        super(Entities.MYSTIC_FORGE_ENTITY, pos, state);
        propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MysticForgeEntity.this.progress;
                    case 1 -> MysticForgeEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> MysticForgeEntity.this.progress = value;
                    case 1 -> MysticForgeEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new MysticForgeScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("forge.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("forge.progress");
    }

    public static void tick(World world, BlockPos pos, BlockState state, MysticForgeEntity entity){
        if(hasRecipe(entity)){
            entity.progress++;
            if(entity.progress > entity.maxProgress){
                craftItem(entity);
            }
        }else{
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(MysticForgeEntity entity){
        var world = entity.world;
        var inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        var match = world.getRecipeManager().getFirstMatch(MysticForgeRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private void resetProgress(){
        progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output){
        return inventory.getStack(4).getItem() == output.getItem() || inventory.getStack(4).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory){
        return inventory.getStack(4).getMaxCount() > inventory.getStack(4).getCount();
    }

    private static void craftItem(MysticForgeEntity entity){
        var world = entity.world;
        var inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        var match = world.getRecipeManager().getFirstMatch(MysticForgeRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()){
            var foundSlots = DefaultedList.ofSize(4, false);
            smartMatchRemoveStacks(inventory, 0, foundSlots, match.get().getInputs());

            var rng = new Random();
            var chance = rng.nextFloat(100);
            var adds = chance < match.get().getSuccessRate() ? 1 : 0;
            System.out.println(chance + " < " + match.get().getSuccessRate());

            entity.setStack(4, new ItemStack(match.get().getOutput().getItem(), entity.getStack(4).getCount() + adds));

            entity.resetProgress();
        }
    }

    private static void smartMatchRemoveStacks(SimpleInventory inventory, int inputIndex, DefaultedList<Boolean> foundSlots, DefaultedList<MysticForgeRecipe.Input> inputs){
        if(inputIndex >= inputs.size()){
            return;
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(0)) && inventory.getStack(0).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(0)){
            foundSlots.set(0, true);
            inventory.removeStack(0, inputs.get(inputIndex).getCount());
            smartMatchRemoveStacks(inventory, ++inputIndex, foundSlots, inputs);
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(1)) && inventory.getStack(1).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(1)){
            foundSlots.set(1, true);
            inventory.removeStack(1, inputs.get(inputIndex).getCount());
            smartMatchRemoveStacks(inventory, ++inputIndex, foundSlots, inputs);
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(2)) && inventory.getStack(2).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(2)){
            foundSlots.set(2, true);
            inventory.removeStack(2, inputs.get(inputIndex).getCount());
            smartMatchRemoveStacks(inventory, ++inputIndex, foundSlots, inputs);
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(3)) && inventory.getStack(3).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(3)){
            foundSlots.set(3, true);
            inventory.removeStack(3, inputs.get(inputIndex).getCount());
            smartMatchRemoveStacks(inventory, ++inputIndex, foundSlots, inputs);
        }else{
            return;
        }
    }
}
