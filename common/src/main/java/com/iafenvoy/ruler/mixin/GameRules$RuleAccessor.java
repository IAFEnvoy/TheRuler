package com.iafenvoy.ruler.mixin;

import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.Rule.class)
public interface GameRules$RuleAccessor {
    @Invoker("deserialize")
    void deserialize(String value);
}
