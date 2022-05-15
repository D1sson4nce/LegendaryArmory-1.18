package com.dissonance.legendaryarmory;

import com.dissonance.legendaryarmory.setup.client.ClientSetup;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class LegendaryArmoryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSetup.init();
    }
}
