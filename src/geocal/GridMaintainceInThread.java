/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author Tanvir Tareq
 */
public class GridMaintainceInThread implements Runnable {
    Thread t;
    
    ArrayList<DrawAble> arrayList=new ArrayList<DrawAble>();
    
    GridMaintainceInThread()
    {
        t=new Thread(this);
        
    }
    
    void maintainGrid(GraphicsContext gc)
    {
        Line line1=new Line(0, 0, 100, 100);
        arrayList.add(line1);
        
        this.gc=gc;
        t.start();
    }
    
     FlowPane rootNode = new FlowPane();
    Button zoomInButton = new Button("ZOOM IN");
    Button zoomOutButton = new Button("ZOOM OUT");

    GridPane gridNode = new GridPane();
    Canvas canvas = new Canvas(1000, 500);
    Scene scene = new Scene(rootNode);

    double positionOfXAxis;
    double positionOfYAxis;
    double unitOfScale;
    double increment;
    double mousePressedX;
    double mousePressedY;

    GraphicsContext gc;

    @Override
    public void run() {


        positionOfXAxis = (gc.getCanvas().getBoundsInLocal().getMaxY() + gc.getCanvas().getBoundsInLocal().getMinY()) / 2.0;
        positionOfYAxis = (gc.getCanvas().getBoundsInLocal().getMaxX() + gc.getCanvas().getBoundsInLocal().getMinX()) / 2.0;
        unitOfScale = 40;
//        System.out.println(positionOfXAxis + " " + positionOfYAxis + " " + unitOfScale);

        increment = 30.0;

        drawHorizontalLines(gc, 30.0);
        drawVerticalLines(gc, 30.0);
        drawLine(gc);
        drawDrawAble(gc);

        zoomOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearCanvas(gc);
                unitOfScale = unitOfScale / 2;
                redraw(gc);

            }
        });

        zoomInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearCanvas(gc);
                unitOfScale = unitOfScale * 2;
                redraw(gc);

            }
        });

        mousePressedPosition(gc);
        mouseDragged(gc);

    }
    
        private void drawHorizontalLines(GraphicsContext gc, double increment) {
        increment = 40;
        gc.strokeLine(gc.getCanvas().getBoundsInLocal().getMinX(), positionOfXAxis, gc.getCanvas().getBoundsInLocal().getMaxX(), positionOfXAxis);
        gc.strokeLine(gc.getCanvas().getBoundsInLocal().getMinX(), positionOfXAxis, gc.getCanvas().getBoundsInLocal().getMaxX(), positionOfXAxis);
        gc.strokeLine(gc.getCanvas().getBoundsInLocal().getMinX(), positionOfXAxis, gc.getCanvas().getBoundsInLocal().getMaxX(), positionOfXAxis);

        for (double i = positionOfXAxis - increment; i > gc.getCanvas().getBoundsInLocal().getMinY(); i = i - increment) {
            Double d = (positionOfXAxis - i) / unitOfScale;

            writeForHorizontal(gc, d.toString(), i);
            gc.strokeLine(gc.getCanvas().getBoundsInLocal().getMinX(), i, gc.getCanvas().getBoundsInLocal().getMaxX(), i);
        }

        for (double i = positionOfXAxis + increment; i <= gc.getCanvas().getBoundsInLocal().getMaxY(); i = i + increment) {
            Double d = (positionOfXAxis - i) / unitOfScale;
             writeForHorizontal(gc, d.toString(), i);
            gc.strokeLine(gc.getCanvas().getBoundsInLocal().getMinX(), i, gc.getCanvas().getBoundsInLocal().getMaxX(), i);
        }

    }

    private void drawVerticalLines(GraphicsContext gc, double increment) {
        increment = 40.0;
        gc.strokeLine(positionOfYAxis, gc.getCanvas().getBoundsInLocal().getMinY(), positionOfYAxis, gc.getCanvas().getBoundsInLocal().getMaxY());
        gc.strokeLine(positionOfYAxis, gc.getCanvas().getBoundsInLocal().getMinY(), positionOfYAxis, gc.getCanvas().getBoundsInLocal().getMaxY());
        gc.strokeLine(positionOfYAxis, gc.getCanvas().getBoundsInLocal().getMinY(), positionOfYAxis, gc.getCanvas().getBoundsInLocal().getMaxY());

        for (double i = positionOfYAxis; i > gc.getCanvas().getBoundsInLocal().getMinX(); i = i - increment) {
            Double d = (i - positionOfYAxis) / unitOfScale;
            writeForVertical(gc, d.toString(), i);
            gc.strokeLine(i, gc.getCanvas().getBoundsInLocal().getMinY(), i, gc.getCanvas().getBoundsInLocal().getMaxY());
        }

        for (double i = positionOfYAxis; i <= gc.getCanvas().getBoundsInLocal().getMaxX(); i = i + increment) {
            Double d = (i - positionOfYAxis) / unitOfScale;
            writeForVertical(gc, d.toString(), i);
            gc.strokeLine(i, gc.getCanvas().getBoundsInLocal().getMinY(), i, gc.getCanvas().getBoundsInLocal().getMaxY());
        }

    }

    void clearCanvas(GraphicsContext gc) {
        gc.clearRect(gc.getCanvas().getBoundsInLocal().getMinX(), gc.getCanvas().getBoundsInLocal().getMinY(), gc.getCanvas().getBoundsInLocal().getMaxX(), gc.getCanvas().getBoundsInLocal().getMaxY());
    }

    private void mousePressedPosition(GraphicsContext gc) {

        EventHandler<MouseEvent> mouseEventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePressedX = event.getX();
                mousePressedY = event.getY();
//                System.out.println(mousePressedX+" "+mousePressedY);
            }
        };

        gc.getCanvas().addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEventHandler);

    }

    void mouseDragged(GraphicsContext gc) {
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                changeAxes(event.getX(), event.getY());
                clearCanvas(gc);
                redraw(gc);

//                System.out.println(event.getX());
            }
        };

        gc.getCanvas().addEventHandler(MouseEvent.MOUSE_DRAGGED, handler);
    }
    

    void redraw(GraphicsContext gc) {
        
        clearCanvas(gc);
        
        drawHorizontalLines(gc, increment);
        drawVerticalLines(gc, increment);
        drawDrawAble(gc);
        
        drawLine(gc);
        
//        gc.strokeLine(0,0, 1000, 1000);
        
       
        
//        drawFunctions();
    }

    void changeAxes(double x, double y) {
        int changOfy=(int) ((y - mousePressedY)/40);
        int changeOfx=(int) ((x - mousePressedX)/40);
        positionOfXAxis = positionOfXAxis + changOfy;
        positionOfYAxis = positionOfYAxis + changeOfx;
    }

    void writeForHorizontal(GraphicsContext gc, String text, double i) {
        if (gc.getCanvas().getBoundsInLocal().getMinX() <= positionOfYAxis && gc.getCanvas().getBoundsInLocal().getMaxX()>=positionOfYAxis) {
            gc.fillText(text, positionOfYAxis, i);
        } 
        
        else if(gc.getCanvas().getBoundsInLocal().getMinX() > positionOfYAxis){
             gc.fillText(text,gc.getCanvas().getBoundsInLocal().getMinX() , i);
            
        }
        
           
         else if(gc.getCanvas().getBoundsInLocal().getMaxX() < positionOfYAxis){
             gc.fillText(text,gc.getCanvas().getBoundsInLocal().getMaxX()-30 , i);
            
        }
    }
    
     void writeForVertical(GraphicsContext gc, String text, double i) {
        if (gc.getCanvas().getBoundsInLocal().getMinY() <= positionOfXAxis && gc.getCanvas().getBoundsInLocal().getMaxY()>=positionOfXAxis) {
            gc.fillText(text,  i, positionOfXAxis);
        } 
        
        else if(gc.getCanvas().getBoundsInLocal().getMinY() > positionOfXAxis){
             gc.fillText(text,i,gc.getCanvas().getBoundsInLocal().getMinY()+30);
            
        }
        
           
         else if(gc.getCanvas().getBoundsInLocal().getMaxY() < positionOfXAxis){
             gc.fillText(text,i,gc.getCanvas().getBoundsInLocal().getMaxY()-30);
            
        }
    }
    

     double func(double  x)
     {
         return Math.sin(x);
     }
     
     void drawLine(GraphicsContext gc)
     {
         
         double xprev=gc.getCanvas().getBoundsInLocal().getMinX();
         double yprev=-func((xprev-positionOfYAxis)/unitOfScale)*unitOfScale+positionOfXAxis;
         
         for(double x0=xprev+1;x0<=gc.getCanvas().getBoundsInLocal().getMaxX();x0++)
         {
//             x0=gc.getCanvas().getBoundsInLocal().getMaxX();
             double y0=-func((x0-positionOfYAxis)/unitOfScale)*unitOfScale+positionOfXAxis;
             
             gc.strokeLine(x0, y0, xprev, yprev);
//             System.out.println(xprev+ " "+yprev+" "+x0+" "+y0);
             
             xprev=x0;
             yprev=y0;
//             break;
         }

     }
     
     void drawDrawAble(GraphicsContext gc)
     {
          for(int i=0;i<arrayList.size();i++)
        {
            DrawAble d=arrayList.get(i);
            d.draw(gc, positionOfYAxis, positionOfXAxis, unitOfScale);
            System.out.println(i);
            
        }
     }
}
