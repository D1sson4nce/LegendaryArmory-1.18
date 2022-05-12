package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.blocks.MysticForgeBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Blocks {
    public static final MysticForgeBlock MYSTIC_FORGE = new MysticForgeBlock(FabricBlockSettings.of(Material.METAL).strength(1.25F).sounds(BlockSoundGroup.GLASS).requiresTool());
    public static final Block ORICHALCUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5F).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block MITHRIL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5F).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block PLATINUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5F).sounds(BlockSoundGroup.STONE).requiresTool());
    public static final Block DEEPSLATE_ORICHALCUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final Block DEEPSLATE_MITHRIL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());
    public static final Block DEEPSLATE_PLATINUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.5F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool());

    public static void register(){
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "mystic_forge"), MYSTIC_FORGE);
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "orichalcum_ore"), ORICHALCUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "mithril_ore"), MITHRIL_ORE);
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "platinum_ore"), PLATINUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "deepslate_orichalcum_ore"), DEEPSLATE_ORICHALCUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "deepslate_mithril_ore"), DEEPSLATE_MITHRIL_ORE);
        Registry.register(Registry.BLOCK, new Identifier(LegendaryArmory.MODID, "deepslate_platinum_ore"), DEEPSLATE_PLATINUM_ORE);
    }
}
