package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.Circuit.Node;
import com.kpzip.circuitsapi.circuitsim.NodePair;

public abstract class Abstract2NodeComponent implements Component {

	protected Node first;
	protected Node second;
	
	protected double current = 0;
	
	public Abstract2NodeComponent(Node first, Node second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public final int nodeCount() {
		return 2;
	}
	
	@Override
	public final int connectionCount() {
		return 1;
	}
	
	public abstract double currentDependence();
	
	public abstract double voltageDependence();
	
	public abstract double constantDependence();
	
	@Override
	public double[] constraints() {
		return new double[] {currentDependence(), voltageDependence(), constantDependence()};
	}
	
	@Override
	public final NodePair[] connections() {
		return new NodePair[] {new NodePair(first, second)};
	}
	
	@Override
	public void reset() {
		current = 0;
	}
	
	@Override
	public void updateCurrent(double[] currents) {
		current = currents[0];
	}
	
	public double getCurrent() {
		return current;
	}

}
