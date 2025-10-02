package de.gerrygames.mainhandsynchronization.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Avatar.class)
public abstract class PlayerMixin {

	@Inject(method = "getMainArm", at = @At("RETURN"), cancellable = true)
	public void getMainArm(CallbackInfoReturnable<HumanoidArm> cir) {
		if ((Object) this instanceof Player) {
			cir.setReturnValue(Minecraft.getInstance().options.mainHand().get());
		}
	}
}