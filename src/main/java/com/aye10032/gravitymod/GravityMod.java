package com.aye10032.gravitymod;

import com.aye10032.gravitymod.event.InputEventHandler;
import com.aye10032.gravitymod.event.RenderEventHandler;
import com.aye10032.gravitymod.init.BlockRegistry;
import com.aye10032.gravitymod.init.EffectRegister;
import com.aye10032.gravitymod.init.TileRegistry;
import com.aye10032.gravitymod.init.ItemRegistry;
import com.aye10032.gravitymod.utils.Reference;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reference.MODID)
public class GravityMod {

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GravityMod() {
        BlockRegistry.registerBlocks();
        ItemRegistry.registerItem();
        TileRegistry.registerTiles();
        EffectRegister.registerEffects();

        RenderEventHandler.registerEvents();
        InputEventHandler.registerEvents();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
