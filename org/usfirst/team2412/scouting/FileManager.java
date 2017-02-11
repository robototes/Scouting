package org.usfirst.team2412.scouting;

import java.io.File;
import java.io.PrintStream;

public class FileManager {

	public static final String COMPETITION;
	public static final File VARIABLE_DEFINITIONS;
	public static final File TEAM_DATA;

	static {
		COMPETITION = "Steamworks";
		VARIABLE_DEFINITIONS = new File(System.getProperty("user.home") + "/Robototes/Scouting".replace('/', File.separatorChar) + COMPETITION + ".vars");
		TEAM_DATA = new File(System.getProperty("user.home")+"/Robototes/Scouting".replace('/', File.separatorChar) + COMPETITION + ".game");
		checkFiles();
	}
	
	private FileManager() {
	}



	private static void checkFiles() {
		try {
			if (!VARIABLE_DEFINITIONS.exists()) {
				VARIABLE_DEFINITIONS.getParentFile().mkdirs();
				VARIABLE_DEFINITIONS.createNewFile();
				
				PrintStream ps = new PrintStream(VARIABLE_DEFINITIONS);
				ps.println("{}");
				ps.close();
			}
			if (!TEAM_DATA.exists()) {
				TEAM_DATA.getParentFile().mkdirs();
				TEAM_DATA.createNewFile();
				
				PrintStream ps = new PrintStream(TEAM_DATA);
				ps.println("{}");
				ps.close();
			}
		} catch (Exception e) {
			System.err.println("Couldn't create the save files.");
			e.printStackTrace();
		}
	}

}
