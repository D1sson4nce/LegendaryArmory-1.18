package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import com.dissonance.legendaryarmory.blocks.entities.MysticForgeEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Entities {
    public static BlockEntityType<MysticForgeEntity> MYSTIC_FORGE_ENTITY;

    public static void register() {
        MYSTIC_FORGE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(LegendaryArmory.MODID, MysticForgeBlock.ID), FabricBlockEntityTypeBuilder.create(MysticForgeEntity::new, Blocks.MYSTIC_FORGE).build(null));
    }
}
