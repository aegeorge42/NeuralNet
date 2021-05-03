package neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Layer {
	List<Neuron> neurons;
	int layerNum;
	
	public Layer(int num) {
		List<Neuron> n = new ArrayList<Neuron>();
		neurons=n;
		
		layerNum=num;
	}

	//add a neuron to a layer
	//initial weights are random
	Neuron addNeuron(List<Double> inputs, String id) {
		int numInputs = inputs.size();
		List<Double> weights = new ArrayList<Double>();
		for(int i=0; i<numInputs; i++) {
			weights.add(Math.random());
		}
		System.out.println(weights);
		Neuron n = new Neuron(inputs,weights);
		n.id=id;
		neurons.add(n);
		return n;
	}
	
	public static void main(String[] args) {
		/*
		Layer layer = new Layer();
		
		List<Double> input1 = new ArrayList<Double>();
		input1.add(5.0);
		input1.add(10.0);
		input1.add(15.0);
		
		List<Double> weight1 = new ArrayList<Double>();
		weight1.add(0.1);
		weight1.add(0.2);
		weight1.add(0.3);
		
		layer.addNeuron(input1, weight1);
		
		List<Double> weight2 = new ArrayList<Double>();
		weight2.add(0.2);
		weight2.add(0.4);
		weight2.add(0.6);
		
		layer.addNeuron(input1, weight2);
		
		System.out.println("your layer has " + layer.neurons.size() + " neurons");
		for (Neuron neuron : layer.neurons) {
			System.out.println("output: " + neuron.output);
		}
		*/
	}
}
