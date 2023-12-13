package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.Circuit.ConnectionPoint;

public class Capacitor extends Abstract2NodeComponent {
	
	private final double capacitance;
	
	private double charge;

	//Capacitance is in Farads
	public Capacitor(ConnectionPoint first, ConnectionPoint second, final double capacitance) {
		super(first, second);
		this.capacitance = capacitance;
	}

	@Override
	public double currentDependence() {
		return 0;
	}

	@Override
	public double voltageDependence() {
		return 1.0d;
	}

	@Override
	public double constantDependence() {
		return charge/capacitance;
	}
	
	public double getCapacitance() {
		return capacitance;
	}
	
	@Override
	public void differential(double dt) {
		this.charge += this.getCurrent() * dt;
	}
	
	@Override
	public void reset() {
		this.charge = 0;
		super.reset();
	}

}
