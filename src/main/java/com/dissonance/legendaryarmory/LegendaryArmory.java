package com.dissonance.legendaryarmory;

import com.dissonance.legendaryarmory.events.BlockBreakEvents;
import com.dissonance.legendaryarmory.events.LootTableLoadingEvents;
import com.dissonance.legendaryarmory.events.UseBlockEvents;
import com.dissonance.legendaryarmory.setup.Setup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootTable;

public class LegendaryArmory implements ModInitializer {
	public static final String MODID = "legendaryarmory";

	@Override
	public void onInitialize() {
		Setup.init();
		eventInit();
	}

	private void eventInit() {
		UseBlockCallback.EVENT.register(UseBlockEvents::LodestoneConversion);
		LootTableEvents.MODIFY.register(LootTableLoadingEvents::LootTableLoading);
		PlayerBlockBreakEvents.BEFORE.register(BlockBreakEvents::replaceObsidianDrop);
	}
}
