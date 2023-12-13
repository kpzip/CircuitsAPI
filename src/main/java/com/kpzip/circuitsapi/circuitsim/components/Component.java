package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.NodePair;

public interface Component {
	
	int nodeCount();
	
	int connectionCount();
	
	NodePair[] connections();
	
	//current dependence, voltage dependence, and constant dependence for each connection
	double[] constraints();
	
	void updateCurrent(double[] currents);
	
	default void differential(double dt) {};

	void reset();
}
