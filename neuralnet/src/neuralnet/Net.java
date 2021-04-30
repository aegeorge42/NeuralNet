package neuralnet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Net {
	List<Neuron> neurons;
	
	public Net() {
		List<Neuron> n = new ArrayList<Neuron>();
		neurons=n;
	}

	Neuron createNeuron(int layer, List<Double> input, List<Double> weight) {
		Neuron n = new Neuron(layer,input,weight);
		neurons.add(n);
		return n;
	}
	
	public static void main(String[] args) {
		Net net = new Net();
		
		List<Double> input1 = new ArrayList<Double>();
		input1.add(5.0);
		input1.add(10.0);
		input1.add(15.0);
		
		List<Double> weight1 = new ArrayList<Double>();
		weight1.add(0.1);
		weight1.add(0.2);
		weight1.add(0.3);
		
		net.createNeuron(1,input1, weight1);
		
		List<Double> weight2 = new ArrayList<Double>();
		weight2.add(0.2);
		weight2.add(0.4);
		weight2.add(0.6);
		
		net.createNeuron(1, input1, weight2);
		
		System.out.println("your net has " + net.neurons.size() + " neurons");
		for (Neuron neuron : net.neurons) {
			System.out.println("layer: " + neuron.layer +" output: " + neuron.output);
		}
		
	}
}
