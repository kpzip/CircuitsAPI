package com.kpzip.circuitsapi.circuitsim.components.source;

import com.kpzip.circuitsapi.circuitsim.Circuit;

public class DCSupply extends AbstractSource implements MutableSource {

	private double voltage;

	public DCSupply(Circuit.ConnectionPoint plus, Circuit.ConnectionPoint minus, double voltage) {
		super(plus, minus);
		this.voltage = voltage;
	}

	public double getVoltage() {
		return voltage;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}

	@Override
	public double getSourceVoltage() {
		return voltage;
	}

}
