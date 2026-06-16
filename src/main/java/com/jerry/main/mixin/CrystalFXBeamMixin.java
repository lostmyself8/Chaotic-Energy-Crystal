package com.jerry.main.mixin;

import com.brandon3055.draconicevolution.client.render.effect.CrystalFXBeam;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Arrays;

@Mixin(value = CrystalFXBeam.class, remap = false)
public abstract class CrystalFXBeamMixin {

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "r")
    private float[] chaosEnergyCrystal$extendRed(float[] r) {
        return chaosEnergyCrystal$withChaoticColour(r, 0.04F);
    }

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "g")
    private float[] chaosEnergyCrystal$extendGreen(float[] g) {
        return chaosEnergyCrystal$withChaoticColour(g, 0.08F);
    }

    @ModifyVariable(method = "tick", at = @At("STORE"), name = "b")
    private float[] chaosEnergyCrystal$extendBlue(float[] b) {
        return chaosEnergyCrystal$withChaoticColour(b, 0.55F);
    }

    @Unique
    private float[] chaosEnergyCrystal$withChaoticColour(float[] values, float chaoticValue) {
        if (values.length > 3) {
            return values;
        }
        float[] extended = Arrays.copyOf(values, 4);
        extended[3] = chaoticValue;
        return extended;
    }
}