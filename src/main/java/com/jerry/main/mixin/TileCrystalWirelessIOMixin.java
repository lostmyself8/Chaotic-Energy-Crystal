package com.jerry.main.mixin;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalBase;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalWirelessIO;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = TileCrystalWirelessIO.class, remap = false)
public abstract class TileCrystalWirelessIOMixin extends TileCrystalBase {

    @Unique
    private static final int CHAOTIC_TIER = TechLevel.CHAOTIC.index;

    public TileCrystalWirelessIOMixin(BlockEntityType<?> tileEntityTypeIn, BlockPos pos, BlockState state) {
        super(tileEntityTypeIn, pos, state);
    }

    @Override
    public int getTier() {
        return super.getTier();
    }

    @Inject(method = "getMaxReceivers", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$getMaxReceivers(CallbackInfoReturnable<Integer> cir) {
        if (getTier() == CHAOTIC_TIER) {
            cir.setReturnValue(128);
        }
    }

    @Inject(method = "getMaxWirelessTransfer", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$getMaxWirelessTransfer(CallbackInfoReturnable<Integer> cir) {
        if (getTier() == CHAOTIC_TIER) {
            cir.setReturnValue(2048000);
        }
    }
}