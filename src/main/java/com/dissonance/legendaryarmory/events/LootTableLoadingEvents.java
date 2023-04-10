package com.dissonance.legendaryarmory.events;

import com.dissonance.legendaryarmory.events.loottableids.ChestIdentifiers;
import com.dissonance.legendaryarmory.events.loottableids.MobIdentifiers;
import com.dissonance.legendaryarmory.setup.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.item.ToolItem;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class LootTableLoadingEvents {
    private static final DefaultedList<ToolItem> precursors = DefaultedList.ofSize(1, ModItems.DUSK);

    static public void LootTableLoading(ResourceManager resourceManager, LootManager lootManager, Identifier id, LootTable.Builder supplier, LootTableSource source){
        setPrecursors();
        for (ToolItem precursor: precursors) {
            var precursorMobPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.0001F))
                    .with(ItemEntry.builder(precursor));

            setAllHostileMobs(id, supplier, precursorMobPoolBuilder);

            var precursorChestPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.001F))
                    .with(ItemEntry.builder(precursor));

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

        {
            var DungeonDropsChestPoolBuilder = LootPool.builder()
                    .conditionally(RandomChanceLootCondition.builder(0.34F))
                    .with(ItemEntry.builder(ModItems.DUNGEON_DROPS))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 5F)).build())
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, 6F)).build())
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0F, 7F)).build());

            if (ChestIdentifiers.MINECART_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.MINESHAFT_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.WOODLAND_MANSION_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.BASTION_BRIDGE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.END_CITY_TREASURE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.UNDERWATER_RUIN_SMALL_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.BASTION_HOGLIN_STABLE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.BASTION_OTHER_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.BASTION_TREASURE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.NETHER_BRIDE_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.OUTPOST_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.DUNGEON_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.STRONGHOLD_CORRIDOR_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.STRONGHOLD_CROSSING_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.STRONGHOLD_LIBRARY_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
            if (ChestIdentifiers.UNDERWATER_RUIN_BIG_CHEST_ID.equals(id)) supplier.pool(DungeonDropsChestPoolBuilder);
        }

        {
            var ancientBonePoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.ANCIENT_BONE));
            var clawPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.CLAW));
            var scalePoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.SCALE));
            var fangPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.FANG));
            var crystallineDustPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.CRYSTALLINE_DUST));
            var totemPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.TOTEM));
            var venomSacPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.VENOM_SAC));
            var vialOfBloodPoolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.125F))
                    .with(ItemEntry.builder(ModItems.VIAL_OF_BLOOD));

            if(MobIdentifiers.SKELETON_ID.equals(id)){
                supplier.pool(ancientBonePoolBuilder);
            }
            if(MobIdentifiers.WITHER_SKELETON_ID.equals(id)){
                supplier.pool(ancientBonePoolBuilder);
            }
            if(MobIdentifiers.SKELETON_HORSE_ID.equals(id)){
                supplier.pool(ancientBonePoolBuilder);
            }
            if(MobIdentifiers.STRAY_ID.equals(id)){
                supplier.pool(ancientBonePoolBuilder);
            }

            if(MobIdentifiers.PANDA_ID.equals(id)){
                supplier.pool(clawPoolBuilder);
            }
            if(MobIdentifiers.POLAR_BEAR_ID.equals(id)){
                supplier.pool(clawPoolBuilder);
            }
            if(MobIdentifiers.FOX_ID.equals(id)){
                supplier.pool(clawPoolBuilder);
            }

            if(MobIdentifiers.TURTLE_ID.equals(id)){
                supplier.pool(scalePoolBuilder);
            }
            if(MobIdentifiers.GUARDIAN_ID.equals(id)){
                supplier.pool(scalePoolBuilder);
            }
            if(MobIdentifiers.ELDER_GUARDIAN_ID.equals(id)){
                supplier.pool(scalePoolBuilder);
            }
            if(MobIdentifiers.SILVERFISH_ID.equals(id)){
                supplier.pool(scalePoolBuilder);
            }

            if(MobIdentifiers.PIGLIN_ID.equals(id)){
                supplier.pool(fangPoolBuilder);
            }
            if(MobIdentifiers.PIGLIN_BRUTE_ID.equals(id)){
                supplier.pool(fangPoolBuilder);
            }
            if(MobIdentifiers.HOGLIN_ID.equals(id)){
                supplier.pool(fangPoolBuilder);
            }

            if(MobIdentifiers.BLAZE_ID.equals(id)){
                supplier.pool(crystallineDustPoolBuilder);
            }
            if(MobIdentifiers.HUSK_ID.equals(id)){
                supplier.pool(crystallineDustPoolBuilder);
            }
            if(MobIdentifiers.CREEPER_ID.equals(id)){
                supplier.pool(crystallineDustPoolBuilder);
            }
            if(MobIdentifiers.WITCH_ID.equals(id)){
                supplier.pool(crystallineDustPoolBuilder);
            }

            if(MobIdentifiers.EVOKER_ID.equals(id)){
                supplier.pool(totemPoolBuilder);
            }
            if(MobIdentifiers.PILLAGER_ID.equals(id)){
                supplier.pool(totemPoolBuilder);
            }
            if(MobIdentifiers.VINDICATOR_ID.equals(id)){
                supplier.pool(totemPoolBuilder);
            }
            if(MobIdentifiers.RAVAGER_ID.equals(id)){
                supplier.pool(totemPoolBuilder);
            }

            if(MobIdentifiers.SPIDER_ID.equals(id)){
                supplier.pool(venomSacPoolBuilder);
            }
            if(MobIdentifiers.CAVE_SPIDER_ID.equals(id)){
                supplier.pool(venomSacPoolBuilder);
            }
            if(MobIdentifiers.PUFFERFISH_ID.equals(id)){
                supplier.pool(venomSacPoolBuilder);
            }

            if(MobIdentifiers.WITCH_ID.equals(id)){
                supplier.pool(vialOfBloodPoolBuilder);
            }
            if(MobIdentifiers.WANDERING_TRADER_ID.equals(id)){
                supplier.pool(vialOfBloodPoolBuilder);
            }
        }

        var ectoplasmPoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.0625F))
                .with(ItemEntry.builder(ModItems.GLOB_OF_ECTOPLASM));

        setAllHostileMobs(id, supplier, ectoplasmPoolBuilder);

        var giftOfBattlePoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.125F))
                .with(ItemEntry.builder(ModItems.GIFT_OF_BATTLE));

        if(MobIdentifiers.WITHER_ID.equals(id)) supplier.pool(giftOfBattlePoolBuilder);

        var giftOfExplorationPoolBuilder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(0.25F))
                .with(ItemEntry.builder(ModItems.GIFT_OF_EXPLORATION));

        if(ChestIdentifiers.WOODLAND_MANSION_CHEST_ID.equals(id)) supplier.pool(giftOfExplorationPoolBuilder);
    }

    private static void setPrecursors(){
        precursors.set(0, ModItems.DUSK);
    }

    private static void setAllHostileMobs(Identifier id, LootTable.Builder supplier, LootPool.Builder mobPoolBuilder){
        if(MobIdentifiers.BLAZE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.CAVE_SPIDER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.CREEPER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.DROWNED_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ELDER_GUARDIAN_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ENDERMAN_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ENDERMITE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.EVOKER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.GHAST_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.GUARDIAN_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.HOGLIN_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.HUSK_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ILLUSIONER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.MAGMA_CUBE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.PHANTOM_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.PIGLIN_BRUTE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.PIGLIN_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.PILLAGER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.RAVAGER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.SHULKER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.SILVERFISH_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.SPIDER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.SKELETON_HORSE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.SKELETON_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.STRAY_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.SLIME_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.VEX_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.VINDICATOR_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.WITHER_SKELETON_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.WITHER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.WITCH_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ZOMBIE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ZOGLIN_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ZOMBIE_HORSE_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ZOMBIE_VILLAGER_ID.equals(id)) supplier.pool(mobPoolBuilder);
        if(MobIdentifiers.ZOMBIFIED_PIGLIN_ID.equals(id)) supplier.pool(mobPoolBuilder);
    }
}
