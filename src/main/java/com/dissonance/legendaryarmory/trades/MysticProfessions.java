package com.dissonance.legendaryarmory.trades;

import com.dissonance.legendaryarmory.setup.Blocks;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class MysticProfessions {
    public static final PointOfInterestType MYSTIC_BLACKSMITH_POI = PointOfInterestHelper.register(
            new Identifier("mystic_blacksmith_poi"),
            1,
            1,
            Blocks.MYSTIC_FORGE
    );

    public static final VillagerProfession MYSTIC_BLACKSMITH_PROFESSION = VillagerProfessionBuilder.create()
            .id(new Identifier("mystic_blacksmith"))
            .workstation(MYSTIC_BLACKSMITH_POI)
            .workSound(SoundEvents.BLOCK_ANVIL_DESTROY)
            .build();
}
