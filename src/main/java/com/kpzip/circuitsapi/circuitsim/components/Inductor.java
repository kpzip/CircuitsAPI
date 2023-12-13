package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.Circuit.ConnectionPoint;

public class Inductor extends Abstract2NodeComponent {
	
	private final double inductance;
	
	private double flux = 0.0;

	public Inductor(ConnectionPoint first, ConnectionPoint second, final double inductance) {
		super(first, second);
		this.inductance = inductance;
	}

	@Override
	public double currentDependence() {
		return 1.0;
	}

	@Override
	public double voltageDependence() {
		return 0;
	}

	@Override
	public double constantDependence() {
		return flux/inductance;
	}
	
	public double getInductance() {
		return inductance;
	}
	
	public double getFlux() {
		return flux;
	}
	
	@Override
	public void differential(double dt) {
		double difference = first.getVoltage() - second.getVoltage();
		this.flux += (!this.isReversed() ? difference : -difference) * dt;
	}
	
	@Override
	public void reset() {
		this.flux = 0;
		super.reset();
	}

}
