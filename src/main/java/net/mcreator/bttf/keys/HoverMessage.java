package net.mcreator.bttf.keys;


import net.mcreator.bttf.custom.State;
import net.mcreator.bttf.entity.DMCEntity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.bttf.BttfMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HoverMessage {
    int type, pressedms;

    public HoverMessage(int type, int pressedms) {
        this.type = type;
        this.pressedms = pressedms;
    }

    public HoverMessage(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedms = buffer.readInt();
    }

    public static void buffer(HoverMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedms);
    }

    public static void handler(HoverMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            pressAction(context.getSender(), message.type, message.pressedms);
        });
        context.setPacketHandled(true);
    }

    public static void pressAction(Player entity, int type, int pressedms) {
        Level world = entity.level;
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(entity.blockPosition()))
            return;
        if (type == 0) {

            if(entity.getVehicle() instanceof DMCEntity en)
            {
                if(en.getState() == State.GROUND)
                {
                    en.setState(State.ABOUT_TO_HOVER);
                }
                if(en.getState() == State.HOVER)
                {
                    en.setState(State.ABOUT_TO_GROUND);
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        BttfMod.addNetworkMessage(HoverMessage.class, HoverMessage::buffer, HoverMessage::new, HoverMessage::handler);
    }
}

