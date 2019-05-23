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
public class Function extends DrawAble {
    
    String func;

    @Override
    void draw(GraphicsContext gc, double X, double Y, double unitOfScale) {
        double xprev = gc.getCanvas().getBoundsInLocal().getMinX();
        double yprev = -function((xprev - X) / unitOfScale) * unitOfScale + Y;

        for (double x0 = xprev + 1; x0 <= gc.getCanvas().getBoundsInLocal().getMaxX(); x0++) {
//             x0=gc.getCanvas().getBoundsInLocal().getMaxX();
            double y0 = -function((x0 - X) / unitOfScale) * unitOfScale + Y;

            gc.strokeLine(x0, y0, xprev, yprev);
//             System.out.println(xprev+ " "+yprev+" "+x0+" "+y0);

            xprev = x0;
            yprev = y0;
//             break;
        }

    }
    
    double function(double  x)
    {
        return MathHelper.postfixToEvaluate(func, x);
        
    }

}
