package com.dissonance.legendaryarmory.setup;


import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.recipes.MysticForgeRecipe;
import com.dissonance.legendaryarmory.recipes.MysticForgeRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Recipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(LegendaryArmory.MODID, MysticForgeRecipeSerializer.ID), MysticForgeRecipeSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(LegendaryArmory.MODID, MysticForgeRecipe.Type.ID), MysticForgeRecipe.Type.INSTANCE);
    }
}
