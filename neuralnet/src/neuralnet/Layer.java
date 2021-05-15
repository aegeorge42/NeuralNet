package neuralnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Layer {
	List<Neuron> neurons;
	int layerNumber;
	List<Double> layerInput;
	List<Double> layerOutput;
	
	public Layer(int num) {
		List<Neuron> n = new ArrayList<Neuron>();
		List<Double> lo = new ArrayList<Double>();
		neurons=n;
		layerNumber=num;
		layerOutput=lo;
	}

	int getLayerNumber() {
		return layerNumber;
	}
	
	//add a neuron to a layer
	//this is used for first layer
	Neuron addNeuron(List<Double> inputs) {
		int numInputs = inputs.size();
		List<Double> weights = new ArrayList<Double>();
		for(int i=0; i<numInputs; i++) {
			weights.add((double)Math.round(Math.random() * 100.0) / 100.0); //Math.random() for real
		}
//		System.out.println(weights);

		Neuron n = new Neuron(inputs,weights);
		neurons.add(n);
		layerOutput.add(n.calcOut());
		return n;
	}
	
	//add neuron to a layer
	//this is used for any hidden layers + output layer
	//where layer input based on prev layer output
	Neuron addNeuron() {
		int numInputs = layerInput.size();
		List<Double> weights = new ArrayList<Double>();
		
		Random random=new Random();
		
		for(int i=0; i<numInputs; i++) {
//			weights.add((double)Math.round(Math.random() * 100.0) / 100.0); //Math.random() for real
			weights.add((double)random.nextInt(200) - 100);
		}
	
//		System.out.println(weights);
		Neuron n = new Neuron(layerInput,weights);
		neurons.add(n);
		layerOutput.add(n.calcOut());
		return n;
	}
	
	List<Double> getLayerOutput(){
		return layerOutput;
	}
	
	void setLayerInput(List<Double> inputs) {
		layerInput=inputs;
	}
	
	public static void main(String[] args) {
		Layer layer1 = new Layer(1);
		
		List<Double> input1 = new ArrayList<Double>();
		input1.add(5.0);
		input1.add(10.0);
		input1.add(15.0);
		
		layer1.addNeuron(input1);
		layer1.addNeuron(input1);
		
		System.out.println("your layer has " + layer1.neurons.size() + " neurons");
		for (Neuron neuron : layer1.neurons) {
			neuron.calcOut();
			System.out.println("output: " + neuron.output);
		}
		
	}
}
