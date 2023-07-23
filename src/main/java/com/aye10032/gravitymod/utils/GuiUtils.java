package com.aye10032.gravitymod.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

public class GuiUtils {

    @Nullable
    public static Screen getCurrentScreen()
    {
        return Minecraft.getInstance().screen;
    }

}
