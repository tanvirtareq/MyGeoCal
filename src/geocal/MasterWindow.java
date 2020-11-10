/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Tanvir Tareq
 */
public class MasterWindow extends Application{
    Stage myStage=new Stage();
    GraphicsContext gc;
    
    Canvas canvas=new Canvas();
    GridPane keyBoard=new GridPane();
    GridPane inputField=new GridPane();
    
    Button zoomInButton = new Button("ZOOM IN");
    Button zoomOutButton = new Button("ZOOM OUT");
    
    
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gc=canvas.getGraphicsContext2D();
        GridPane gridPane=new GridPane();
//        gridPane.setMaxSize(300, 600);
//        gridPane.setPrefSize(300, 600);
        Scene scene=new Scene(gridPane, 1300, 600);
        myStage.setScene(scene);
        myStage.show();
        
        keyBoard.prefHeight(300);
        keyBoard.prefWidth(500);
        
//        keyBoard.prefHeight(300);
        inputField.prefWidth(500);
        
        keyBoard.setLayoutX(canvas.getBoundsInLocal().getMaxX());
        keyBoard.setLayoutY(canvas.getBoundsInLocal().getMinY()+300);
       
        gridPane.setStyle(
                "-fx-background-color: white;"
        );
        
       gridPane.add(canvas, 0, 0, 1, 2);
       gridPane.add(keyBoard, 1, 1 );
       gridPane.add(inputField, 1, 0, gridPane.REMAINING, 1);
//       gridPane.add(zoomInButton, 2, 0, 3, 1);
//       gridPane.add(zoomOutButton, 5, 0);
//       gridPane.setGridLinesVisible(true);
       gridPane.setHgap(10);
       gridPane.setVgap(10);
       
       canvas.setHeight(600);
       canvas.setWidth(800);
      
       
       GridMaintainceInThread maintainGrid=new GridMaintainceInThread();
       maintainGrid.maintainGrid(gc);
       
       KeyBoardMaintain keyBoardMaintain=new KeyBoardMaintain(keyBoard, maintainGrid, gc);
//       MaintainsInputField input=new MaintainsInputField(inputField, keyBoardMaintain);

//       keyBoard.addRow(0, zoomInButton, zoomOutButton);
        
        
    }
    
}
