package com.sron.customplayername;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;

public class CustomNameRegistry {

  private static final Map<UUID, String> customNames = new HashMap<>();

  static {
    customNames.put(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"), "テストユーザー");
  }

  public static String getNameFor(Player player) {
    return customNames.getOrDefault(player.getUUID(), player.getName().getString());
  }
}
