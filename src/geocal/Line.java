/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocal;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Tanvir Tareq
 */
public class Line extends DrawAble{
    double x1, y1, x2, y2;

    public Line(double x1,double y1,double x2,double y2) {
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        
    }
    
    
    

    @Override
    void draw(GraphicsContext gc, double X, double Y, double unitOfScale) {
        double x1=MathHelper.changedX(this.x1, X, unitOfScale);
        double y1=MathHelper.changedY(this.y1, Y, unitOfScale);
        
        double x2=MathHelper.changedX(this.x2, X, unitOfScale);
        double y2=MathHelper.changedY(this.y2, Y, unitOfScale);
        
//        System.out.println(x1+" "+y1+" "+x2+" "+y2);
//        System.out.println(this.x1+" "+this.y1+" "+this.x2+" "+this.y2+" "+X+" "+Y);
//        
        
        gc.strokeLine(x1, y1, x2, y2);
        
    }
    
    
    
}
