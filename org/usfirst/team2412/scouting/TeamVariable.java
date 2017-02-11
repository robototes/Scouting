package org.usfirst.team2412.scouting;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONObject;

public class TeamVariable {
	
	private static HashMap<String, TeamVariable> vars = new HashMap<String, TeamVariable>();
	
	private String name;
	
	public TeamVariable(String name) {
	}
	
	public int getInt(JSONObject o) {
		return o.getInt(name);
	}
	
	public String getString(JSONObject o) {
		return o.getString(name);
	}
	
	public double getDouble(JSONObject o) {
		return o.getDouble(name);
	}
	
	public static void init() {
		try {
			Scanner sc = new Scanner(FileManager.VARIABLE_DEFINITIONS);
		} catch (Exception e) {
			Main.main(new String[] {"-setup"});
		}
		
	}

}
