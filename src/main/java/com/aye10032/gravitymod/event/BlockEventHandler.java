package com.aye10032.gravitymod.event;

import com.aye10032.gravitymod.block.AntiGravityBlock;
import com.aye10032.gravitymod.init.BlockRegistry;
import com.aye10032.gravitymod.utils.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.common.MinecraftForge.EVENT_BUS;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockEventHandler {

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock event) {
//        if (event.getWorld() != null) {
//            if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof AntiGravityBlock) {
//
//                assert Minecraft.getInstance().player != null;
//                Minecraft.getInstance().player.sendMessage(new TextComponent("Hello"), null);
//            }
//        }
    }

    public static void registerEvents() {
        EVENT_BUS.register(BlockEventHandler.class);
    }

}
