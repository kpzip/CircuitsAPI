package com.kpzip.circuitsapi.circuitsimulator;

import java.util.Vector;

public class CircuitNode {
	public int x;
	public int y;
	public Vector<CircuitNodeLink> links;
	public boolean internal;

	public CircuitNode() {
		links = new Vector<CircuitNodeLink>();
	}
}
