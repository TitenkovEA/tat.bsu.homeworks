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
        int size = 3;

        if (ParametersChecker.sizeCheck(size, coefficients)) {
            double coefficientA = coefficients[0];
            double coefficientB = coefficients[1];
            double coefficientC = coefficients[2];

            QuadraticEquation quadraticEquation = new QuadraticEquation(coefficientA,
                    coefficientB, coefficientC);
            quadraticEquation.findTheRoots();
        }
    }
}
