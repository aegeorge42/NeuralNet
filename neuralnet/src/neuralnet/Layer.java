package neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Layer {
	List<Neuron> neurons;
	int layerNumber;
	
	public Layer(int num) {
		List<Neuron> n = new ArrayList<Neuron>();
		neurons=n;
		layerNumber=num;
	}

	//add a neuron to a layer
	//initial weights are random
	Neuron addNeuron(List<Double> inputs, String id) {
		int numInputs = inputs.size();
		List<Double> weights = new ArrayList<Double>();
		for(int i=0; i<numInputs; i++) {
			weights.add((double)Math.round(Math.random() * 100.0) / 100.0); //Math.random() for real
		}
	//	System.out.println(weights);
		Neuron n = new Neuron(inputs,weights);
		n.id=id;
		neurons.add(n);
		n.calcOut();
		return n;
	}
	
	
	public static void main(String[] args) {
		Layer layer1 = new Layer(1);
		
		List<Double> input1 = new ArrayList<Double>();
		input1.add(5.0);
		input1.add(10.0);
		input1.add(15.0);
		
		layer1.addNeuron(input1, "a");
		layer1.addNeuron(input1, "b");
		
		System.out.println("your layer has " + layer1.neurons.size() + " neurons");
		for (Neuron neuron : layer1.neurons) {
			neuron.calcOut();
			System.out.println("output: " + neuron.output);
		}
		
	}
}
