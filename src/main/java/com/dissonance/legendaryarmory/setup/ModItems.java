package com.dissonance.legendaryarmory.setup;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.materials.DuskMaterial;
import com.dissonance.legendaryarmory.materials.TwilightMaterial;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final ToolItem TWILIGHT = new SwordItem(TwilightMaterial.INSTANCE, 0, -2F, new Item.Settings().group(Setup.LEGENDARY_ARMORY_GROUP).fireproof());
    public static final ToolItem DUSK = new SwordItem(DuskMaterial.INSTANCE, 0, -2.4F, new Item.Settings().group(Setup.LEGENDARY_ARMORY_GROUP));
    public static final BlockItem MYSTIC_FORGE = new BlockItem(Blocks.MYSTIC_FORGE, new Item.Settings().group(Setup.LEGENDARY_ARMORY_GROUP));

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "twilight"), TWILIGHT);
        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "dusk"), DUSK);

        Registry.register(Registry.ITEM, new Identifier(LegendaryArmory.MODID, "mystic_forge"), MYSTIC_FORGE);
    }
}
