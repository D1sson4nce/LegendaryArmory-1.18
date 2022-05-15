package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.enchantment.CarvingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    public static Enchantment CARVING;

    public static void register(){
        CARVING = Registry.register(Registry.ENCHANTMENT, new Identifier(LegendaryArmory.MODID, "carving"),
                new CarvingEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.DIGGER, EquipmentSlot.MAINHAND));
    }
}
