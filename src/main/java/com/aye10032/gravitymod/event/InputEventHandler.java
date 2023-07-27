package com.aye10032.gravitymod.event;

import com.aye10032.gravitymod.init.EffectRegister;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


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
