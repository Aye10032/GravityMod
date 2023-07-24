package com.aye10032.gravitymod.init;

import com.aye10032.gravitymod.client.AntiGravityGroup;
import com.aye10032.gravitymod.item.ControllerItem;
import com.aye10032.gravitymod.utils.Reference;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static final RegistryObject<Item> CONTROLLER = ITEMS.register("controller", ControllerItem::new);
    public static final RegistryObject<Item> ANTI_GRAVITY_BLOCK = ITEMS.register("anti_gravity_block",
            () -> new BlockItem(BlockRegistry.ANTI_GRAVITY_BLOCK.get(), new Item.Properties().tab(AntiGravityGroup.instance)));

    public static void registerItem() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
