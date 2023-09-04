package de.vepexlegit.fastplacedebug.mixins;

import de.vepexlegit.fastplacedebug.FastPlace;
import de.vepexlegit.fastplacedebug.commands.FastPlaceCommand;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "runTick", at = @At("RETURN"))
    private void startGame(final CallbackInfo ci) {
        ClientCommandHandler.instance.registerCommand(new FastPlaceCommand());
    }

    @Shadow private int rightClickDelayTimer;

    @Inject(method = "runTick", at = @At("HEAD"))
    private void rightClickMouse(final CallbackInfo ci) {
        if(FastPlace.INSTANCE.isEnabled()) {
            rightClickDelayTimer = 0;
        }
    }
}
