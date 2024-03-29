package com.kpzip.circuitsapi.circuitsim.components.source;

import com.kpzip.circuitsapi.circuitsim.Circuit;
import com.kpzip.circuitsapi.util.math.Function;

public class FunctionGenerator<F extends Function> extends AbstractSource {

	private double t;
	private F fn;
	private double timeOffset;

	public FunctionGenerator(Circuit.ConnectionPoint n1, Circuit.ConnectionPoint n2, F fn) {
		super(n1, n2);
		this.fn = fn;
		t = 0;
		timeOffset = 0;
	}
	
	public FunctionGenerator(Circuit.ConnectionPoint n1, Circuit.ConnectionPoint n2, F fn, double timeOffset) {
		super(n1, n2);
		this.fn = fn;
		t = timeOffset;
		this.timeOffset = timeOffset;
	}
	
	public F getFunction() {
		return fn;
	}
	
	public void setFunction(F fn) {
		this.fn = fn;
	}
	
	public double getTimeOffset() {
		return timeOffset;
	}
	
	public void setTimeOffset(double timeOffset) {
		this.timeOffset = timeOffset;
	}

	@Override
	public double getSourceVoltage() {
		return fn.sample(t);
	}
	
	@Override
	public void updateTime(double time) {
		t += time;
	}
	
	@Override
	public void reset() {
		t = timeOffset;
	}

}
