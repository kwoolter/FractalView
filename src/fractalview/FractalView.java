/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalview;

// http://www.daniweb.com/software-development/java/code/230242/generating-a-basic-fractal
/**
 *
 * @author JaneW
 */
public class FractalView {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FractalModel model = new FractalModel(10, -2.5, -1.5, 1, 1);



        System.out.println("Main");

        ComplexNumber cn = new ComplexNumber(-2, 0.2);
        ComplexNumber cn2 = new ComplexNumber(0.015, 0.015);

        System.out.println(model.iterate(new ComplexNumber(0, 0), cn));
        System.out.println(model.iterate(new ComplexNumber(0, 0), cn2));



        System.out.println(cn);
        System.out.println(cn2);

        cn.multiply(cn2);

        System.out.println(cn.multiply(cn2));


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ViewMainFrame().setVisible(true);
            }
        });

    }
}
