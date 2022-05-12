package com.dissonance.legendaryarmory.events;

import com.dissonance.legendaryarmory.events.loottableids.ChestIdentifiers;
import com.dissonance.legendaryarmory.events.loottableids.MobIdentifiers;
import com.dissonance.legendaryarmory.setup.ModItems;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ToolItem;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetContentsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class LootTableLoadingEvent {
    private static final DefaultedList<ToolItem> precursors = DefaultedList.ofSize(1, ModItems.DUSK);

    static public void LootTableLoading(ResourceManager resourceManager, LootManager manager, Identifier id, FabricLootSupplierBuilder supplier, LootTableLoadingCallback.LootTableSetter setter){
        setPrecursors();

        for (ToolItem precursor: precursors) {
            var precursorMobPoolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.0001F))
                    .with(ItemEntry.builder(precursor));

            var precursorChestPoolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.001F))
                    .with(ItemEntry.builder(precursor));

            if(MobIdentifiers.BLAZE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.CAVE_SPIDER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.CREEPER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.DROWNED_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ELDER_GUARDIAN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ENDERMAN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ENDERMITE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.EVOKER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.GHAST_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.GUARDIAN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.HOGLIN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.HUSK_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.MAGMA_CUBE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.PHANTOM_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.PIGLIN_BRUTE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.PIGLIN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.PILLAGER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.RAVAGER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.SHULKER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.SILVERFISH_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.SPIDER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.SKELETON_HORSE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.SKELETON_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.STRAY_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.SLIME_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.VEX_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.VINDICATOR_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.WITHER_SKELETON_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.WITHER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.WITCH_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ZOMBIE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ZOGLIN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ZOMBIE_HORSE_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ZOMBIE_VILLAGER_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);
            if(MobIdentifiers.ZOMBIFIED_PIGLIN_ID.equals(id)) supplier.pool(precursorMobPoolBuilder);

            if(ChestIdentifiers.MINECART_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.MINESHAFT_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.WOODLAND_MANSION_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.SHIPWRECK_MAP_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.DESERT_PYRAMID_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.JUNGLE_TEMPLE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.JUNGLE_TEMPLE_DISPENSER_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.BASTION_BRIDGE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.END_CITY_TREASURE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.UNDERWATER_RUIN_SMALL_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.BASTION_HOGLIN_STABLE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.BASTION_OTHER_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.BURIED_TREASURE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.BASTION_TREASURE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.NETHER_BRIDE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.OUTPOST_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.RUINED_PORTAL_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.SHIPWRECK_SUPPLY_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.SHIPWRECK_TREASURE_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.DUNGEON_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.STRONGHOLD_CORRIDOR_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.STRONGHOLD_CROSSING_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.STRONGHOLD_LIBRARY_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
            if(ChestIdentifiers.UNDERWATER_RUIN_BIG_CHEST_ID.equals(id)) supplier.pool(precursorChestPoolBuilder);
        }

        var DungeonDropsChestPoolBuilder = FabricLootPoolBuilder.builder()
                .conditionally(RandomChanceLootCondition.builder(0.34F))
                .with(ItemEntry.builder(ModItems.DUNGEON_DROPS))
                .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 5F)).build())
                .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 6F)).build())
                .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(0F, 7F)).build());

        if(ChestIdentifiers.MINECART_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.MINESHAFT_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.WOODLAND_MANSION_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.BASTION_BRIDGE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.END_CITY_TREASURE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.UNDERWATER_RUIN_SMALL_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.BASTION_HOGLIN_STABLE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.BASTION_OTHER_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.BASTION_TREASURE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.NETHER_BRIDE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.OUTPOST_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.DUNGEON_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.STRONGHOLD_CORRIDOR_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.STRONGHOLD_CROSSING_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.STRONGHOLD_LIBRARY_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        if(ChestIdentifiers.UNDERWATER_RUIN_BIG_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
    }

    private static void setPrecursors(){
        precursors.set(0, ModItems.DUSK);
    }
}
