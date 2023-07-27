package com.aye10032.gravitymod.tiles;

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

    boolean isActive = true;

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
        return RANGE;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, AntiGravityTile tile) {
        if (!level.isClientSide() && tile.isActive) {
            tile.timer++;
            if (tile.timer > 20) {
                tile.timer = 0;

                // only do this once per second
                tile.lowGravity();
            }
        }
    }

    private void lowGravity() {
        BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
        BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
        AABB box = new AABB(topCorner, bottomCorner);

        List<Entity> entities = this.level.getEntities(null, box);
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
        super.saveAdditional(pTag);
        pTag.putBoolean("active", this.isActive);
        pTag.putInt("range", this.RANGE);
    }
}
