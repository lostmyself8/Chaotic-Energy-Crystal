package com.jerry.main.mixin;

import com.brandon3055.brandonscore.api.TechLevel;
import com.brandon3055.draconicevolution.blocks.energynet.tileentity.TileCrystalBase;
import com.brandon3055.draconicevolution.client.render.effect.CrystalFXBase;
import com.brandon3055.draconicevolution.client.render.effect.CrystalFXIO;
import com.brandon3055.draconicevolution.client.render.effect.CrystalFXIO.FXHandler;
import com.jerry.main.ChaoticEnergyCrystal;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(value = CrystalFXIO.class, remap = false)
public abstract class CrystalFXIOMixin extends CrystalFXBase<TileCrystalBase> {

    @Unique
    private static final ParticleRenderType CHAOTIC_HANDLER = new FXHandler(ResourceLocation.fromNamespaceAndPath(ChaoticEnergyCrystal.MOD_ID, "textures/particle/energy_beam_chaotic.png"));

    public CrystalFXIOMixin(ClientLevel worldIn, TileCrystalBase tile) {
        super(worldIn, tile);
    }

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

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    private void chaosEnergyCrystal$getChaoticRenderType(CallbackInfoReturnable<ParticleRenderType> cir) {
        if (tile.getTier() == TechLevel.CHAOTIC.index) {
            cir.setReturnValue(CHAOTIC_HANDLER);
        }
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