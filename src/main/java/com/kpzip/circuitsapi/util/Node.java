package com.kpzip.circuitsapi.util;

import java.util.ArrayList;
import java.util.Iterator;

import com.kpzip.circuitsapi.circuitsim.components.IComponent;
import com.kpzip.circuitsapi.util.math.Function;

public class Node implements Iterable<IComponent> {

	private ArrayList<IComponent> ConnectedComponents;
	
	private Function voltage = new Function();
	
	public Node() {	
	}

	@Override
	public Iterator<IComponent> iterator() {
		return ConnectedComponents.iterator();
	}
	
	public double getVoltage(double time) {
		return voltage.getValue(time);
	}

}
