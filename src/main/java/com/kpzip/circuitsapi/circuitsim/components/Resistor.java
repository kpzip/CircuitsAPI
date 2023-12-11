package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.Circuit.Node;

public class Resistor extends Abstract2NodeComponent {

	private final double resistance;
	
	public Resistor(Node first, Node second, double resistance) {
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

}
