package org.usfirst.team2412.scouting;

public class ArrayUtil {

	private ArrayUtil() {}
	
	public static int find(String[] str, String find) {
		for (int i = 0; i < str.length; i ++) {
			if (str[i].equals(find)) return i;
		}
		return -1;
	}

}
