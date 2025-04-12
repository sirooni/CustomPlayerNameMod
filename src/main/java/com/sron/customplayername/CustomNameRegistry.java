package com.sron.customplayername;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomNameRegistry {

  private static final Map<UUID, String> customNames = new HashMap<>();

  static {
    customNames.put(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"), "テストユーザー");
  }

  public static String getNameFor(UUID id, String name) {
    return customNames.getOrDefault(id, name);
  }
}
