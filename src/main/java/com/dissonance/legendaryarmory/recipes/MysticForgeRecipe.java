package com.dissonance.legendaryarmory.recipes;

import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Random;

public class MysticForgeRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final DefaultedList<ItemStack> outputs;
    private final DefaultedList<Input> inputs;
    private final float successRate;

    public static class Input{
        private final Ingredient ingredient;
        private final int count;

        public Input(Ingredient ingredient, int count) {
            this.ingredient = ingredient;
            this.count = count;
        }

        public Ingredient getIngredient() {
            return ingredient;
        }

        public int getCount() {
            return count;
        }
    }

    public MysticForgeRecipe(Identifier id, DefaultedList<ItemStack> outputs, DefaultedList<Input> inputs, float successRate){
        this.id = id;
        this.outputs = outputs;
        this.inputs = inputs;
        this.successRate = successRate;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        var foundSlots = DefaultedList.ofSize(4, false);
        return smartMatch(inventory, 0, foundSlots);
    }

    private boolean smartMatch(SimpleInventory inventory, int inputIndex, DefaultedList<Boolean> foundSlots){
        if(inputIndex >= inputs.size()){
            return true;
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(0)) && inventory.getStack(0).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(0)){
            foundSlots.set(0, true);
            return smartMatch(inventory, ++inputIndex, foundSlots);
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(1)) && inventory.getStack(1).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(1)){
            foundSlots.set(1, true);
            return smartMatch(inventory, ++inputIndex, foundSlots);
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(2)) && inventory.getStack(2).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(2)){
            foundSlots.set(2, true);
            return smartMatch(inventory, ++inputIndex, foundSlots);
        }else if(inputs.get(inputIndex).getIngredient().test(inventory.getStack(3)) && inventory.getStack(3).getCount() >= inputs.get(inputIndex).getCount() && !foundSlots.get(3)){
            foundSlots.set(3, true);
            return smartMatch(inventory, ++inputIndex, foundSlots);
        }else{
            return false;
        }
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return getOutput();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        var rng = new Random();
        var output = outputs.get(rng.nextInt(outputs.size()));

        if(output.getItem() instanceof SwordItem){
            Enchantments enchantments;
            for (var input: getInputs()) {

            }
        }

        return output.copy();
    }

    public DefaultedList<Input> getInputs(){
        return inputs;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MysticForgeRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<MysticForgeRecipe>{
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = MysticForgeBlock.ID;
    }

    public float getSuccessRate(){
        return successRate;
    }
}
