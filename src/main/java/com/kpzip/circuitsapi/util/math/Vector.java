package com.kpzip.circuitsapi.util.math;

public class Vector {
	
	private double [] data;
	
	public Vector(int length) {
		data = new double [length];
	}
	
	public double getDataAt(int position) {
		return data[position];
	}
	
	public void setDataAt(int position, double data) {
		this.data[position] = data;
	}

}
