package com.kpzip.circuitsapi.circuitsim.components.passive;

import java.util.ArrayList;

import com.kpzip.circuitsapi.circuitsim.components.IComponent;
import com.kpzip.circuitsapi.util.Node;

public class Resistor implements IComponent{

	//Resistance in Ohms
	private final double resistance;
	
	private Node n1, n2;
	
	public Resistor(Node n1, Node n2, Double R) {
		this.n1 = n1;
		this.n2 = n2;
		this.resistance = R;
	}

	@Override
	public double[] getConstraints(Node node1, Node node2) {
		return new double [] {1.0d, -resistance, 0.0d} ;
	}

	@Override
	public ArrayList<Node[]> getConnections() {
		ArrayList<Node[]> connections = new ArrayList<Node[]>();
		connections.add(new Node [] {n1, n2});
		return connections;
	}
	
	
	
	

}
