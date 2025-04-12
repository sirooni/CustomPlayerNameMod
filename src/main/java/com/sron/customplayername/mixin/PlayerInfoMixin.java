package com.sron.customplayername.mixin;

import com.mojang.authlib.GameProfile;
import com.sron.customplayername.CustomNameRegistry;
import java.util.UUID;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInfo.class)
public class PlayerInfoMixin {

  @Inject(method = "getTabListDisplayName", at = @At("HEAD"), cancellable = true)
  public void overrideTabListDisplayName(CallbackInfoReturnable<Component> cir) {
    PlayerInfo self = (PlayerInfo) (Object) this;
    GameProfile profile = self.getProfile();
    UUID id = profile.getId();
    String name = profile.getName();
    String customName = CustomNameRegistry.getNameFor(id, name);
    if (customName != null) {
      cir.setReturnValue(Component.literal(customName));
    }
  }
}
