package com.dissonance.legendaryarmory;

import com.dissonance.legendaryarmory.setup.Setup;
import net.fabricmc.api.ModInitializer;

public class LegendaryArmory implements ModInitializer {
	public static final String MODID = "legendaryarmory";

	@Override
	public void onInitialize() {
		Setup.init();
	}
}
