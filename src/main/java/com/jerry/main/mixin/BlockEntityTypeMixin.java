package com.jerry.main.mixin;

import com.brandon3055.draconicevolution.init.DEContent;
import com.jerry.main.common.registries.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Extends only Draconic Evolution's three crystal block entity types with their
 * matching chaotic crystal block.
 */
@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {

    @Inject(method = "isValid", at = @At("HEAD"), cancellable = true)
    private void chaoticEnergyCrystal$acceptMatchingCrystal(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        BlockEntityType<?> type = (BlockEntityType<?>) (Object) this;

        if ((type == DEContent.TILE_IO_CRYSTAL.get() && state.is(ModBlocks.CHAOTIC_IO_CRYSTAL.get()))
                || (type == DEContent.TILE_RELAY_CRYSTAL.get() && state.is(ModBlocks.CHAOTIC_RELAY_CRYSTAL.get()))
                || (type == DEContent.TILE_WIRELESS_CRYSTAL.get() && state.is(ModBlocks.CHAOTIC_WIRELESS_CRYSTAL.get()))) {
            cir.setReturnValue(true);
        }
    }
}
