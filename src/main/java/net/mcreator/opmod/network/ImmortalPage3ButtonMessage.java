
package net.mcreator.opmod.network;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.opmod.world.inventory.ImmortalPage3Menu;
import net.mcreator.opmod.procedures.PrevPage3Procedure;
import net.mcreator.opmod.procedures.GmsurProcedure;
import net.mcreator.opmod.procedures.GmspeProcedure;
import net.mcreator.opmod.procedures.GmcProcedure;
import net.mcreator.opmod.procedures.GmaProcedure;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class ImmortalPage3ButtonMessage extends FriendlyByteBuf {
	public ImmortalPage3ButtonMessage(int buttonID, int x, int y, int z) {
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
			HashMap guistate = ImmortalPage3Menu.guistate;
			if (buttonID == 0) {

				PrevPage3Procedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 1) {

				GmsurProcedure.execute(entity);
			}
			if (buttonID == 2) {

				GmcProcedure.execute(entity);
			}
			if (buttonID == 3) {

				GmaProcedure.execute(entity);
			}
			if (buttonID == 4) {

				GmspeProcedure.execute(entity);
			}
		});
	}
}
