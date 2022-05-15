package com.dissonance.legendaryarmory.setup;

public class Setup {
    public static void init(){
        Blocks.register();
        ModItems.register();
        Entities.register();
        ScreenHandlers.register();
        Recipes.register();
        World.generateWorldGen();
        Trades.register();

        ModEnchantments.register();
    }
}
