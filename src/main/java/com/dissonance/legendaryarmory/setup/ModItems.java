package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.materials.DuskMaterial;
import com.dissonance.legendaryarmory.materials.TwilightMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final ToolItem TWILIGHT = new SwordItem(TwilightMaterial.INSTANCE, 0, -2F, new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).fireproof());
    public static final ToolItem DUSK = new SwordItem(DuskMaterial.INSTANCE, 0, -2.4F, new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final BlockItem MYSTIC_FORGE = new BlockItem(Blocks.MYSTIC_FORGE, new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item GIFT_OF_TWILIGHT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).maxCount(1));
    public static final Item ICY_RUNESTONE = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item SIGIL = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final Item GIFT_OF_METAL = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP).maxCount(5));
    public static final Item ORICHALCUM_INGOT = new Item(new FabricItemSettings().group(Setup.LEGENDARY_ARMORY_GROUP));

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "mystic_forge"), MYSTIC_FORGE);

        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_twilight"), GIFT_OF_TWILIGHT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "icy_runestone"), ICY_RUNESTONE);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "sigil"), SIGIL);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "gift_of_metal"), GIFT_OF_METAL);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "orichalcum_ingot"), ORICHALCUM_INGOT);

        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "dusk"), DUSK);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "twilight"), TWILIGHT);
    }
}
