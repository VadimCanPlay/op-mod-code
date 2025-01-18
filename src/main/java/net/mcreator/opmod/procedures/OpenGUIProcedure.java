package net.mcreator.opmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.opmod.world.inventory.ImmortalMenu;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;

import io.netty.buffer.Unpooled;

public class OpenGUIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			if (entity instanceof ServerPlayer _ent) {
				_ent.openMenu(new ExtendedScreenHandlerFactory() {
					final BlockPos _pos = BlockPos.containing(x, y, z);

					@Override
					public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
						buf.writeBlockPos(_pos);
					}

					@Override
					public Component getDisplayName() {
						return Component.literal("Immortal");
					}

					@Override
					public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
						return new ImmortalMenu(syncId, inv, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_pos));
					}
				});
			}
		}
	}
}
