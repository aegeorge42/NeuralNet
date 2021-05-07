package neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Net {
	List<Layer> layers;

	public Net() {
		List<Layer> layerList = new ArrayList<Layer>();
		layers=layerList;
	}

	//TODO: get rid of this
	//if a layer is added it comes with 1 neuon
	//no such thing as empty layer
	public void addEmptyLayer() {
		if(layers.size()==0) {
			layers.add(new Layer(1));
		} else {
			layers.add(new Layer(layers.size()+1));
		}
	}
	
	Layer getLayer(int num) {
		Layer returnLayer = layers.get(num-1);
		return returnLayer;
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
		
		
		l1.addNeuron(staticInput, "1a");
		l1.addNeuron(staticInput, "1b");
		l1.addNeuron(staticInput, "1c");
		
		List<Double> layer1out = new ArrayList<Double>();
		for (Neuron neuron : l1.neurons) {
			layer1out.add(neuron.output);
		}
		
		l2.addNeuron(layer1out, "2a");
		for (Neuron neuron : l2.neurons) {
			System.out.println(neuron.output);
		}
		
		for(Layer layer : net.layers) {
			for(Neuron neuron : layer.neurons) {
				System.out.println(neuron.id + " input: " + neuron.input + " output: " + neuron.output);
			}
			
		}
	}
}
	

