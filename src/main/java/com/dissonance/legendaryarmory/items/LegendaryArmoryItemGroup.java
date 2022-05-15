package com.dissonance.legendaryarmory.items;

import com.dissonance.legendaryarmory.LegendaryArmory;
import com.dissonance.legendaryarmory.setup.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LegendaryArmoryItemGroup {
    public static ItemGroup LEGENDARY_ARMORY;

    public static void createItemGroup(){
        LEGENDARY_ARMORY = FabricItemGroupBuilder.create(new Identifier(LegendaryArmory.MODID, "legendary_armory"))
                .icon(() -> new ItemStack(ModItems.TWILIGHT))
                .appendItems(stacks -> {
                    stacks.add(new ItemStack(ModItems.PLATINUM_ORE));
                    stacks.add(new ItemStack(ModItems.MITHRIL_ORE));
                    stacks.add(new ItemStack(ModItems.ORICHALCUM_ORE));
                    stacks.add(new ItemStack(ModItems.DEEPSLATE_PLATINUM_ORE));
                    stacks.add(new ItemStack(ModItems.DEEPSLATE_MITHRIL_ORE));
                    stacks.add(new ItemStack(ModItems.DEEPSLATE_ORICHALCUM_ORE));
                    stacks.add(new ItemStack(ModItems.MYSTIC_FORGE));
                    stacks.add(ItemStack.EMPTY);
                    stacks.add(ItemStack.EMPTY);

                    stacks.add(new ItemStack(ModItems.RAW_PLATINUM));
                    stacks.add(new ItemStack(ModItems.RAW_MITHRIL));
                    stacks.add(new ItemStack(ModItems.RAW_ORICHALCUM));
                    stacks.add(new ItemStack(ModItems.PLATINUM_INGOT));
                    stacks.add(new ItemStack(ModItems.MITHRIL_INGOT));
                    stacks.add(new ItemStack(ModItems.ORICHALCUM_INGOT));
                    stacks.add(new ItemStack(ModItems.DARKSTEEL_INGOT));
                    stacks.add(new ItemStack(ModItems.CURED_LEATHER));
                    stacks.add(new ItemStack(ModItems.ONYX_LODESTONE));

                    stacks.add(new ItemStack(ModItems.VIAL_OF_BLOOD));
                    stacks.add(new ItemStack(ModItems.CRYSTALLINE_DUST));
                    stacks.add(new ItemStack(ModItems.TOTEM));
                    stacks.add(new ItemStack(ModItems.VENOM_SAC));
                    stacks.add(new ItemStack(ModItems.ANCIENT_BONE));
                    stacks.add(new ItemStack(ModItems.FANG));
                    stacks.add(new ItemStack(ModItems.CLAW));
                    stacks.add(new ItemStack(ModItems.SCALE));
                    stacks.add(new ItemStack(ModItems.MYSTIC_COIN));

                    stacks.add(new ItemStack(ModItems.SPIRIT_SHARD));
                    stacks.add(new ItemStack(ModItems.PHILOSOPHERS_STONE));
                    stacks.add(new ItemStack(ModItems.DUNGEON_DROPS));
                    stacks.add(new ItemStack(ModItems.ICY_RUNESTONE));
                    stacks.add(new ItemStack(ModItems.SIGIL));
                    stacks.add(new ItemStack(ModItems.OBSIDIAN_SHARD));
                    stacks.add(new ItemStack(ModItems.GLOB_OF_ECTOPLASM));
                    stacks.add(new ItemStack(ModItems.MYSTIC_CLOVER));
                    stacks.add(new ItemStack(ModItems.BLOODSTONE_SHARD));

                    stacks.add(new ItemStack(ModItems.GIFT_OF_ASCALON));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_EXPLORATION));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_BATTLE));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_MAGIC));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_MIGHT));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_METAL));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_DARKNESS));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_MASTERY));
                    stacks.add(new ItemStack(ModItems.GIFT_OF_FORTUNE));

                    stacks.add(new ItemStack(ModItems.GIFT_OF_TWILIGHT));
                    stacks.add(new ItemStack(ModItems.DUSK));
                    stacks.add(new ItemStack(ModItems.TWILIGHT));
                })
                .build();
    }
}
