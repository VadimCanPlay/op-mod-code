
package net.mcreator.opmod.network;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.opmod.world.inventory.ImmortalMenu;
import net.mcreator.opmod.procedures.OPProcedure;
import net.mcreator.opmod.procedures.NextPageProcedure;
import net.mcreator.opmod.procedures.ImmONProcedure;
import net.mcreator.opmod.procedures.ImmOFFProcedure;
import net.mcreator.opmod.procedures.GetGearProcedure;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class ImmortalButtonMessage extends FriendlyByteBuf {
	public ImmortalButtonMessage(int buttonID, int x, int y, int z) {
		super(Unpooled.buffer());
		writeInt(buttonID);
		writeInt(x);
		writeInt(y);
		writeInt(z);
	}

	public static void apply(MinecraftServer server, ServerPlayer entity, ServerGamePacketListenerImpl handler, FriendlyByteBuf buf, PacketSender responseSender) {
		int buttonID = buf.readInt();
		double x = buf.readInt();
		double y = buf.readInt();
		double z = buf.readInt();
		server.execute(() -> {
			Level world = entity.level();
			HashMap guistate = ImmortalMenu.guistate;
			if (buttonID == 0) {

				ImmONProcedure.execute(entity);
			}
			if (buttonID == 1) {

				ImmOFFProcedure.execute(entity);
			}
			if (buttonID == 2) {

				OPProcedure.execute(world, x, y, z);
			}
			if (buttonID == 3) {

				GetGearProcedure.execute(world, x, y, z);
			}
			if (buttonID == 4) {

				NextPageProcedure.execute(world, x, y, z, entity);
			}
		});
	}
}
