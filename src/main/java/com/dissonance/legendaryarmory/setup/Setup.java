package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Setup {
    public static final ItemGroup LEGENDARY_ARMORY_GROUP = FabricItemGroupBuilder.create(new Identifier(LegendaryArmory.MODID, "legendary_armory")).icon(() -> new ItemStack(ModItems.TWILIGHT)).build();

    public static void init(){
        Blocks.register();
        ModItems.register();
        Entities.register();
        ScreenHandlers.register();
        Recipes.register();
    }
}
