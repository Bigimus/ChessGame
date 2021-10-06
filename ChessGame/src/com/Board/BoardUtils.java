package com.Board;

public class BoardUtils {
	
	public static final boolean[] FIRST_COLUMN = null;
	public static final boolean[] SECOND_COLUMN = null;
	public static final boolean[] SEVENTH_COLUMN = null;
	public static final boolean[] EIGHTH_COLUMN = null;

	private BoardUtils() {
		throw new RuntimeException(":(");
	}
	
	public static boolean isValidTileCoord(int coord) {
		return coord >= 0 && coord < 64;
	}
}
