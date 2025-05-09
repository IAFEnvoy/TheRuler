package com.iafenvoy.ruler;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public enum GameRuleConfig implements SynchronousResourceReloader {
    INSTANCE;
    private static final String PATH = "./config/the_ruler.json";
    private JsonObject gameRuleMap = null;

    @Override
    public void reload(ResourceManager manager) {
        try {
            FileInputStream stream = new FileInputStream(PATH);
            InputStreamReader reader = new InputStreamReader(stream);
            gameRuleMap = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            TheRuler.LOGGER.error("Failed to read file {}", PATH, e);
            try {
                FileUtils.write(new File(PATH), "{}", StandardCharsets.UTF_8);
            } catch (IOException ex) {
                TheRuler.LOGGER.error("Failed to write file {}", PATH, ex);
            }
            gameRuleMap = new JsonObject();
        }
    }

    @Nullable
    public JsonPrimitive getData(String key) {
        if (gameRuleMap == null) this.reload(null);
        try {
            if (gameRuleMap.has(key)) return gameRuleMap.getAsJsonPrimitive(key);
        } catch (Exception e) {
            TheRuler.LOGGER.error("Cannot read key {}", key, e);
        }
        return null;
    }
}
