package com.jerry.main.mixin;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.EnergyCrystal.CrystalType;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = TileCrystalBase.class, remap = false)
public abstract class TileCrystalBaseMixin {

    @Unique
    private static final int CHAOTIC_TIER = TechLevel.CHAOTIC.index;
    @Shadow
    public abstract int getTier();
    @Shadow
    public abstract CrystalType getCrystalType();

    @Inject(method = "maxLinks", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$maxLinks(CallbackInfoReturnable<Integer> cir) {
        if (getTier() == CHAOTIC_TIER) {
            cir.setReturnValue(switch (getCrystalType()) {
                case RELAY -> 64;
                case CRYSTAL_IO -> 5;
                case WIRELESS -> 32;
            });
        }
    }

    @Inject(method = "maxLinkRange", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$maxLinkRange(CallbackInfoReturnable<Integer> cir) {
        if (getTier() == CHAOTIC_TIER) {
            cir.setReturnValue(256);
        }
    }

    @Inject(method = "getCapacityForTier", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$getCapacityForTier(int tier, CallbackInfoReturnable<Integer> cir) {
        if (tier == CHAOTIC_TIER) {
            cir.setReturnValue(256000000);
        }
    }
}