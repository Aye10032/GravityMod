package com.aye10032.gravitymod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class AntiGravityBlock extends Block {
    public AntiGravityBlock(Properties pProperties) {
        super(pProperties);
    }

    public AntiGravityBlock(){
        super(Properties.of(Material.HEAVY_METAL)
                .lightLevel((s) -> 15)
                .strength(1.5f)
                .sound(SoundType.STONE)
                .noCollission());
    }
}
