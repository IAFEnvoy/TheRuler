package com.iafenvoy.ruler.mixin;

import com.google.gson.JsonPrimitive;
import com.iafenvoy.ruler.GameRuleConfig;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.GameRuleCommand;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRuleCommand.class)
public class GameRuleCommandMixin {
    @Inject(method = "executeSet", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules$Rule;set(Lcom/mojang/brigadier/context/CommandContext;Ljava/lang/String;)V"), cancellable = true)
    private static <T extends GameRules.Rule<T>> void onSetGameRule(CommandContext<ServerCommandSource> context, GameRules.Key<T> key, CallbackInfoReturnable<Integer> cir) {
        JsonPrimitive primitive = GameRuleConfig.INSTANCE.getData(key.getName());
        if (primitive != null) {
            context.getSource().sendFeedback(() -> Text.literal("This game rule has been locked by The Ruler, unlock it by removing corresponding key in config."), false);
            cir.setReturnValue(0);
        }
    }
}
