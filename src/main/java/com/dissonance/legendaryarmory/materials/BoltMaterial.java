package com.dissonance.legendaryarmory.materials;

import com.dissonance.legendaryarmory.setup.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BoltMaterial implements ToolMaterial {

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
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.GIFT_OF_FORTUNE);
    }
}
