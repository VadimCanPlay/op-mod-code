
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opmod.init;

import net.mcreator.opmod.command.DupeCommand;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class OpModModCommands {
	public static void load() {
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, environment) -> {
			DupeCommand.register(dispatcher, commandBuildContext, environment);
		});
	}
}
