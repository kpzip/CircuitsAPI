package com.kpzip.circuitsapi.util;

import java.util.ArrayList;
import java.util.Iterator;

import com.kpzip.circuitsapi.circuitsim.components.IComponent;
import com.kpzip.circuitsapi.util.math.Function;

public class Node implements Iterable<IComponent> {

	private ArrayList<IComponent> ConnectedComponents;
	
	private Function voltage = new Function();
	
	private Boolean ground = false;
	
	//-1 indicates that the node is not part of a circuit
	private int nodeNumber = -1;
	
	public Node() {	
	}

	@Override
	public Iterator<IComponent> iterator() {
		return ConnectedComponents.iterator();
	}
	
	public double getVoltage(double time) {
		return voltage.getValue(time);
	}
	
	public Node setAsGround(boolean ground) {
		this.ground = ground;
		return this;
	}
	
	public Node setNodeNumber(int nodenum) {
		this.nodeNumber = nodenum;
		return this;
	}
	
	public int getNodeNumber() {
		return this.nodeNumber;
	}

}
