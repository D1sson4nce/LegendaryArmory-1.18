package com.dissonance.legendaryarmory.loottables;

import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProviderType;
import net.minecraft.loot.provider.number.LootNumberProviderTypes;

public class ModLootNumberProvider implements LootNumberProvider {
    private static float value;

    ModLootNumberProvider(float value) {
        this.value = value;
    }

    public static ModLootNumberProvider create(float value){
        return new ModLootNumberProvider(value);
    }

    @Override
    public float nextFloat(LootContext context) {
        return value;
    }

    @Override
    public LootNumberProviderType getType() {
        return LootNumberProviderTypes.BINOMIAL;
    }
}
