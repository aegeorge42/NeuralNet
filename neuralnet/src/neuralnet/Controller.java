package neuralnet;

import java.util.*;

/*
 * Non-neural net program functionality
 */
public class Controller {
	int editStage=1;

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Controller controller = new Controller();
		Net net = new Net();
		
		Scanner inputScanner = new Scanner(System.in);
		List<Double> staticInput = new ArrayList<Double>();
		staticInput.add(1.0);
		staticInput.add(2.0);
		staticInput.add(3.0);
		
		while(controller.editStage==1) {
			
			System.out.println("press l to add layer or n to add neuron");
			String inputStr = inputScanner.next();
			
			if(inputStr.equals("l")) {
				net.addLayer();
				System.out.println("net has " + net.layers.size() +" layers");
			} else if (inputStr.equals("n")){
				System.out.println("select layer");
				int inputInt = inputScanner.nextInt();
				Layer currLayer = net.getLayer(inputInt);
				
				//random ids (just for testing)
				Random r = new Random();
				char c = (char)(r.nextInt(26) + 'a');
				
//				currLayer.addNeuron(staticInput, Character.toString(c));
				System.out.println(currLayer.layerNumber + " has " + currLayer.neurons.size() +" neurons");
			}
			
			for(Layer layer : net.layers) {
				for(Neuron neuron : layer.neurons) {
					System.out.println(" input: " + neuron.input + " output: " + neuron.output);
				}
				System.out.println("layer output:" + layer.layerOutput);

			}
		
		}
		inputScanner.close();

		}
	
}