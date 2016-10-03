package tat.bsu.homework.lesson1.task3;

/**
 *
 *      Print on display sum, subtraction, multiplication, division of two parameters.
 *
 * @version 1.02
 *      3 Oct 2016
 * @author Eugeny Titenkov  */
public class Main {
    /**
     * Check command line parameters, and making calculation operations.
     * With ParametersChecker and Calculator classes help.
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        double[] parameters = ParametersChecker.convertParametersToDouble(args);

        if (ParametersChecker.sizeCheck(parameters)) {
            Calculator.calculate(parameters[0], parameters[1]);
        }
    }
}
