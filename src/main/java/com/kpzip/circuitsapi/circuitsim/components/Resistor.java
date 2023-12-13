package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.Circuit;

public class Resistor extends Abstract2NodeComponent {

	private final double resistance;
	
	public Resistor(Circuit.ConnectionPoint first, Circuit.ConnectionPoint second, final double resistance) {
		super(first, second);
		this.resistance = resistance;
	}

	@Override
	public double currentDependence() {
		return resistance;
	}

	@Override
	public double voltageDependence() {
		return -1;
	}
	
	@Override
	public double constantDependence() {
		return 0;
	}
	
	public double getResistance() {
		return resistance;
	}

}
