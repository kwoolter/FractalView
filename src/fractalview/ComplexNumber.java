/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalview;

/**
 *
 * @author JaneW
 */
public class ComplexNumber {

    private double dReal, dImaginary;

    public ComplexNumber(double dReal, double dImaginary) {
        this.dReal = dReal;
        this.dImaginary = dImaginary;
    }

    public ComplexNumber add(ComplexNumber cnAdd) {

        return new ComplexNumber(this.dReal + cnAdd.dReal,
                this.dImaginary + cnAdd.dImaginary);


    }

    public double getdImaginary() {
        return dImaginary;
    }

    public double getdReal() {
        return dReal;
    }

    
    
    public ComplexNumber add(double dAdd) {

        return new ComplexNumber(this.dReal + dAdd, this.dImaginary);

    }

    // multiplication: (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
    public ComplexNumber multiply(ComplexNumber cnAdd) {

        return new ComplexNumber(
                (this.dReal * cnAdd.dReal) - (this.dImaginary * cnAdd.dImaginary),
                (this.dReal * cnAdd.dImaginary) + (this.dImaginary * cnAdd.dReal));

    }

    public double magnitude() {
        double dAbsolute = 0;

        dAbsolute = Math.sqrt((this.dReal * this.dReal) + (this.dImaginary * this.dImaginary));

        return dAbsolute;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.dReal) != Double.doubleToLongBits(other.dReal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.dImaginary) != Double.doubleToLongBits(other.dImaginary)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.dReal) ^ (Double.doubleToLongBits(this.dReal) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.dImaginary) ^ (Double.doubleToLongBits(this.dImaginary) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + "dReal=" + dReal + ", dImaginary=" + dImaginary + '}';
    }
}
