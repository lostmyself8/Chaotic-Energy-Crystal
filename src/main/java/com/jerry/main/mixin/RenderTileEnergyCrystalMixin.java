package com.jerry.main.mixin;

import com.brandon3055.draconicevolution.client.render.tile.RenderTileEnergyCrystal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(value = RenderTileEnergyCrystal.class, remap = false)
public abstract class RenderTileEnergyCrystalMixin {
    @Shadow
    public static float[][] COLOURS;

    @Shadow
    private static float[] r;

    @Shadow
    private static float[] g;

    @Shadow
    private static float[] b;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void chaosEnergyCrystal$addChaoticColour(CallbackInfo ci) {
        COLOURS = Arrays.copyOf(COLOURS, 4);
        COLOURS[3] = new float[]{0.08F, 0.0F, 0.12F};

        r = Arrays.copyOf(r, 4);
        g = Arrays.copyOf(g, 4);
        b = Arrays.copyOf(b, 4);

        r[3] = 0.25F;
        g[3] = 0.0F;
        b[3] = 0.45F;
    }
}