package com.jerry.main;

import com.brandon3055.draconicevolution.init.DEContent;
import com.jerry.main.common.registries.ModBlocks;
import com.jerry.main.common.registries.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import org.slf4j.Logger;

@Mod(ChaoticEnergyCrystal.MOD_ID)
public class ChaoticEnergyCrystal {
    public static final String MOD_ID = "chaotic_energy_crystal";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final ResourceKey<CreativeModeTab> DE_BLOCKS_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath("draconicevolution", "blocks"));

    public ChaoticEnergyCrystal(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::addBlockEntityValidBlocks);
        modEventBus.addListener(this::addCreative);
    }

    private void addBlockEntityValidBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(DEContent.TILE_IO_CRYSTAL.get(), ModBlocks.CHAOTIC_IO_CRYSTAL.get());
        event.modify(DEContent.TILE_RELAY_CRYSTAL.get(), ModBlocks.CHAOTIC_RELAY_CRYSTAL.get());
        event.modify(DEContent.TILE_WIRELESS_CRYSTAL.get(), ModBlocks.CHAOTIC_WIRELESS_CRYSTAL.get());
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == DE_BLOCKS_TAB) {
            event.accept(ModItems.ITEM_CHAOTIC_IO_CRYSTAL.get());
            event.accept(ModItems.ITEM_CHAOTIC_RELAY_CRYSTAL.get());
            event.accept(ModItems.ITEM_CHAOTIC_WIRELESS_CRYSTAL.get());
        }
    }
}