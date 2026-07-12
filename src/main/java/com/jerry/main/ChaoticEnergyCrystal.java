package com.jerry.main;

import com.jerry.main.common.registries.ModBlocks;
import com.jerry.main.common.registries.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChaoticEnergyCrystal.MOD_ID)
public class ChaoticEnergyCrystal {
    public static final String MOD_ID = "chaotic_energy_crystal";

    private static final ResourceKey<CreativeModeTab> DE_BLOCKS_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath("draconicevolution", "blocks"));

    public ChaoticEnergyCrystal() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(DE_BLOCKS_TAB)) {
            event.accept(ModItems.ITEM_CHAOTIC_IO_CRYSTAL.get());
            event.accept(ModItems.ITEM_CHAOTIC_RELAY_CRYSTAL.get());
            event.accept(ModItems.ITEM_CHAOTIC_WIRELESS_CRYSTAL.get());
        }
    }
}