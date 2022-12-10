package com.kpzip.circuitsapi.util.math;

import java.util.ArrayList;

//Used to define a mathematical function by linearly interpolating between data points
public class Function {

	private ArrayList<Double> outputData, inputData;
	
	/**
	 * The value in outputData should be the value of the function when the corresponding value in input data is put into the function
	 * @param outputData y-values for the function
	 * @param inputData x-values for the function
	 * @param shouldSort set to false if the input data is already sorted true if not
	 */
	public Function(ArrayList<Double> outputData, ArrayList<Double> inputData, boolean shouldSort) {
		if (outputData.size() != inputData.size()) {
			throw new IllegalArgumentException("Cannot create function with unequal ammounts of input and output data");
		}
		this.outputData = outputData;
		this.inputData = inputData;
	}
	
	public Function() {
		this(new ArrayList<Double>(0), new ArrayList<Double>(0), false);
		addDataPoint(0.0d, 0.0d);
	}
	
	/**
	 * Evaluate the function at a certain input
	 * @param input the value to be put into the function
	 * @return the value of the function at input
	 */
	public double getValue(double input) {
		for (int i = 0; i < inputData.size(); i++) {
			if (inputData.get(i) > input) {
				if (i == 0) {
					return outputData.get(0);
				}
				double interpAmmnt = (input - inputData.get(i - 1))/inputData.get(i);
				return (interpAmmnt - 1) * outputData.get(i - 1) + interpAmmnt * outputData.get(i);
			}
		}
		return outputData.get(outputData.size() - 1);
	}
	
	//Insert a data point at the end of a function
	public void addDataPoint(double input, double output) {
		outputData.add(output);
		inputData.add(input);
	}

}
