package com.sron.customplayername.mixin;

import com.sron.customplayername.CustomNameRegistry;
import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerDisplayNameMixin {

  @Inject(method = "getDisplayName", at = @At("HEAD"), cancellable = true)
  public void overrideDisplayName(CallbackInfoReturnable<Component> cir) {
    Player player = (Player) (Object) this;
    UUID id = player.getUUID();
    String name = player.getName().getString();
    String customName = CustomNameRegistry.getNameFor(id, name);
    if (customName != null) {
      cir.setReturnValue(Component.literal(customName));
    }
  }
}
