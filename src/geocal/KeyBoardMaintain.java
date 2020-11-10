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
    
    Button log10Button=new Button("log10(");
    Button ButtonSin=new Button("Sin(");
    Button ButtonCos=new Button("Cos(");
    Button ButtonTan=new Button("Tan(");
    Button ButtonSinInverse=new Button("sinInverse");
    Button ButtonCosInverse=new Button("Cosinverse");
    Button ButtonTanInverse=new Button("Taninverse");
    Button ButtonLn=new Button("ln");
    Button ButtonSqrt=new Button("sqrt");
    
    Button Button0=new Button("0");
    Button Button1=new Button("1");
    Button Button2=new Button("2");
    Button Button3=new Button("3");
    Button Button4=new Button("4");
    Button Button5=new Button("5");
    Button Button6=new Button("6");
    Button Button7=new Button("7");
    Button Button8=new Button("8");
    Button Button9=new Button("9");
    
    Button ButtonPlus=new Button("+");
    Button ButtonMinus=new Button("-");
    Button ButtonMultiplication=new Button("*");
    Button ButtonDivide=new Button("/");
    Button ButtonPoint=new Button(".");
    Button ButtonMod=new Button("%");
    
    Button Buttonx=new Button("x");
    Button Buttony=new Button("y");
    Button Buttonz=new Button("z");
    Button ButtonLeftParanthesis=new Button("(");
    Button ButtonRightParanthesis=new Button(")");
    
    Button ButtonDelete=new Button("delet");
    Button ButtonReset=new Button("Reset");
    
    Button ButtoNumber=new Button("123");
    Button ButtonFuncttin=new Button("f(x)");
    
    
    
    GridMaintainceInThread grid;
    GraphicsContext gc;
    
    public KeyBoardMaintain(GridPane gridPane, GridMaintainceInThread grid,  GraphicsContext gc) {
        this.gc=gc;
        this.grid=grid;
        
       initKeyBoard(gridPane);
       
       Thread t=new Thread(this, "keyboard");
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
        
        gridPane.add(Button0, 0, 1);
        gridPane.add(Button1, 1, 1);
        gridPane.add(Button2, 2, 1);
        gridPane.add(Button3, 3, 1);
        gridPane.add(Button4, 0, 2);
        gridPane.add(Button5, 1, 2);
        gridPane.add(Button6, 2, 2);
        gridPane.add(Button7, 3, 2);
        gridPane.add(Button8, 0, 3);
        gridPane.add(Button9, 1, 3);
        
        
        gridPane.add(ButtonPlus, 2, 3);
        gridPane.add(ButtonMinus, 3, 3);
        gridPane.add(ButtonMultiplication, 0, 4);
        gridPane.add(ButtonDivide, 1, 4);
        
        gridPane.add(log10Button, 2, 4);
        gridPane.add(ButtonSin, 3, 4);
        gridPane.add(ButtonDelete, 0, 5);
        gridPane.add(ButtonReset, 1, 5);
        gridPane.add(ButtonRightParanthesis, 2, 5);
        gridPane.add(ButtonLeftParanthesis, 3, 5);
        
        gridPane.add(Buttonx, 2, 6);
        
    }

    void WriteOnButton(Button function1, String infixOfFunction1) {
        Button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 0 ");
                infixOfFunction1.concat("0");
            }
        });
        
        Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 1 ");
                infixOfFunction1.concat("1");
            }
        });
        
        Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 2 ");
                infixOfFunction1.concat("2");
            }
        });
        
        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 3 ");
                infixOfFunction1.concat("3");
            }
        });
        
        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 4 ");
                infixOfFunction1.concat("4");
            }
        });
        
        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 5 ");
                infixOfFunction1.concat("5");
            }
        });
        
        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 6 ");
                infixOfFunction1.concat("6");
            }
        });
        
        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 7 ");
                infixOfFunction1.concat("7");
            }
        });
        
        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 8 ");
                infixOfFunction1.concat("8");
            }
        });
        
        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" 9 ");
                infixOfFunction1.concat("9");
            }
        });
        
        ButtonLeftParanthesis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" ( ");
                infixOfFunction1.concat("(");
            }
        });
        
        ButtonRightParanthesis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" ) ");
                infixOfFunction1.concat(")");
            }
        });
        
        ButtonMultiplication.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" * ");
                infixOfFunction1.concat("*");
            }
        });
        
        ButtonDivide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" / ");
                infixOfFunction1.concat("/");
            }
        });
        
        ButtonPlus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" + ");
                infixOfFunction1.concat("+");
            }
        });
        
        ButtonMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" - ");
                infixOfFunction1.concat("-");
            }
        });
        
        log10Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" log(  ");
                infixOfFunction1.concat("L");
            }
        });
        
        ButtonSin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                function1.setText(function1.getText()+" sin(  ");
                infixOfFunction1.concat("S");
            }
        });
        
      
        
    }
    
}
