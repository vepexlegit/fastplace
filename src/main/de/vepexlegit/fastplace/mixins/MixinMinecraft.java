package de.vepexlegit.fastplace.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Shadow private int rightClickDelayTimer;

    @Inject(method = "runTick", at = @At("HEAD"))
    private void rightClickMouse(final CallbackInfo ci) {
        rightClickDelayTimer = 0;
    }
}
