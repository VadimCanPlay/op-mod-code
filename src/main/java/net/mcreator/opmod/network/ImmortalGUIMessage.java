
package net.mcreator.opmod.network;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.opmod.procedures.OpenGUIProcedure;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import io.netty.buffer.Unpooled;

public class ImmortalGUIMessage extends FriendlyByteBuf {
	public ImmortalGUIMessage(boolean pressed, boolean released) {
		super(Unpooled.buffer());
		writeBoolean(pressed);
		writeBoolean(released);
	}

	public static void apply(MinecraftServer server, ServerPlayer entity, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
		boolean pressed = buf.readBoolean();
		boolean released = buf.readBoolean();
		server.execute(() -> {
			Level world = entity.level();
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			// security measure to prevent arbitrary chunk generation
			if (!world.hasChunkAt(entity.blockPosition()))
				return;
			if (pressed) {

				OpenGUIProcedure.execute(world, x, y, z, entity);
			}
		});
	}
}
