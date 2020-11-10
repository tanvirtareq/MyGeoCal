/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author Tanvir Tareq
 */
public class WindowFxml extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        
        AnchorPane root=FXMLLoader.load(getClass().getResource("Window.fxml"));
//        TextFlow tf=FXMLLoader.load(getClass().getResource("pc.fxml"));
//        
//        TextFlow rtf=WindowController.getTf();
//
//     
        
//        root.getChildren().add(tf);
//        
//        
//        tf.setLayoutX(77);
//        tf.setLayoutY(235);
//        
//        tf.prefWidth(200);
//        tf.prefHeight(200);
//        
//        tf.setMaxHeight(200);
//        tf.setMaxWidth(200);
        
//        GraphicsContext gc=WindowController.getGc();
//        
//        gc.strokeLine(0, 0, 1000, 1000);
//        
//        Grid maintain=new Grid();
//        
////        maintain.redraw(gc);
        
        Scene sc=new Scene(root);
        
        primaryStage.setScene(sc);
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
