package net.fabricmc.example.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.ExampleMod;
import net.minecraft.client.input.KeyboardInput;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(KeyboardInput.class)
public class ExampleMixin {

	@Redirect(method = "tick", at = @At(
			value = "FIELD",
			target = "net/minecraft/client/input/KeyboardInput.pressingForward:Z",
			opcode = Opcodes.GETFIELD,
			ordinal = 0))
	private boolean onPressingForward(KeyboardInput input) {
		input.pressingForward = input.pressingForward;
		return input.pressingForward;
	}

	@Redirect(method = "tick", at = @At(
			value = "FIELD",
			target = "net/minecraft/client/input/KeyboardInput.pressingBack:Z",
			opcode = Opcodes.GETFIELD,
			ordinal = 0))
	private boolean onPressingBack(KeyboardInput input) {
		input.pressingBack = input.pressingBack;
		return input.pressingBack;
	}

	@Redirect(method = "tick", at = @At(
			value = "FIELD",
			target = "net/minecraft/client/input/KeyboardInput.pressingLeft:Z",
			opcode = Opcodes.GETFIELD,
			ordinal = 0))
	private boolean onPressingLeft(KeyboardInput input) {
		input.pressingLeft = input.pressingLeft;
		return input.pressingLeft;
	}

	@Redirect(method = "tick", at = @At(
			value = "FIELD",
			target = "net/minecraft/client/input/KeyboardInput.pressingRight:Z",
			opcode = Opcodes.GETFIELD,
			ordinal = 0))
	private boolean onPressingRight(KeyboardInput input) {
		input.pressingRight = input.pressingRight;
		return input.pressingRight;
	}

}