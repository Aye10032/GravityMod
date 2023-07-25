package com.aye10032.gravitymod.block;

import com.aye10032.gravitymod.init.TileRegistry;
import com.aye10032.gravitymod.tiles.AntiGravityTile;
import com.aye10032.gravitymod.utils.TickerUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class AntiGravityBlock extends Block implements EntityBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public AntiGravityBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(LIT, false));
    }

    public AntiGravityBlock(){
        super(Properties.of(Material.GLASS, MaterialColor.DIAMOND)
                .strength(50f, 20f)
                .sound(SoundType.GLASS)
                .friction(1f)
                .noOcclusion()
                .lightLevel((bState)-> bState.getValue(LIT) ? 15 : 0));
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder.add(LIT));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND){
            BlockEntity tile = pLevel.getBlockEntity(pPos);
            if (tile instanceof AntiGravityTile){
                ((AntiGravityTile) tile).toggle();

                pLevel.setBlock(pPos, pState.setValue(LIT, ((AntiGravityTile) tile).getActive()), 2);
                pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new AntiGravityTile(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return TickerUtils.getTicker(pBlockEntityType, TileRegistry.ANTI_GRAVITY_BLOCK.get(), AntiGravityTile::tick);
    }
}
