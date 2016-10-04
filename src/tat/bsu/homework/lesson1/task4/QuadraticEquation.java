package tat.bsu.homework.lesson1.task4;

/**
 *
 * Model of quadratic equation.
 * With method of finding the roots.
 *
 * @version 1.00
 * @since 4 Oct 2016
 * @author Eugeny Titenkov
 */
public class QuadraticEquation {
    /* coefficients of quadratic equation */
    private double a;
    private double b;
    private double c;
    /**
     * Constructor of quadratic equation.
     * @param a - first coefficient.
     * @param b - second coefficient.
     * @param c - third coefficient.
     */
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Find the roots, and print they.
     */
    public void findTheRoots() {
        Double discriminant = (b * b) - (4 * a * c);

        if (discriminant > 0 ) {
            double sqrdDiscriminant = Math.sqrt(discriminant);
            double x1 = (-b + sqrdDiscriminant) / (2 * a);
            double x2 = (-b - sqrdDiscriminant) / (2 * a);

            if (verification(x1) && verification(x2)) {
                System.out.println("Find two root. X1 = " + x1 +
                        " X2 = " + x2 + ".");
            }
        } else if (discriminant.equals(0.0)) {
            double x = -b / (2 * a);

            if (verification(x)) {
                System.out.println("Find one root. X1 = " + x + ".");
            }
        } else if (discriminant < 0) {
            System.out.println("Discriminant < 0. No real roots.");
        }
    }
    /**
     * Verify value on NaN and infinite.
     * @param value - value to test.
     */
    private boolean verification(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)){
            System.err.println("Detected division by zero");
            return false;
        } else {
            return true;
        }
    }
}
