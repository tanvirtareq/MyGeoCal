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
 public abstract class  DrawAble  {
    
    abstract void  draw(GraphicsContext gc, double X, double Y, double unitOfScale);
}
