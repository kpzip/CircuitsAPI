package com.kpzip.circuitsapi.circuitsim.components.passive;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.circuitsim.components.Abstract2NodeComponent;

public class Inductor extends Abstract2NodeComponent {
	
	private final double inductance;
	
	private double flux = 0.0;

	public Inductor(Circuit.ConnectionPoint first, Circuit.ConnectionPoint second, final double inductance) {
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
