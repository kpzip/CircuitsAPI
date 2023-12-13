package com.kpzip.circuitsapi.tests;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.circuitsim.components.Battery;
import com.kpzip.circuitsapi.circuitsim.components.Resistor;

public class Main {

	public static void main(String[] args) {
		Circuit circuit = new Circuit();
		Circuit.Node n1 = circuit.createNode();
		Battery b = new Battery(circuit.getGround(), n1, 10);
		Resistor r = new Resistor(circuit.getGround(), n1, 100);
		circuit.addComponent(r);
		circuit.addComponent(b);
		circuit.simulationStep(0);
		System.out.println(r.getCurrent());
	}

}
