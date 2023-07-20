package com.aye10032.gravitymod.client;

import com.aye10032.gravitymod.block.AntiGravityBlock;
import com.aye10032.gravitymod.init.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AntiGravityGroup extends CreativeModeTab {

    public AntiGravityGroup(int pId, String pLangId) {
        super(pId, pLangId);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.ANTI_GRAVITY_BLOCK.get());
    }

    public static final AntiGravityGroup instance = new AntiGravityGroup(CreativeModeTab.TABS.length, "anti gravity mod");
}
