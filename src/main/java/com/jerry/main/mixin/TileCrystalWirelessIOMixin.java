package com.jerry.main.mixin;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalWirelessIO;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = TileCrystalWirelessIO.class, remap = false)
public abstract class TileCrystalWirelessIOMixin {

    @Unique
    private static final int CHAOTIC_TIER = TechLevel.CHAOTIC.index;

    @Inject(method = "getMaxReceivers", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$getMaxReceivers(CallbackInfoReturnable<Integer> cir) {
        //不能直接使用@Shadow标记getTier()
        if (((TileCrystalWirelessIO) (Object) this).getTier() == CHAOTIC_TIER) {
            cir.setReturnValue(128);
        }
    }
}