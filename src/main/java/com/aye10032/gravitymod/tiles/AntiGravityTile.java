package com.aye10032.gravitymod.tiles;

import com.aye10032.gravitymod.block.AntiGravityBlock;
import com.aye10032.gravitymod.init.EffectRegister;
import com.aye10032.gravitymod.init.TileRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class AntiGravityTile extends TileBase {

    private int timer = 0;

    boolean isActive = false;

    int RANGE = 64;

    public AntiGravityTile(BlockPos pPos, BlockState pBlockState) {
        super(TileRegistry.ANTI_GRAVITY_BLOCK.get(), pPos, pBlockState);
    }


    public void toggle() {
        this.isActive = !this.isActive;
    }

    public boolean getActive() {
        return this.isActive;
    }

    public int getRANGE() {
        return RANGE * 2;
    }

    public void addRange(int value){
        if (this.RANGE == 128){
            this.RANGE = 0;
        }

        int sum = this.RANGE + value;
        this.RANGE = Math.min(sum, 128);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AntiGravityTile tile) {
        if (!level.isClientSide() && tile.isActive) {
            tile.timer++;
            if (tile.timer > 20) {
                tile.timer = 0;

                // only do this once per second
                tile.lowGravity(tile);
            }
        }
    }

    private void lowGravity(AntiGravityTile tile) {
        BlockPos topCorner = tile.worldPosition.offset(tile.RANGE, tile.RANGE, tile.RANGE);
        BlockPos bottomCorner = tile.worldPosition.offset(-tile.RANGE, -tile.RANGE, -tile.RANGE);
        AABB box = new AABB(topCorner, bottomCorner);

        List<Entity> entities = tile.level.getEntities(null, box);
        for (Entity target : entities) {
            if (target instanceof Player) {
                ((Player) target).addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 25, 2, false, false, false));
                ((Player) target).addEffect(new MobEffectInstance(MobEffects.JUMP, 25, 2, false, false, false));
                ((Player) target).addEffect(new MobEffectInstance(EffectRegister.WEIGHTLESS.get(), 25, 2, false, false, false));
            }
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.isActive = pTag.getBoolean("active");
        this.RANGE = pTag.getInt("range");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.putBoolean("active", this.isActive);
        pTag.putInt("range", this.RANGE);
        super.saveAdditional(pTag);
    }
}
