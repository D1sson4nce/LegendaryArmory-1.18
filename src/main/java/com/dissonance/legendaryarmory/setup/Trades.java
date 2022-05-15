package com.dissonance.legendaryarmory.setup;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

import java.util.Random;

public class Trades {
    private static final DefaultedList<Item> dungeonGifts = DefaultedList.ofSize(1, ModItems.GIFT_OF_ASCALON);

    public static void register(){
        setDungeonGifts();
        var rng = new Random();
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.DIAMOND, rng.nextInt(1,33)),
                        new ItemStack(ModItems.MYSTIC_COIN, 1),
                            16, 2, 0.2F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SPIRIT_SHARD, 1),
                            new ItemStack(ModItems.ICY_RUNESTONE, 10),
                            10, 2, 0.2F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.SPIRIT_SHARD, 64),
                            new ItemStack(ModItems.BLOODSTONE_SHARD, 1),
                            10, 2, 0.2F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.MYSTIC_COIN, rng.nextInt(2,9)),
                            new ItemStack(ModItems.ICY_RUNESTONE, 1),
                            10, 2, 0.2F
                    ));
                });

        for (var dungeonGift: dungeonGifts) {
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add((entity, random) -> new TradeOffer(
                                new ItemStack(ModItems.DUNGEON_DROPS, 64),
                                new ItemStack(dungeonGift, 1),
                                1, 16, 1
                        ));
                    });
        }
    }

    private static void setDungeonGifts(){
        dungeonGifts.set(0, ModItems.GIFT_OF_ASCALON);
    }
}
