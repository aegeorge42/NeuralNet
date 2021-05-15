package neuralnet;

import java.util.ArrayList;
import java.util.List;

public class Net {
	List<Double> inputData;
	List<Layer> layers;
	List<List<Double>> layerOutputs;

	public Net() {
		List<Layer> layerList = new ArrayList<Layer>();
		layers=layerList;
		setData();
	}

	List<Double> setData(){
		List<Double> data = new ArrayList<Double>();
		data.add(-1.0);
		data.add(1.0);
		data.add(2.0);
		
		inputData=data;
		return data;
		
	}
	
	public void addLayer() {
		if(layers.size()==0) {
			layers.add(new Layer(0));
			getLayer(0).addNeuron(inputData);
			layers.get(0).layerInput=inputData;
		} else {
			layers.add(new Layer(layers.size()+1));
			setLayerInput();
			getLayer(layers.size()-1).addNeuron();

			
		}
		setLayerInput();
	}
	
	Layer getLayer(int num) {
		return layers.get(num);
	}
	
	void setLayerInput() {
		List<List<Double>> layerOuts= new ArrayList<List<Double>>();
		for(Layer layer : this.layers) {
//			System.out.println(layer.getLayerOutput());
			layerOuts.add(layer.getLayerOutput());
		}
		layerOutputs=layerOuts;
		
		for(int i=1; i<layers.size(); i++) {
			layers.get(i).layerInput = layers.get(i-1).layerOutput;
		}
	}
	
	public static void main(String[] args) {
		
		//the first set of input values does not change
		Net net = new Net();
		net.addLayer();
		net.addLayer();
		net.addLayer();

	
		for(Layer layer : net.layers) {
			System.out.println("in: " + layer.layerInput);
			for(Neuron n : layer.neurons) {
				System.out.println("weights: " + n.weight);
			}
			System.out.println("out: " + layer.layerOutput); 
		}
	}
}
	

