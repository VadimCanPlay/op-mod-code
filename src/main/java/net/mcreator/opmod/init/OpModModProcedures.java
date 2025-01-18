
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opmod.init;

import net.mcreator.opmod.procedures.PrevPageProcedure;
import net.mcreator.opmod.procedures.PrevPage3Procedure;
import net.mcreator.opmod.procedures.OpenGUIProcedure;
import net.mcreator.opmod.procedures.OpenGUI3Procedure;
import net.mcreator.opmod.procedures.OPProcedure;
import net.mcreator.opmod.procedures.NextPageProcedure;
import net.mcreator.opmod.procedures.KillProcedure;
import net.mcreator.opmod.procedures.ImmONProcedure;
import net.mcreator.opmod.procedures.ImmOFFProcedure;
import net.mcreator.opmod.procedures.GodModeProcedure;
import net.mcreator.opmod.procedures.GodModeOFFProcedure;
import net.mcreator.opmod.procedures.GmsurProcedure;
import net.mcreator.opmod.procedures.GmspeProcedure;
import net.mcreator.opmod.procedures.GmcProcedure;
import net.mcreator.opmod.procedures.GmaProcedure;
import net.mcreator.opmod.procedures.GetGearProcedure;
import net.mcreator.opmod.procedures.FlyONProcedure;
import net.mcreator.opmod.procedures.FlyOFFProcedure;
import net.mcreator.opmod.procedures.DupeCommandProcedure;
import net.mcreator.opmod.procedures.ClearProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class OpModModProcedures {
	public static void load() {
		new OpenGUIProcedure();
		new ImmONProcedure();
		new ImmOFFProcedure();
		new OPProcedure();
		new GetGearProcedure();
		new PrevPageProcedure();
		new FlyONProcedure();
		new FlyOFFProcedure();
		new NextPageProcedure();
		new GodModeProcedure();
		new GodModeOFFProcedure();
		new OpenGUI3Procedure();
		new PrevPage3Procedure();
		new GmcProcedure();
		new GmsurProcedure();
		new GmaProcedure();
		new GmspeProcedure();
		new KillProcedure();
		new ClearProcedure();
		new DupeCommandProcedure();
	}
}
