package com.kpzip.circuitsapi.circuitsimulator;

// info about each row/column of the matrix for simplification purposes
    public class RowInfo {
	public static final int ROW_NORMAL = 0;  // ordinary value
	public static final int ROW_CONST  = 1;  // value is constant
	public static final int ROW_EQUAL  = 2;  // value is equal to another value
	public int nodeEq;
	public int type;
	public int mapCol;
	public int mapRow;
	public double value;
	public boolean rsChanges; // row's right side changes
	public boolean lsChanges; // row's left side changes
	public boolean dropRow;   // row is not needed in matrix
	public RowInfo() { type = ROW_NORMAL; }
    }
