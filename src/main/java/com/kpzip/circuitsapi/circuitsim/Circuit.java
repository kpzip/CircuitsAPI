package com.kpzip.circuitsapi.circuitsim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import com.kpzip.circuitsapi.circuitsim.components.Component;
import com.kpzip.circuitsapi.util.ArrayBuilder;

public class Circuit {
	
	//Nodes should always be in ascending order with no gaps e.g. 0,1,2,3,4,5 NOT 0,2,3,5,6,7,9
	//Current is determined to flow from high id nodes to low id nodes
	private TreeSet<Node> nodes;
	private ArrayList<Component> components;
	private Node ground;
	
	public Circuit() {
		nodes = new TreeSet<Node>();
		components = new ArrayList<Component>();
		ground = new Circuit.Node(0);
		nodes.add(ground);
	}
	
	public void simulationStep(double dt) {
		
		int numVoltages = nodes.size();
		int numCurrents = components.stream().mapToInt((c) -> c.connectionCount()).sum();
		int numToSolveFor = numVoltages + numCurrents;
		
		//The matrix representing the coefficients in the system
		double [] [] matrix = new double[numToSolveFor] [numToSolveFor];
		
		//The vector representing the vector (The constants in each equation)
		double [] constants = new double[numToSolveFor];
		
		//enter values for component constraints
		int componentConnectionIndex = 0;
		for (Component c : components) {
			
			NodePair[] connections = c.connections();
			double[] constraints = c.constraints();
			
			for (int i = 0; i < connections.length; i++) {
				
				double[] coefficients = new double[numToSolveFor];
				
				//unpack connection information
				NodePair connection = connections[i];
				double currentDependence = constraints[3*i];
				double voltageDependence = constraints[3*i + 1];
				double constantDependence = constraints[3*i + 2];
				
				coefficients[componentConnectionIndex] = currentDependence;
				coefficients[numCurrents + connection.first.id] = voltageDependence;
				coefficients[numCurrents + connection.second.id] = -voltageDependence;
				constants[componentConnectionIndex] = constantDependence;
				
				matrix[componentConnectionIndex] = coefficients;
				
				componentConnectionIndex++;
			}
		}
		
		//enter values for Kirchhoff's junction laws
		int nodeIndex = numCurrents;
		for (Circuit.Node n : nodes) {
			
			double[] coefficients = new double[numToSolveFor];
			
			if (n == this.ground) {
				//add equation that says ground node is at zero voltage
				coefficients[numCurrents] = 1;
			}
			else {
				ArrayBuilder<NodePair> arr = new ArrayBuilder<NodePair>(NodePair.class, numCurrents);
				components.forEach((c) -> arr.pushArray(c.connections()));
			
				//ordered array of all connections in the circuit
				NodePair[] allConnections = arr.toArray();
			
				//make it so all of the currents flowing into the node sum up to zero
				for (int i = 0; i < allConnections.length; i++) {
					if (allConnections[i].first == n) {
						coefficients[i] = -1;
						continue;
					}
					if (allConnections[i].second == n) {
						coefficients[i] = 1;
					}
				}
			}
			matrix[nodeIndex] = coefficients;
			nodeIndex++;
			
		}
		System.out.println(Arrays.deepToString(matrix));
		System.out.println(Arrays.toString(constants));
		
		//Now the matrix is populated, time to solve!
		RealMatrix A = new Array2DRowRealMatrix(matrix, false);
		RealVector B = new ArrayRealVector(constants, false);
		DecompositionSolver solver = new LUDecomposition(A).getSolver();
		RealVector solution = solver.solve(B);
		double[] solutions = solution.toArray();
		
		//set current and voltage values
		int valPtr = 0;
		for (Component c : components) {
			int count;
			c.updateCurrent(Arrays.copyOfRange(solutions, valPtr, valPtr + (count = c.connectionCount())));
			valPtr += count;
		}
		
		for (Node n : nodes) {
			n.voltage = solutions[valPtr];
			valPtr++;
		}
		components.forEach((c) -> c.differential(dt));
	}
	
	public void addComponent(Component c) {
		components.add(c);
	}
	
	public Circuit.Node createNode() {
		Node n = new Circuit.Node();
		nodes.add(n);
		return n;
	}
	
	public Node getGround() {
		return ground;
	}
	
	public class Node implements Comparable<Node> {
		
		private static int idCounter = 1;
		
		//id 0 is ground, negative is not part of the circuit
		private final int id;
		
		private double voltage = 0;
		
		private Node(int id) {
			this.id = id;
		}
		
		private Node() {
			this.id = idCounter++;
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
