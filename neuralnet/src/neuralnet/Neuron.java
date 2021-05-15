package neuralnet;

import java.util.*;

public class Neuron {
	List<Double> input;
	List<Double> weight;
	double output;
	//for testing purposes only
	String id;
	
	//Neuron(List<Double> input, List<Double> weight) {
	//	this.input=input;
	//	this.weight=weight;
	//}
	
	Neuron(){
	}
	
	void setInput(List<Double> input){
		this.input=input;
	}
	
	void setWeight(List<Double> weight) {
		this.weight=weight;
	}
	//Calculate single output from each neuron given input and weights
	public double calcOut() {
		double[] outArray = new double[input.size()];
		double sum = 0;
		
		for(int i=0; i<input.size(); i++) {
			outArray[i] = input.get(i) * weight.get(i);
			sum=sum+outArray[i];		
		}
		output=sum;
		return sum;
	}
	
	void setId(String id){
		this.id = id;
	}
	
	
	public static void main(String[] args) {
		
		List<Double> staticInput = new ArrayList<Double>();
		staticInput.add(5.0);
		staticInput.add(10.0);
		staticInput.add(15.0);
		
		List<Double> weight1 = new ArrayList<Double>();
		weight1.add(0.1);
		weight1.add(0.2);
		weight1.add(0.3);
		
		List<Double> weight2 = new ArrayList<Double>();
		weight2.add(0.9);
		weight2.add(0.8);
		weight2.add(0.7);
		
		Neuron n1 = new Neuron();
		n1.setInput(staticInput);
		n1.setWeight(weight1);
		n1.setId("n1");
		n1.calcOut();
		
		Neuron n2 = new Neuron();
		n1.setInput(staticInput);
		n1.setWeight(weight2);
		n1.setId("n2");
		n1.calcOut();
		
		
		System.out.println(n1.id);
		System.out.println("input is " + n1.input);
		System.out.println("weight is " + n1.weight);
		System.out.println("output is " + n1.output);
		
		System.out.println(n2.id);
		System.out.println("input is " + n2.input);
		System.out.println("weight is " + n2.weight);
		System.out.println("output is " + n2.output);
		
		List<Double> l2input = new ArrayList<Double>();
		l2input.add(n1.output);
		l2input.add(n2.output);
		
		List<Double> l2weight= new ArrayList<Double>();
		l2weight.add(0.25);
		l2weight.add(0.5);
		
		Neuron n3 = new Neuron();
		n3.calcOut();
		
		System.out.println(n3.id);
		System.out.println("input is " + n3.input);
		System.out.println("weight is " + n3.weight);
		System.out.println("output is " + n3.output);
		
		
	}
	
}

