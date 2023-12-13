package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.Circuit;

public class Battery extends Abstract2NodeComponent {

	private final double emf;
	
	public Battery(Circuit.Node annode, Circuit.Node cathode, double emf) {
		super(annode, cathode);
		this.emf = emf;
	}

	@Override
	public double currentDependence() {
		return 0;
	}

	@Override
	public double voltageDependence() {
		return 1;
	}

	@Override
	public double constantDependence() {
		return emf;
	}

	

}
