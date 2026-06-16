package com.jerry.main.common.registries;

import com.brandon3055.brandonscore.blocks.ItemBlockBCore;
import com.jerry.main.ChaoticEnergyCrystal;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    private ModItems() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, ChaoticEnergyCrystal.MOD_ID);

    public static final DeferredHolder<Item, ItemBlockBCore> ITEM_CHAOTIC_IO_CRYSTAL = ITEMS.register("chaotic_io_crystal", () -> new ItemBlockBCore(ModBlocks.CHAOTIC_IO_CRYSTAL.get(), new Properties()));  //EnergyCrystal
    public static final DeferredHolder<Item, ItemBlockBCore> ITEM_CHAOTIC_RELAY_CRYSTAL = ITEMS.register("chaotic_relay_crystal", () -> new ItemBlockBCore(ModBlocks.CHAOTIC_RELAY_CRYSTAL.get(), new Properties()));  //EnergyCrystal
    public static final DeferredHolder<Item, ItemBlockBCore> ITEM_CHAOTIC_WIRELESS_CRYSTAL = ITEMS.register("chaotic_wireless_crystal", () -> new ItemBlockBCore(ModBlocks.CHAOTIC_WIRELESS_CRYSTAL.get(), new Properties()));  //EnergyCrystal
}