package com.aye10032.gravitymod.init;

import com.aye10032.gravitymod.effect.WeightlessEffect;
import com.aye10032.gravitymod.utils.Reference;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegister {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Reference.MODID);

    public static final RegistryObject<MobEffect> WEIGHTLESS = MOB_EFFECTS.register("weightless", WeightlessEffect::new);

    public static void registerEffects() {
        MOB_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
