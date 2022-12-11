package com.kpzip.circuitsapi.circuitsim;

import java.util.ArrayList;

import com.kpzip.circuitsapi.circuitsim.components.IComponent;
import com.kpzip.circuitsapi.util.Node;

//Defines a circuit with all its components and connections
public class Circuit {
	private ArrayList<IComponent> Components;
	private ArrayList<Node> Nodes;
	
	public Circuit() {
		Nodes = new ArrayList<Node>();
		Nodes.add(new Node().setAsGround(true));
	}
	
	public void simulate() {
		
	}
	
	public Node getGndNode() {
		return Nodes.get(0);
	}
	
	
	
	
	
	
}
