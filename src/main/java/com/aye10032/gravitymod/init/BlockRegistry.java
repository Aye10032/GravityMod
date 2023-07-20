package com.aye10032.gravitymod.init;

import com.aye10032.gravitymod.block.AntiGravityBlock;
import com.aye10032.gravitymod.utils.Reference;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MODID);

    public static final RegistryObject<AntiGravityBlock> ANTI_GRAVITY_BLOCK = BLOCKS.register("anti_gravity_block", AntiGravityBlock::new);

    public static void registerBlocks() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
