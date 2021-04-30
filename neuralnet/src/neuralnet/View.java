package neuralnet;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
 
public class View extends Application {
	Group root;
	Button neuronButton;
	
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Title");
        Group startroot = new Group();
        root = startroot;
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
     
       // drawNeuron(gc);
        setUpButtons(gc);
        
    }

    private void drawNeuron(GraphicsContext gc) {
    	int randx = (int) (Math.random() * (300));
    	int randy = (int) (Math.random() * (250));
        gc.strokeOval(randx, randy, 30, 30);
    }
    
    private void setUpButtons(GraphicsContext gc) {
    	Button button = new Button("Add neuron");  
    	button.setOnAction(new EventHandler<ActionEvent>() {  
             
             @Override  
             public void handle(ActionEvent click) {  
                 drawNeuron(gc);
             }  
         });  
    	root.getChildren().add(button); 
    }
}
