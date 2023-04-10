package com.dissonance.legendaryarmory.trades;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.setup.Blocks;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.block.Block;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class MysticProfessions {
    public static final PointOfInterestType MYSTIC_FORGE_POI = registerPOI("mystic_forge_poi", Blocks.MYSTIC_FORGE);

    public static final VillagerProfession MYSTIC_BLACKSMITH_PROFESSION = registerProfession("mystic_blacksmith",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(LegendaryArmory.MODID, "mystic_forge_poi")));

    private static PointOfInterestType registerPOI(String name, Block block) {
        return Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(LegendaryArmory.MODID, name),
                new PointOfInterestType(ImmutableSet.copyOf(block.getStateManager().getStates()), 1, 1));
    }

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(LegendaryArmory.MODID, name),
                VillagerProfessionBuilder.create().id(new Identifier(LegendaryArmory.MODID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH).build());
    }
}
