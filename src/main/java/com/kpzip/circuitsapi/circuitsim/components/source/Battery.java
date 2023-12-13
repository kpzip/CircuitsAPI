package com.kpzip.circuitsapi.circuitsim.components.source;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.circuitsim.components.Abstract2NodeComponent;

public class Battery extends Abstract2NodeComponent {

	private final double emf;
	
	public Battery(Circuit.ConnectionPoint annode, Circuit.ConnectionPoint cathode, final double emf) {
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
		//Return -emf if the battery is in reverse
		return isReversed() ? emf : -emf;
	}
	
	public double getEmf() {
		return emf;
	}
	
}
