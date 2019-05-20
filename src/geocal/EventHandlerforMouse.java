/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Tanvir Tareq
 */
public class EventHandlerforMouse extends Application {

    Grid grid = new Grid();

    public static void main(String[] args) {
        EventHandlerforMouse ehm = new EventHandlerforMouse();

        ehm.grid.show();
        
        ehm.MouseClickedPosition(ehm.grid);
        
    }
    
    

   
    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void MouseClickedPosition(Grid grid) {
        EventHandler<MouseEvent> handler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX()+" "+event.getY());
            }
        };
        grid.gridNode.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        
    }
}
