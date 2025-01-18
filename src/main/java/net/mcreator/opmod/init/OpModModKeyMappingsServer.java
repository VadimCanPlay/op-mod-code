
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opmod.init;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.opmod.network.ImmortalGUIMessage;
import net.mcreator.opmod.OpModMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class OpModModKeyMappingsServer {
	public static void serverLoad() {
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(OpModMod.MODID, "immortal_gui"), ImmortalGUIMessage::apply);
	}
}
