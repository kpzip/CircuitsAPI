package com.kpzip.circuitsapi.tests;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.circuitsim.components.passive.Capacitor;
import com.kpzip.circuitsapi.circuitsim.components.passive.Resistor;
import com.kpzip.circuitsapi.circuitsim.components.source.Battery;

public class Main {

	public static void main(String[] args) {
		Circuit circuit = new Circuit();
		Circuit.ConnectionPoint n1 = circuit.createConnectionPoint();
		Circuit.ConnectionPoint n2 = circuit.createConnectionPoint();
		Battery b = new Battery(circuit.getGround(), n2, 10);
		Capacitor c1 = new Capacitor(circuit.getGround(), n1, 0.0001);
		Resistor r2 = new Resistor(n1, n2, 100);
		circuit.addComponent(c1);
		circuit.addComponent(r2);
		circuit.addComponent(b);
		for (int i = 0; i < 4; i++) {
			circuit.simulationStep(0.01);
			System.out.println(r2.getCurrent());
			System.out.println(n2.getVoltage());
			System.out.println(circuit);
		}
	}

}
