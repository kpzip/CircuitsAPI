package com.kpzip.circuitsapi.circuitsim;

import java.util.ArrayList;

import com.kpzip.circuitsapi.circuitsim.components.IComponent;
import com.kpzip.circuitsapi.util.Node;
import com.kpzip.circuitsapi.util.math.Matrix;
import com.kpzip.circuitsapi.util.math.Vector;

//Defines a circuit with all its components and connections
public class Circuit {
	private ArrayList<IComponent> Components;
	private ArrayList<Node> Nodes;
	
	public Circuit() {
		Nodes = new ArrayList<Node>();
		Nodes.add(new Node().setAsGround(true).setNodeNumber(0));
	}
	
	public void simulate() {
		
		Matrix solver = new Matrix(Nodes.size() + Components.size());
		Vector solver2 = new Vector(Nodes.size() + Components.size());
		
		double [] blank_row = new double [Nodes.size() + Components.size()];
		double [] temp_row = blank_row.clone();
		
		//Ground voltate = 0
		temp_row[0] = 1.0d;
		solver.storeRow(0, temp_row);
		
		int current_row = 1;
		
		for (IComponent component : Components) {
			for (Node [] connection : component.getConnections()) {
				double [] constraint = component.getConstraints(connection[0], connection[1]);
				temp_row = blank_row.clone();
				
				temp_row[connection[0].getNodeNumber()] = constraint[0];
				temp_row[connection[1].getNodeNumber()] = -constraint[0];
				
				
			}
		}
	}
	
	public Node getGndNode() {
		return Nodes.get(0);
	}
	
	public void addNode(Node node) {
		Nodes.add(node);
		node.setNodeNumber(Nodes.size()-1);
	}
	
	
	
	
	
	
}
