package com.kpzip.circuitsapi.circuitsim.components.source;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.util.math.Function;

public class ImmutableSource extends AbstractSource {
	
	private double t;
	private final Function fn;

	public ImmutableSource(Circuit.ConnectionPoint n1, Circuit.ConnectionPoint n2, final Function fn) {
		super(n1, n2);
		this.fn = fn;
		t = 0;
	}
	
	public ImmutableSource(Circuit.ConnectionPoint n1, Circuit.ConnectionPoint n2, final Function fn, double timeOffset) {
		super(n1, n2);
		this.fn = fn;
		t = timeOffset;
	}

	@Override
	public double getSourceVoltage() {
		return fn.sample(t);
	}
	
	@Override
	public void updateTime(double time) {
		t += time;
	}

}
