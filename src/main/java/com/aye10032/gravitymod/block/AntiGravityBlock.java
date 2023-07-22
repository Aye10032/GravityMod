package com.aye10032.gravitymod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

public class AntiGravityBlock extends Block implements EntityBlock {
    public AntiGravityBlock(Properties pProperties) {
        super(pProperties);
    }

    public AntiGravityBlock(){
        super(Properties.of(Material.GLASS, MaterialColor.DIAMOND)
                .lightLevel((s) -> 2)
                .strength(50f, 20f)
                .sound(SoundType.GLASS)
                .friction(1f)
                .noOcclusion());
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}
