/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Tanvir Tareq
 */
public class FunctionDrawing extends Application implements Runnable{
    
    
    public static void main(String[] args) {
     
    }
    
 
    
    void drawFunction(Grid grid)
    {
        double y, x, x0=grid.positionOfXAxis, y0=func(x0);
        
        y0=grid.positionOfYAxis;
        
        double x1=x0;
        double y1=y0+func(0);
        
        for(double x2=grid.positionOfXAxis-1;x2>=grid.gc.getCanvas().getBoundsInLocal().getMinX();x2--)
        {
            x=x2-x0;
            y=y0+func(x);
//            y=y0+func(x-x0);
//            System.out.println(x+" "+y+" "+x0+" "+y0);
            grid.gc.strokeLine(x1, y1, x+x0, y);
            x1=x+x0;
            y1=y;
            
        }
        
    }


    @Override
    public void run() {
       
        System.out.println("NO");
        
         Grid grid=new Grid();
         System.out.println("really");
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
          Thread t=new Thread(this);
        t.start();
    }

    private double func(double x0) {
        
        return 2*x0; 
     }
    
}
