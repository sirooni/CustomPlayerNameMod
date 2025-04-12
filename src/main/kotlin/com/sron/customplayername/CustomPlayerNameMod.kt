package com.sron.customplayername

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CustomPlayerNameMod.MODID)
class CustomPlayerNameMod
{
    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    companion object {
        const val MODID = "customplayername"
    }
}
