package com.iafenvoy.ruler.neoforge;

import com.iafenvoy.ruler.GameRuleConfig;
import com.iafenvoy.ruler.TheRuler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

@Mod(TheRuler.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public final class TheRulerNeoForge {
    public TheRulerNeoForge() {
        // Run our common setup.
    }

    @SubscribeEvent
    public static void onReload(AddReloadListenerEvent event) {
        event.addListener(GameRuleConfig.INSTANCE);
    }
}
