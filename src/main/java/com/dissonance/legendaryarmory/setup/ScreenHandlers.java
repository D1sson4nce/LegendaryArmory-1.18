package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import com.dissonance.legendaryarmory.screen.MysticForgeScreen;
import com.dissonance.legendaryarmory.screen.MysticForgeScreenHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlers {
    public static ScreenHandlerType<MysticForgeScreenHandler> MYSTIC_FORGE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(LegendaryArmory.MODID, MysticForgeBlock.ID), MysticForgeScreenHandler::new);

    public static void register(){
        ScreenRegistry.register(MYSTIC_FORGE_SCREEN_HANDLER, MysticForgeScreen::new);
    }
}