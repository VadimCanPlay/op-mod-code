
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opmod.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.KeyMapping;

import net.mcreator.opmod.network.ImmortalGUIMessage;
import net.mcreator.opmod.OpModMod;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import com.mojang.blaze3d.platform.InputConstants;

public class OpModModKeyMappings {
	public static class OpModModKeyMapping extends KeyMapping {
		private boolean isDownOld;

		public OpModModKeyMapping(String string, int i, String string2) {
			super(string, InputConstants.Type.KEYSYM, i, string2);
		}

		public int action() {
			if (isDownOld != isDown() && isDown()) {
				isDownOld = isDown();
				return 1;
			} else if (isDownOld != isDown() && !isDown()) {
				isDownOld = isDown();
				return 2;
			}
			isDownOld = isDown();
			return 0;
		}
	}

	public static OpModModKeyMapping IMMORTAL_GUI = (OpModModKeyMapping) KeyBindingHelper.registerKeyBinding(new OpModModKeyMapping("key.op_mod.immortal_gui", GLFW.GLFW_KEY_UNKNOWN, "key.categories.ui"));

	public static void load() {
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			int IMMORTAL_GUIaction = IMMORTAL_GUI.action();
			if (IMMORTAL_GUIaction == 1) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_gui"), new ImmortalGUIMessage(true, false));
			} else if (IMMORTAL_GUIaction == 2) {
				ClientPlayNetworking.send(new ResourceLocation(OpModMod.MODID, "immortal_gui"), new ImmortalGUIMessage(false, true));
			}
		});
	}
}
