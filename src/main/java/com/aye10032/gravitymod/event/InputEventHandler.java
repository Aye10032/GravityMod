package com.aye10032.gravitymod.event;

import com.aye10032.gravitymod.init.EffectRegister;
import com.aye10032.gravitymod.utils.Reference;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;

import java.util.Random;

import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class InputEventHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.hasEffect(EffectRegister.WEIGHTLESS.get())) {
            if (event.getKey() == InputConstants.getKey("key.keyboard.space").getValue() && !player.isOnGround()) {
                player.jumpFromGround();
            }
        }
    }

    public static void registerEvents() {
        EVENT_BUS.register(InputEventHandler.class);
    }

}
