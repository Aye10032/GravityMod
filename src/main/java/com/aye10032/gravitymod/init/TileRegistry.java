package com.aye10032.gravitymod.init;

import com.aye10032.gravitymod.tiles.AntiGravityTile;
import com.aye10032.gravitymod.utils.Reference;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileRegistry {

    private static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Reference.MODID);

    public static final RegistryObject<BlockEntityType<AntiGravityTile>> ANTI_GRAVITY_BLOCK = TILES.register("anti_gravity_block", () ->
            BlockEntityType.Builder.of(AntiGravityTile::new, BlockRegistry.ANTI_GRAVITY_BLOCK.get()).build(null));

    public static void registerTiles() {
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
