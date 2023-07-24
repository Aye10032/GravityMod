package com.aye10032.gravitymod.item;

import com.aye10032.gravitymod.client.AntiGravityGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ControllerItem extends Item {
    public ControllerItem(Properties pProperties) {
        super(pProperties);
    }

    public ControllerItem(){
        super(new Item.Properties()
                .tab(AntiGravityGroup.instance)
                .stacksTo(1)
                .rarity(Rarity.RARE));
    }

}
