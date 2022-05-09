package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static final MysticForgeBlock MYSTIC_FORGE = new MysticForgeBlock(FabricBlockSettings.of(Material.METAL).strength(1.25F).sounds(BlockSoundGroup.GLASS).requiresTool());

    public static void register(){
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "mystic_forge"), MYSTIC_FORGE);
    }
}
