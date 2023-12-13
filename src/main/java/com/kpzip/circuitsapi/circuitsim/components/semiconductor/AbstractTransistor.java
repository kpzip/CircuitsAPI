package com.kpzip.circuitsapi.circuitsim.components.semiconductor;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.circuitsim.ConnectionPointPair;
import com.kpzip.circuitsapi.circuitsim.components.Component;

public abstract class AbstractTransistor implements Component {
	
	private Circuit.ConnectionPoint collector;
	private Circuit.ConnectionPoint base;
	private Circuit.ConnectionPoint emitter;
	
	private final double currentGain;
	
	private double collectorEmitterCurrent = 0;
	private double baseEmitterCurrent = 0;
	
	private boolean isOn = false;

	public AbstractTransistor(Circuit.ConnectionPoint collector, Circuit.ConnectionPoint base, Circuit.ConnectionPoint emitter, final double currentGain) {
		this.collector = collector;
		this.base = base;
		this.emitter = emitter;
		this.currentGain = currentGain;
	}

	@Override
	public final int connectionPointCount() {
		return 3;
	}

	@Override
	public final int connectionCount() {
		return 2;
	}

	@Override
	public ConnectionPointPair[] connections() {
		return new ConnectionPointPair[] {new ConnectionPointPair(collector, emitter), new ConnectionPointPair(base, emitter)};
	}

	@Override
	public double[] constraints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCurrent(double[] currents) {
		collectorEmitterCurrent = currents[0];
		baseEmitterCurrent = currents[1];
	}

	@Override
	public void reset() {
		collectorEmitterCurrent = 0;
		baseEmitterCurrent = 0;
		isOn = false;
	}
	
	public abstract TransistorType getType();

}
