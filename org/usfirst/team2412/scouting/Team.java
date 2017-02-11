package org.usfirst.team2412.scouting;

import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

public class Team {

	public static final String
		TEAMNUMBER = "teamNumber",
		TEAMNAME = "teamName",
		WINS = "wins",
		LOSSES = "loss",
		STRATEGY = "StrategyDescription",
		CANCLIMB = "canClimb",
		RATINGS = "ratings",
		OVERALLRATING = "overallRating",
		OTHER = "otherComments";

	public static final int
		RATINGBALLPICKUP = 0,
		RATINGGEARPICKUP = 1,
		RATINGCLIMBING = 2,
		RATINGDEFENSE = 3;
	
	public JSONObject obj;

	
	/**
	 * Configuration:
	 * 
	 * "teams":[
	 * 	{
	 * 		"teamNumber":2412,
	 * 		"teamName":"Robototes",
	 * 		"wins":infinity,
	 * 		"loss":-infinity, // ok, infinity should be a number
	 * 		"StrategyDescription":"this team picks up gears and wins well",
	 * 		"canClimb":true, //hopefully
	 * 		"ratings":[ // int array
	 * 			0, // ability to pick up balls
	 * 			10, // ability to pick up gears
	 * 			7, // ability to climb
	 * 			4 // Ability to be defensive. These are made up numbers BTW. May not be on scale 1-10.
	 * 		],
	 * 		"overallRating":101.422412, // out of 100 for precision purposes? This number SHOULD be able to be overwritten
	 * 		"otherComments":"This team is awesome! Go 2412!"
	 * 	},
	 * 	{
	 * 		...
	 * 	},
	 * 	etc
	 * ]
	 */
	private void init() {
		if (obj == null)
			obj = new JSONObject();
		if (obj.optInt(TEAMNUMBER, Integer.MIN_VALUE) == Integer.MIN_VALUE) {
			obj.put(TEAMNUMBER, 0);
		}
		if (obj.optInt(WINS, Integer.MIN_VALUE) == Integer.MIN_VALUE) {
			obj.put(WINS, 0);
		}
		if (obj.optInt(LOSSES, Integer.MIN_VALUE) == Integer.MIN_VALUE) {
			obj.put(LOSSES, 0);
		}
		if (obj.optDouble(OVERALLRATING, Integer.MIN_VALUE) == Integer.MIN_VALUE) {
			obj.put(OVERALLRATING, 0d);
		}
		if (obj.optString(TEAMNAME) == null) {
			obj.put(TEAMNAME, "This team doesn't have a name. ;(");
		}
		if (obj.optString(STRATEGY) == null) {
			obj.put(STRATEGY, "This team's strategy: Plan B (AKA no strategy)");
		}
		if (obj.optString(OTHER) == null) {
			obj.put(OTHER, "N/A");
		}
		if (obj.optJSONArray(RATINGS) == null) {
			obj.put(RATINGS, new JSONArray().put(0, Arrays.asList(new double[] {0d, 0d, 0d, 0d})));
		}
		if (!obj.optBoolean(CANCLIMB, false)) {
			obj.put(CANCLIMB, false);
		}

	}

	public Team() {
		obj = new JSONObject();
		init();
	}

	public Team(JSONObject o) {
		obj = o;
		init();
	}

	public Team(int i) {
		obj = new JSONObject();
		obj.put(TEAMNUMBER, i);
		init();
	}

	public Team(int i, String name) {
		obj = new JSONObject();
		obj.put(TEAMNUMBER, i);
		obj.put(TEAMNAME, name);
		init();
	}

	public String getTeamName() {
		return obj.getString(TEAMNAME);
	}

	public int getTeamNumber() {
		return obj.getInt(TEAMNUMBER);
	}

	public boolean getCanClimb() {
		return obj.getBoolean(CANCLIMB);
	}

	public int getTeamWins() {
		return obj.getInt(WINS);
	}

	public int getTeamLosses() {
		return obj.getInt(LOSSES);
	}
	
	public String getTeamStrategy() {
		return obj.getString(STRATEGY);
	}
	
	public double getOverallRating() {
		return obj.getDouble(OVERALLRATING);
	}
	
	public double getBallPickupRating() {
		return obj.getJSONArray(RATINGS).getDouble(RATINGBALLPICKUP);
	}
	
	public double getGearPickupRating() {
		return obj.getJSONArray(RATINGS).getDouble(RATINGGEARPICKUP);
	}
	
	public double getClimbingRating() {
		return obj.getJSONArray(RATINGS).getDouble(RATINGCLIMBING);
	}
	
	public double getDefenseRating() {
		return obj.getJSONArray(RATINGS).getDouble(RATINGDEFENSE);
	}
	
	

}
