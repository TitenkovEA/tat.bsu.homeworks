package tat.bsu.homework.lesson1.task4;

/**
 *
 * Print on display roots of quadratic equation.
 *
 * @version 1.00
 * @since 4 Oct 2016
 * @author Eugeny Titenkov
 */
public class Main {
    /**
     * Find and print roots of quadratic equation.
     * With ParametersChecker and QuadraticEquation classes help.
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        double[] coefficients = ParametersChecker.convertParametersToDouble(args);

        if (ParametersChecker.sizeCheck(3, coefficients)) {
            QuadraticEquation quadraticEquation = new QuadraticEquation(coefficients[0],
                    coefficients[1], coefficients[2]);

            quadraticEquation.findTheRoots();
        }
    }
}
