package net.mcreator.bttf.keys;


import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.bttf.BttfMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BttfModKeyMappings {
    public static final KeyMapping HOVER = new KeyMapping("key.bttf.hover", GLFW.GLFW_KEY_H, "key.categories.misc");

    @SubscribeEvent
    public static void registerKeyBindings(FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(HOVER);
    }

    @Mod.EventBusSubscriber({Dist.CLIENT})
    public static class KeyEventListener {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.KeyInputEvent event) {
            if (Minecraft.getInstance().screen == null) {
                if (event.getKey() == HOVER.getKey().getValue()) {
                    if (event.getAction() == GLFW.GLFW_PRESS) {
                        BttfMod.PACKET_HANDLER.sendToServer(new HoverMessage(0, 0));
                        HoverMessage.pressAction(Minecraft.getInstance().player, 0, 0);
                    }
                }
            }
        }
    }
}
