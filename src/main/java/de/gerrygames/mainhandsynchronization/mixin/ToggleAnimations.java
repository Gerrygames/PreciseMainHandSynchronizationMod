package de.gerrygames.mainhandsynchronization.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class ToggleAnimations {
    @Inject(method="updateWalkAnimation", at = @At("HEAD"), cancellable = true)
    private void injected(float f, CallbackInfo ci) {
        if (((LivingEntity) (Object) this) instanceof Player) {
            ci.cancel();
        }
    }
}
