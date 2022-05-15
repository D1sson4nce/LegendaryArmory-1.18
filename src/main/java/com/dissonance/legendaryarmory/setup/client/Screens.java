package com.dissonance.legendaryarmory.setup.client;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import com.dissonance.legendaryarmory.screen.MysticForgeScreen;
import com.dissonance.legendaryarmory.screen.MysticForgeScreenHandler;
import com.dissonance.legendaryarmory.setup.ScreenHandlers;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class Screens {

    public static void register(){
        ScreenRegistry.register(ScreenHandlers.MYSTIC_FORGE_SCREEN_HANDLER, MysticForgeScreen::new);
    }
}