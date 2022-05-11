package com.dissonance.legendaryarmory.materials;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.setup.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TwilightMaterial implements ToolMaterial {
    public static final TwilightMaterial INSTANCE = new TwilightMaterial();

    @Override
    public int getDurability() {
        return 4200;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 15;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.GIFT_OF_FORTUNE);
    }
}
