package com.kpzip.circuitsapi.circuitsim.components.passive;

import java.util.ArrayList;

import com.kpzip.circuitsapi.circuitsim.components.IComponent;
import com.kpzip.circuitsapi.util.Node;

public class Capacitor implements IComponent {

	private final double capacitance;
	
	private double charge;
	
	private Node n1, n2;
	
	public Capacitor(Node n1, Node n2, Double C) {
		this.n1 = n1;
		this.n2 = n2;
		this.capacitance = C;
	}


	@Override
	public double[] getConstraints(Node node1, Node node2) {
		return new double [] {capacitance, 0.0d, charge};
	}
	
	@Override
	public void differential(double V, double I, double dt) {
		//Euler approximation 
		charge += I * dt;
	}
	
	@Override
	public ArrayList<Node[]> getConnections() {
		ArrayList<Node[]> connections = new ArrayList<Node[]>();
		connections.add(new Node [] {n1, n2});
		return connections;
	}

}
