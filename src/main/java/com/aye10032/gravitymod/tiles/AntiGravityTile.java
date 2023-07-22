package com.aye10032.gravitymod.tiles;

import com.aye10032.gravitymod.init.TileRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class AntiGravityTile extends TileBase {

    public AntiGravityTile(BlockPos pPos, BlockState pBlockState) {
        super(TileRegistry.ANTI_GRAVITY_BLOCK.get(), pPos, pBlockState);
    }
}
