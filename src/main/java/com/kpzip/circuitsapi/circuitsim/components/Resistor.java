package com.kpzip.circuitsapi.circuitsim.components;

import com.kpzip.circuitsapi.util.Node;

public class Resistor implements IComponent{

	//Resistance in Ohms
	private double resistance = 0;
	
	private Node n1, n2;
	
	public Resistor(Node n1, Node n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public double[] getConstraints(Node node1, Node node2) {
		return new double [] {1.0d, -resistance, 0.0d} ;
	}
	
	

}
