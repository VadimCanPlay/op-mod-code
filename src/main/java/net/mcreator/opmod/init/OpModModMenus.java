
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opmod.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.mcreator.opmod.world.inventory.ImmortalPage3Menu;
import net.mcreator.opmod.world.inventory.ImmortalMenu;
import net.mcreator.opmod.world.inventory.Immortal2Menu;
import net.mcreator.opmod.OpModMod;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;

public class OpModModMenus {
	public static MenuType<ImmortalMenu> IMMORTAL;
	public static MenuType<Immortal2Menu> IMMORTAL_2;
	public static MenuType<ImmortalPage3Menu> IMMORTAL_PAGE_3;

	public static void load() {
		IMMORTAL = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OpModMod.MODID, "immortal"), new ExtendedScreenHandlerType<>(ImmortalMenu::new));
		ImmortalMenu.screenInit();
		IMMORTAL_2 = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OpModMod.MODID, "immortal_2"), new ExtendedScreenHandlerType<>(Immortal2Menu::new));
		Immortal2Menu.screenInit();
		IMMORTAL_PAGE_3 = Registry.register(BuiltInRegistries.MENU, new ResourceLocation(OpModMod.MODID, "immortal_page_3"), new ExtendedScreenHandlerType<>(ImmortalPage3Menu::new));
		ImmortalPage3Menu.screenInit();
	}
}
