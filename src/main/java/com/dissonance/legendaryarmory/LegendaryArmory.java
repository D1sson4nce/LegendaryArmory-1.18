package com.dissonance.legendaryarmory;

import com.dissonance.legendaryarmory.events.UseBlockEvents;
import com.dissonance.legendaryarmory.setup.ModItems;
import com.dissonance.legendaryarmory.setup.Setup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.advancement.Advancement;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.ActionResult;

public class LegendaryArmory implements ModInitializer {
	public static final String MODID = "legendaryarmory";

	@Override
	public void onInitialize() {
		Setup.init();
		eventInit();
	}

	private void eventInit() {
		UseBlockCallback.EVENT.register(UseBlockEvents::LodestoneConversion);
	}
}
