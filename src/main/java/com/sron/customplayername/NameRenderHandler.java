package com.sron.customplayername;

import java.util.UUID;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = CustomPlayerName.MODID, value = Dist.CLIENT)
public class NameRenderHandler {

  @SubscribeEvent
  public static void onRenderName(RenderLivingEvent.Pre<?, ?> event) {
    if (!(event.getEntity() instanceof Player player)) {
      return;
    }

    UUID id = player.getUUID();
    String name = player.getName().getString();
    String customName = CustomNameRegistry.getNameFor(id, name);
    player.setCustomName(Component.literal(customName));
    player.setCustomNameVisible(true);
  }
}
