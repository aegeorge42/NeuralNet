package neuralnet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Net {
	List<Layer> layers;

	
	public Net() {
		List<Layer> l = new ArrayList<Layer>();
		layers=l;
	}

	//TODO: get rid of this
	//if a layer is added it comes with 1 neuon
	//no such thing as empty layer
	public void addEmptyLayer(Layer l) {
		layers.add(l);
	}
	
	public static void main(String[] args) {
		
		//the first set of input values does not change
		List<Double> staticInput = new ArrayList<Double>();
		staticInput.add(1.0);
		staticInput.add(2.0);
		staticInput.add(3.0);
		
		Net net = new Net();
		Layer l1 = new Layer(1);
		Layer l2 = new Layer(2);
		
		net.addEmptyLayer(l1);
		net.addEmptyLayer(l2);
		
		l1.addNeuron(staticInput, "a");
		l1.addNeuron(staticInput, "b");
		l1.addNeuron(staticInput, "c");
		
		l2.addNeuron(staticInput, "d");
		
		
		System.out.println("your net has " + net.layers.size() + " layers");
		for(int i=0; i<net.layers.size(); i++) {
			Layer currentLayer=net.layers.get(i);
			System.out.println("layer " + currentLayer.layerNum + " has " + currentLayer.neurons.size() + " neurons");
			for(int j=0; j<currentLayer.neurons.size(); j++) {
				Neuron currentNeuron = currentLayer.neurons.get(j);
				System.out.println(currentLayer.layerNum + currentNeuron.id);
			}
		}
	}
}
	

