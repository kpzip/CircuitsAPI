package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.circuitsim.NodePair;

public interface Component {
	
	int nodeCount();
	
	int connectionCount();
	
	NodePair[] connections();
	
	double[] constraints();
	
	default void differential(double dt) {};

	void reset();
}
