package net.ajdumbdev.westyworm.item;

import net.ajdumbdev.westyworm.WestyWorm;
import net.ajdumbdev.westyworm.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WESTY_WORM_SPAWN_EGG = registerItem("westy_worm_spawn_egg",
            new SpawnEggItem(ModEntities.WESTY_WORM, 0xb0a275, 0x6a2e24,new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WestyWorm.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WestyWorm.LOGGER.info("Regis Mod Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(WESTY_WORM_SPAWN_EGG);
        });
    }
}
