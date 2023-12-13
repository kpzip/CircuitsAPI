package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.ConnectionPointPair;

public interface Component {
	
	int nodeCount();
	
	int connectionCount();
	
	ConnectionPointPair[] connections();
	
	//current dependence, voltage dependence, and constant dependence for each connection
	double[] constraints();
	
	void updateCurrent(double[] currents);
	
	default void differential(double dt) {};

	void reset();
}
