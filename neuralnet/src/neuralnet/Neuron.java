package neuralnet;

import java.util.*;

public class Neuron {
	List<Double> input;
	List<Double> weight;
	double output;
	
	Neuron(List<Double> input, List<Double> weight) {
		this.input=input;
		this.weight=weight;
	}
	
	//Calculate single output from each neuron given input and weights
	public double calcOut(List<Double> input, List<Double> weight) {
		double[] outArray = new double[input.size()];
		double sum = 0;
		
		for(int i=0; i<input.size(); i++) {
			outArray[i] = input.get(i) * weight.get(i);
			sum=sum+outArray[i];		
		}
		System.out.println("sum is " + sum);
		output = sum;
		return sum;
	}
	
	/*
	public static void main(String[] args) {
		
		List<Double> input = new ArrayList<Double>();
		input.add(5.0);
		input.add(10.0);
		input.add(15.0);
		
		List<Double> weight = new ArrayList<Double>();
		weight.add(0.1);
		weight.add(0.2);
		weight.add(0.3);
		
		Neuron n = new Neuron(input, weight);
		
		
		System.out.println("input is " + input);
		System.out.println("weight is " + weight);
		
		n.calcOut(input, weight);
		
	}
	*/
}

