package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.materials.DuskMaterial;
import com.dissonance.legendaryarmory.materials.TwilightMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final ToolItem TWILIGHT = new SwordItem(TwilightMaterial.INSTANCE, 0, -2F, new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).fireproof().rarity(Rarity.EPIC));
    public static final ToolItem DUSK = new SwordItem(DuskMaterial.INSTANCE, 0, -2.4F, new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.RARE));
    public static final BlockItem MYSTIC_FORGE = new BlockItem(Blocks.MYSTIC_FORGE, new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item GIFT_OF_TWILIGHT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item ICY_RUNESTONE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item SIGIL = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.RARE));
    public static final Item GIFT_OF_METAL = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item ORICHALCUM_INGOT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item RAW_ORICHALCUM = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item MITHRIL_INGOT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item RAW_MITHRIL = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item DARKSTEEL_INGOT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item PLATINUM_INGOT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item RAW_PLATINUM = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item GIFT_OF_DARKNESS = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item CURED_LEATHER = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item ONYX_LODESTONE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.RARE));
    public static final Item OBSIDIAN_SHARD = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item GIFT_OF_ASCALON = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item DUNGEON_DROPS = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item GIFT_OF_FORTUNE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item GLOB_OF_ECTOPLASM = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.RARE));
    public static final Item MYSTIC_CLOVER = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item MYSTIC_COIN = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item PHILOSOPHERS_STONE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item SPIRIT_SHARD = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item GIFT_OF_MAGIC = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item VIAL_OF_BLOOD = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item TOTEM = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item VENOM_SAC = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item CRYSTALLINE_DUST = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item GIFT_OF_MIGHT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item ANCIENT_BONE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item CLAW = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item FANG = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item SCALE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item GIFT_OF_MASTERY = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item BLOODSTONE_SHARD = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item GIFT_OF_EXPLORATION = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));
    public static final Item GIFT_OF_BATTLE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).rarity(Rarity.EPIC));

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "mystic_forge"), MYSTIC_FORGE);

        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_twilight"), GIFT_OF_TWILIGHT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "icy_runestone"), ICY_RUNESTONE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "sigil"), SIGIL);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_metal"), GIFT_OF_METAL);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "orichalcum_ingot"), ORICHALCUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "raw_orichalcum"), RAW_ORICHALCUM);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "mithril_ingot"), MITHRIL_INGOT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "raw_mithril"), RAW_MITHRIL);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "darksteel_ingot"), DARKSTEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "platinum_ingot"), PLATINUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "raw_platinum"), RAW_PLATINUM);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_darkness"), GIFT_OF_DARKNESS);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "cured_leather"), CURED_LEATHER);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "onyx_lodestone"), ONYX_LODESTONE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "obsidian_shard"), OBSIDIAN_SHARD);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_ascalon"), GIFT_OF_ASCALON);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "dungeon_drops"), DUNGEON_DROPS);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_fortune"), GIFT_OF_FORTUNE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "glob_of_ectoplasm"), GLOB_OF_ECTOPLASM);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "mystic_clover"), MYSTIC_CLOVER);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "mystic_coin"), MYSTIC_COIN);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "philosophers_stone"), PHILOSOPHERS_STONE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "spirit_shard"), SPIRIT_SHARD);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_magic"), GIFT_OF_MAGIC);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "vial_of_blood"), VIAL_OF_BLOOD);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "crystalline_dust"), CRYSTALLINE_DUST);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "totem"), TOTEM);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "venom_sac"), VENOM_SAC);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_might"), GIFT_OF_MIGHT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "ancient_bone"), ANCIENT_BONE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "fang"), FANG);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "claw"), CLAW);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "scale"), SCALE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_mastery"), GIFT_OF_MASTERY);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_battle"), GIFT_OF_BATTLE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_exploration"), GIFT_OF_EXPLORATION);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "bloodstone_shard"), BLOODSTONE_SHARD);

        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "dusk"), DUSK);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "twilight"), TWILIGHT);
    }
}