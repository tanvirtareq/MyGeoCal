/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Tanvir Tareq
 */
public class MaintainsInputField  implements Runnable{

    Label label1=new Label("f(x)=");
    Label label2=new Label("f(x)=");
    Label label3=new Label("f(x)=");
    
    TextArea textArea1=new TextArea();
    TextArea textArea2=new TextArea();
    TextArea textArea3=new TextArea();
    
    Button drawButton1=new Button("DRAW");
    Button drawButton2=new Button("DRAW");
    Button drawButton3=new Button("DRAW");
    
    GridPane grid;
    
    public MaintainsInputField(GridPane grid) {
        Thread t=new Thread(this);
        this.grid=grid;
        System.out.println("yes");
        init();
        
        t.start();
    }
    
    

    @Override
    public void run() {
        
        drawButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str=textArea1.getText();
                String postfix=MathHelper.infixToPostfix(str);
                
            }
        });
        
   }

    private void init() {
        grid.add(drawButton1, 0, 0);
        grid.add(drawButton2, 0, 1);
        grid.add(drawButton3, 0, 2);
        
        grid.add(label1, 1, 0);
        grid.add(label2, 1, 1);
        grid.add(label3, 1, 2);
        
        textArea1.setPrefColumnCount(6);
        textArea1.setPrefRowCount(1);
        
        grid.add(textArea1, 2, 0);
        
        textArea2.setPrefColumnCount(6);
        textArea2.setPrefRowCount(1);
        
        grid.add(textArea2, 2, 1);
        
        textArea3.setPrefColumnCount(6);
        textArea3.setPrefRowCount(1);
        
        grid.add(textArea3, 2, 2);
        
        
    }
    
}
