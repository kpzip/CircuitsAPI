package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.util.Node;

public interface IComponent {
	
	
	/**
	 * aV + bI = c
	 * @return constants a, b, and c in that order
	 */
	public double[] getConstraints(Node node1, Node node2);
	
}
