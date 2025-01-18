
package net.mcreator.opmod.network;

import net.minecraft.world.level.Level;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.opmod.world.inventory.Immortal2Menu;
import net.mcreator.opmod.procedures.PrevPageProcedure;
import net.mcreator.opmod.procedures.OpenGUI3Procedure;
import net.mcreator.opmod.procedures.KillProcedure;
import net.mcreator.opmod.procedures.FlyONProcedure;
import net.mcreator.opmod.procedures.FlyOFFProcedure;
import net.mcreator.opmod.procedures.ClearProcedure;

import net.fabricmc.fabric.api.networking.v1.PacketSender;

import java.util.HashMap;

import io.netty.buffer.Unpooled;

public class Immortal2ButtonMessage extends FriendlyByteBuf {
	public Immortal2ButtonMessage(int buttonID, int x, int y, int z) {
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
			HashMap guistate = Immortal2Menu.guistate;
			if (buttonID == 0) {

				FlyONProcedure.execute(entity);
			}
			if (buttonID == 1) {

				FlyOFFProcedure.execute(entity);
			}
			if (buttonID == 2) {

				PrevPageProcedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 3) {

				OpenGUI3Procedure.execute(world, x, y, z, entity);
			}
			if (buttonID == 4) {

				ClearProcedure.execute(entity);
			}
			if (buttonID == 5) {

				KillProcedure.execute(entity);
			}
		});
	}
}
