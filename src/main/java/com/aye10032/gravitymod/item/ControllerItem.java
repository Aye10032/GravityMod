package com.aye10032.gravitymod.item;

import com.aye10032.gravitymod.client.AntiGravityGroup;
import com.aye10032.gravitymod.tiles.AntiGravityTile;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Objects;

public class ControllerItem extends Item {
    public ControllerItem(Properties pProperties) {
        super(pProperties);
    }

    public ControllerItem() {
        super(new Item.Properties()
                .tab(AntiGravityGroup.instance)
                .stacksTo(1)
                .rarity(Rarity.RARE));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        InteractionHand hand = pContext.getHand();
        BlockPos pos = pContext.getClickedPos();

        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            BlockEntity tile = level.getBlockEntity(pos);
            if (tile instanceof AntiGravityTile && Objects.requireNonNull(player).isShiftKeyDown()) {
                ((AntiGravityTile) tile).addRange(10);
                player.sendMessage(
                        new TranslatableComponent("info.gravity_mod.update_range",
                                ((AntiGravityTile) tile).getRANGE()), null);
            }
        }
        return super.useOn(pContext);
    }
}
