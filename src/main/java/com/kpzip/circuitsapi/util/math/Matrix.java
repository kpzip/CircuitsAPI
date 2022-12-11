package com.kpzip.circuitsapi.util.math;

public class Matrix {
	
	private double [] [] data;
	
	public Matrix(int size) {
		this(size, size);
	}
	
	public Matrix(int length, int height) {
		if (length < 1 || height < 1) {
			throw new IllegalArgumentException("Matrix cannot have 0 or negative size");
		}
		data = new double [height] [length];
	}
	
	public void storeRow(int row, double [] data) {
		this.data[row] = data;
	}
	
	public double getData(int column, int row) {
		return data [row] [column];
	}

}
