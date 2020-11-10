/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tanvir Tareq
 */
public class PcController extends Application{
    
    public FlowPane flp;
    
    public static void main(String[] args) {
        launch(args);
      
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        
        Scene sc=new Scene(flp);
        primaryStage.setScene(sc);
        
    }
    

    /**
     * Initializes the controller class.
     */
    
}
