package com.kpzip.circuitsapi.circuitsim;

import java.util.List;
import java.util.TreeSet;

import com.kpzip.circuitsapi.circuitsim.components.Component;

public class Circuit {
	
	private TreeSet<Node> nodes;
	private List<Component> components;
	
	private void simulationStep(double dt) {
		
		int numVoltages = nodes.size();
		int numCurrents = components.stream().mapToInt((c) -> c.connectionCount()).sum();
		int numToSolveFor = numVoltages + numCurrents;
		
		//The matrix representing the coefficients in the system
		double [] [] matrix = new double[numToSolveFor] [numToSolveFor];
		
		//The vector representing the vector (The constants in each equation)
		double [] constants = new double[numToSolveFor];
		
		//enter values for component constraints
		for (Component c : components) {
			double[] coefficients = new double[numToSolveFor];
			NodePair[] connections = c.connections();
			double[] constraints = c.constraints();
		}
		
		//enter values for Kirchhoff's junction laws
		
		components.forEach((c) -> c.differential(dt));
	}
	
	public class Node implements Comparable<Node> {
		
		//id 0 is ground, negative is not part of the circuit
		private final int id;
		
		private double voltage = 0;
		
		private Node(int id) {
			this.id = id;
		}
		
		public double getVoltage() {
			return voltage;
		}

		public void setVoltage(double voltage) {
			this.voltage = voltage;
		}
		
		public int getId() {
			return id;
		}

		@Override
		public int compareTo(Node o) {
			return this.id - o.id;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Node o) return o.id == this.id;
			return false;
		}

	}

}
