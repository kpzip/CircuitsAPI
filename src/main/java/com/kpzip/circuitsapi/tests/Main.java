package com.kpzip.circuitsapi.tests;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.circuitsim.components.passive.Inductor;
import com.kpzip.circuitsapi.circuitsim.components.passive.Resistor;
import com.kpzip.circuitsapi.circuitsim.components.source.Battery;

public class Main {

	public static void main(String[] args) {
		Circuit circuit = new Circuit();
		Circuit.ConnectionPoint n1 = circuit.createConnectionPoint();
		Circuit.ConnectionPoint n2 = circuit.createConnectionPoint();
		Battery b = new Battery(circuit.getGround(), n2, 10);
		Inductor l1 = new Inductor(circuit.getGround(), n1, 0.0001);
		Resistor r2 = new Resistor(n1, n2, 100);
		circuit.addComponent(l1);
		circuit.addComponent(r2);
		circuit.addComponent(b);
		for (int i = 0; i < 100; i++) {
			circuit.simulationStep(0.0000001);
			System.out.println(r2.getCurrent());
			System.out.println(n2.getVoltage());
			System.out.println(circuit);
		}
	}

}
