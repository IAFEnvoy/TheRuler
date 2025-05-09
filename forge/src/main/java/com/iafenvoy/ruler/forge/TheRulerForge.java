package com.iafenvoy.ruler.forge;

import com.iafenvoy.ruler.GameRuleConfig;
import com.iafenvoy.ruler.TheRuler;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(TheRuler.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class TheRulerForge {
    public TheRulerForge() {
        // Run our common setup.
    }

    @SubscribeEvent
    public static void onReload(AddReloadListenerEvent event) {
        event.addListener(GameRuleConfig.INSTANCE);
    }
}
