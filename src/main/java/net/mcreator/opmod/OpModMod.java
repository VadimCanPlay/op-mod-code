/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.mcreator.opmod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.mcreator.opmod.init.OpModModProcedures;
import net.mcreator.opmod.init.OpModModMenus;
import net.mcreator.opmod.init.OpModModKeyMappingsServer;
import net.mcreator.opmod.init.OpModModCommands;

import net.fabricmc.api.ModInitializer;

public class OpModMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "op_mod";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing OpModMod");

		OpModModProcedures.load();
		OpModModCommands.load();

		OpModModMenus.load();
		OpModModKeyMappingsServer.serverLoad();

	}
}
