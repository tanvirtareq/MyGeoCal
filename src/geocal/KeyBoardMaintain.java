/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Tanvir Tareq
 */
public class KeyBoardMaintain implements Runnable{

    Button zoomInButton=new Button("Zoom  in");
    Button zoomOutButton=new Button("Zoom  out");
    Button log10Button=new Button("log10( )");
    
    GridMaintainceInThread grid;
    GraphicsContext gc;
    
    public KeyBoardMaintain(GridPane gridPane, GridMaintainceInThread grid,  GraphicsContext gc) {
        this.gc=gc;
        this.grid=grid;
        
       initKeyBoard(gridPane);
       
       Thread t=new Thread(this);
       t.start();
       
    }
    
    
    
    @Override
    public void run() {
        
        zoomInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.unitOfScale=grid.unitOfScale*2;
                grid.redraw(gc);
                
            }
        });
        
         zoomOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.unitOfScale=grid.unitOfScale/2;
                grid.redraw(gc);
                
            }
        });
        
    }

    private void initKeyBoard(GridPane gridPane) {
        gridPane.addRow(0, zoomInButton, zoomOutButton);
        gridPane.add(log10Button, 0, 1);
        
    }
    
}
