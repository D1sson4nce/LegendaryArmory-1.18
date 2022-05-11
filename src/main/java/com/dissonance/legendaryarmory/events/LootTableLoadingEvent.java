package com.dissonance.legendaryarmory.events;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.loottables.ModLootNumberProvider;
import com.dissonance.legendaryarmory.setup.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class LootTableLoadingEvent {
    private static final Identifier ZOMBIE_LOOT_TABLE_ID = EntityType.ZOMBIE.getLootTableId();


    static public void LootTableLoading(ResourceManager resourceManager, LootManager manager, Identifier id, FabricLootSupplierBuilder supplier, LootTableLoadingCallback.LootTableSetter setter){
        var DuskPoolBuilder = FabricLootPoolBuilder.builder()
                .rolls(ModLootNumberProvider.create(0)).bonusRolls(ModLootNumberProvider.create(0.5F)).with(ItemEntry.builder(ModItems.DUSK));

        if(ZOMBIE_LOOT_TABLE_ID.equals(id)){
            supplier.pool();
        }
    }
}
