
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opmod.init;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.opmod.client.gui.ImmortalScreen;
import net.mcreator.opmod.client.gui.ImmortalPage3Screen;
import net.mcreator.opmod.client.gui.Immortal2Screen;

public class OpModModScreens {
	public static void load() {
		MenuScreens.register(OpModModMenus.IMMORTAL, ImmortalScreen::new);
		MenuScreens.register(OpModModMenus.IMMORTAL_2, Immortal2Screen::new);
		MenuScreens.register(OpModModMenus.IMMORTAL_PAGE_3, ImmortalPage3Screen::new);
	}
}
