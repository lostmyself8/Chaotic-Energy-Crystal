package com.jerry.main.common.registries;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.EnergyCrystal;
import com.brandon3055.draconicevolution.blocks.energynet.EnergyCrystal.CrystalType;
import com.jerry.main.ChaoticEnergyCrystal;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    private ModBlocks() {
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, ChaoticEnergyCrystal.MOD_ID);

    public static final Properties CRYSTAL_C = Properties.of().mapColor(DyeColor.BLACK).strength(10.0F, 64F);
    public static final DeferredHolder<Block, EnergyCrystal> CHAOTIC_IO_CRYSTAL = BLOCKS.register("chaotic_io_crystal", () -> new EnergyCrystal(CRYSTAL_C, TechLevel.CHAOTIC, CrystalType.CRYSTAL_IO));
    public static final DeferredHolder<Block, EnergyCrystal> CHAOTIC_RELAY_CRYSTAL = BLOCKS.register("chaotic_relay_crystal", () -> new EnergyCrystal(CRYSTAL_C, TechLevel.CHAOTIC, CrystalType.RELAY));
    public static final DeferredHolder<Block, EnergyCrystal> CHAOTIC_WIRELESS_CRYSTAL = BLOCKS.register("chaotic_wireless_crystal", () -> new EnergyCrystal(CRYSTAL_C, TechLevel.CHAOTIC, CrystalType.WIRELESS));
}