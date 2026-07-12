package com.jerry.main.common.registries;

import com.brandon3055.brandonscore.blocks.ItemBlockBCore;
import com.jerry.main.ChaoticEnergyCrystal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    private ModItems() {
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChaoticEnergyCrystal.MOD_ID);

    public static final RegistryObject<ItemBlockBCore> ITEM_CHAOTIC_IO_CRYSTAL = ITEMS.register("chaotic_io_crystal", () -> new ItemBlockBCore(ModBlocks.CHAOTIC_IO_CRYSTAL.get(), new Properties()));
    public static final RegistryObject<ItemBlockBCore> ITEM_CHAOTIC_RELAY_CRYSTAL = ITEMS.register("chaotic_relay_crystal", () -> new ItemBlockBCore(ModBlocks.CHAOTIC_RELAY_CRYSTAL.get(), new Properties()));
    public static final RegistryObject<ItemBlockBCore> ITEM_CHAOTIC_WIRELESS_CRYSTAL = ITEMS.register("chaotic_wireless_crystal", () -> new ItemBlockBCore(ModBlocks.CHAOTIC_WIRELESS_CRYSTAL.get(), new Properties()));
}
