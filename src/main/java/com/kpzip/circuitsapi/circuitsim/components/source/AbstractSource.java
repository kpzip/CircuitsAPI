package com.kpzip.circuitsapi.circuitsim.components.source;

import com.kpzip.circuitsapi.circuitsim.Circuit.ConnectionPoint;
import com.kpzip.circuitsapi.circuitsim.components.Abstract2NodeComponent;

public abstract class AbstractSource extends Abstract2NodeComponent {

	public AbstractSource(ConnectionPoint first, ConnectionPoint second) {
		super(first, second);
	}

	@Override
	public final double currentDependence() {
		return 0;
	}

	@Override
	public final double voltageDependence() {
		return 1;
	}

	@Override
	public final double constantDependence() {
		double v = getSourceVoltage();
		return isReversed() ? v : -v;
	}
	
	@Override
	public final void differential(double dt) {
		updateTime(dt);
	}
	
	//Override this for time dependent sources
	public void updateTime(double time) {
		
	}
	
	public abstract double getSourceVoltage();

}
