/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalview;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

/**
 *
 * @author JaneW
 */
public class FractalModel {

    private int iIterations;
    private double dMaxX, dMinX, dMaxY, dMinY, dMaxMagnitude;
    private Rectangle2D.Double rectDomain;

    public FractalModel(int iIterations, double dMinX, double dMinY, double dMaxX, double dMaxY) {
        this.iIterations = iIterations;
        this.rectDomain = new Rectangle2D.Double(dMinX, dMinY, dMaxX - dMinX, dMaxY - dMinY);
        dMaxMagnitude = 100;
    }

    public FractalModel(int iIterations, double dMagnitude) {
        this.iIterations = iIterations;
        dMaxMagnitude = dMagnitude;
    }

    public double iterate(ComplexNumber cnStart, ComplexNumber cnConstant) {
        int i = 0;
        boolean bStop = false;
        Point2D.Double point;
        ComplexNumber cn = cnStart;
        double dSmooth;

        while (i <= iIterations && bStop == false) {
            i++;
            cn = cn.multiply(cn).add(cnConstant);


            point = new Point2D.Double(cn.getdReal(), cn.getdImaginary());
            if (cn.magnitude() > dMaxMagnitude) {

                bStop = true;
            }
        }
        
        dSmooth = i + 1 - Math.log(Math.log(cn.magnitude()))/Math.log(2);

        return dSmooth/iIterations;
    }

    public void setMagnitude(double dMaxMagnitude) {
        this.dMaxMagnitude = dMaxMagnitude;
    }

    public void setIterations(int iIterations) {
        this.iIterations = iIterations;
    }
}
