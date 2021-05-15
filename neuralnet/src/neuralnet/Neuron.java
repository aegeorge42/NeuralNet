package neuralnet;

import java.util.*;

public class Neuron {
	List<Double> input;
	List<Double> weight;
	double bias;
	double output;
	String actFn = "linear";
	
	Neuron(List<Double> input, List<Double> weight) {
		this.input=input;
		this.weight=weight;
	}
	
	void setInput(List<Double> input){
		this.input=input;
	}
	
	void setWeight(List<Double> weight) {
		this.weight=weight;
	}
	
	void setActFn(String actFn) {
		this.actFn=actFn;
	}
	
	//multiply each input by weight and add bias
	//add these values together to get single output
	//feed this value into activation function
	public double calcOut() {
		double[] outArray = new double[input.size()];
		double out = 0;
		
		for(int i=0; i<input.size(); i++) {
			outArray[i] = (input.get(i) * weight.get(i)) + bias;
			out=out+outArray[i];
		}

		//activation function heavy lifting
		switch(actFn) {
			case "linear":
				output=out;
				break;
			case "binstep":
				if(out<0) { output=0; }
				else if(out>=0){ output=1; };
				break;
		}
		return output;
	}
	
	


	public static void main(String[] args) {
/*
		List<Double> staticInput = new ArrayList<Double>();
		staticInput.add(10.0);
		staticInput.add(10.0);
		staticInput.add(15.0);
		
		List<Double> weight1 = new ArrayList<Double>();
		weight1.add(0.1);
		weight1.add(0.2);
		weight1.add(0.3);
		
		Neuron n1 = new Neuron(staticInput, weight1);
		n1.setActFn("linear");
		n1.calcOut();
		
		System.out.println("input is " + n1.input);
		System.out.println("weight is " + n1.weight);
		System.out.println("output is " + n1.output);	
*/
	}

}

