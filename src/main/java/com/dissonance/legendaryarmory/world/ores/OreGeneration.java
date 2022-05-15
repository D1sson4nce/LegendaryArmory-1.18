package com.dissonance.legendaryarmory.world.ores;

import com.dissonance.legendaryarmory.setup.Blocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.List;

public class OreGeneration {
    public static final List<OreFeatureConfig.Target> OVERWORLD_ORICHALCUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, Blocks.ORICHALCUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_ORICHALCUM_ORE.getDefaultState()));
    public static final  List<OreFeatureConfig.Target> OVERWORLD_MITHRIL_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, Blocks.MITHRIL_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_MITHRIL_ORE.getDefaultState()));
    public static final  List<OreFeatureConfig.Target> OVERWORLD_PLATINUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, Blocks.PLATINUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.DEEPSLATE_PLATINUM_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ORICHALCUM_ORE = ConfiguredFeatures.register("orichalcum_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_ORICHALCUM_ORES, 9));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MITHRIL_ORE = ConfiguredFeatures.register("mithril_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_MITHRIL_ORES, 9));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> PLATINUM_ORE = ConfiguredFeatures.register("platinum_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_PLATINUM_ORES, 9));

    public static final  RegistryEntry<PlacedFeature> ORICHALCUM_ORE_PLACED = PlacedFeatures.register("orichalcum_ore_placed", ORICHALCUM_ORE,
            OreFeatures.modifiersWithCount(7, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    public static final  RegistryEntry<PlacedFeature> MITHRIL_ORE_PLACED = PlacedFeatures.register("mithril_ore_placed", MITHRIL_ORE,
            OreFeatures.modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));
    public static final  RegistryEntry<PlacedFeature> PLATINUM_ORE_PLACED = PlacedFeatures.register("platinum_ore_placed", PLATINUM_ORE,
            OreFeatures.modifiersWithCount(9, HeightRangePlacementModifier.uniform(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))));

    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ORICHALCUM_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MITHRIL_ORE_PLACED.getKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, PLATINUM_ORE_PLACED.getKey().get());
    }
}
