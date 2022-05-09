package com.dissonance.legendaryarmory.recipes;

import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class MysticForgeRecipeSerializer implements RecipeSerializer<MysticForgeRecipe> {
    public static final MysticForgeRecipeSerializer INSTANCE = new MysticForgeRecipeSerializer();
    public static final String ID = MysticForgeBlock.ID;

    @Override
    public MysticForgeRecipe read(Identifier id, JsonObject json) {
        var jsonOutputs = JsonHelper.getArray(json, "outputs");
        var outputs = DefaultedList.ofSize(jsonOutputs.size(), ItemStack.EMPTY);

        for (int i = 0; i < outputs.size(); i++) {
            outputs.set(i, ShapedRecipe.outputFromJson((JsonObject)jsonOutputs.get(i)));
        }

        var ingredients = JsonHelper.getArray(json, "ingredients");
        var inputs = DefaultedList.ofSize(ingredients.size(), new MysticForgeRecipe.Input(Ingredient.EMPTY, 0));

        for (var i = 0; i < inputs.size(); i++) {
            var ingredient = Ingredient.fromJson(ingredients.get(i));
            var count = JsonHelper.getInt((JsonObject)ingredients.get(i), "count");
            inputs.set(i, new MysticForgeRecipe.Input(ingredient, count));
        }

        var successRate = JsonHelper.getFloat(json, "successRate");

        return new MysticForgeRecipe(id, outputs, inputs, successRate);
    }

    @Override
    public void write(PacketByteBuf buf, MysticForgeRecipe recipe) {
        buf.writeInt(recipe.getInputs().size());
        for (var input : recipe.getInputs()){
            input.getIngredient().write(buf);
            buf.writeInt(input.getCount());
        }
        buf.writeItemStack(recipe.getOutput());
        buf.writeFloat(recipe.getSuccessRate());
    }

    @Override
    public MysticForgeRecipe read(Identifier id, PacketByteBuf buf) {
        var inputs = DefaultedList.ofSize(buf.readInt(), new MysticForgeRecipe.Input(Ingredient.EMPTY, 0));

        for (int i = 0; i < inputs.size(); i++) {
            var ingredient = Ingredient.fromPacket(buf);
            var count = buf.readInt();
            inputs.set(i, new MysticForgeRecipe.Input(ingredient, count));
        }

        var output = buf.readItemStack();
        var outputs = DefaultedList.ofSize(1, output);

        var successRate = buf.readFloat();

        return new MysticForgeRecipe(id, outputs, inputs, successRate);
    }
}
