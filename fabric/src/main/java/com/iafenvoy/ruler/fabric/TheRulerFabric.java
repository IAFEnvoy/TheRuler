package com.iafenvoy.ruler.fabric;

import com.iafenvoy.ruler.GameRuleConfig;
import com.iafenvoy.ruler.TheRuler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public final class TheRulerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return Identifier.of(TheRuler.MOD_ID, TheRuler.MOD_ID);
            }

            @Override
            public void reload(ResourceManager manager) {
                GameRuleConfig.INSTANCE.reload(manager);
            }
        });
    }
}
