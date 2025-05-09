package com.iafenvoy.ruler.neoforge;

import com.iafenvoy.ruler.GameRuleConfig;
import com.iafenvoy.ruler.TheRuler;
import net.minecraft.util.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;

@Mod(TheRuler.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public final class TheRulerNeoForge {
    public TheRulerNeoForge() {
        // Run our common setup.
    }

    @SubscribeEvent
    public static void onReload(AddServerReloadListenersEvent event) {
        event.addListener(Identifier.of(TheRuler.MOD_ID, TheRuler.MOD_ID), GameRuleConfig.INSTANCE);
    }
}
