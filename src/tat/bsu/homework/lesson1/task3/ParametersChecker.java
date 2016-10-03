package tat.bsu.homework.lesson1.task3;

/**
 *
 * Checks a command line parameters.
 *
 * @version 1.02
 * @since 3 Oct 2016
 * @author Eugeny Titenkov
 */
public class ParametersChecker {
    /**
     * Checking on two elements.
     * @param parameters - command line parameters.
     */
    public static boolean sizeCheck(double[] parameters) {
        if (parameters.length > 2) {
            System.err.print("A lot of input parameters! \n" +
                    "Please, enter the two numbers in the parameters. \n");

            return false;
        } else if (parameters.length < 2) {
            System.err.print("Array index out error! \n" +
                    "Please, enter the two numbers in the parameters. \n");

            return false;
        }

        return true;
    }
    /**
     * Convert string parameters to double, with checking on numbers format.
     * @param array - string parameters.
     */
    public static double[] convertParametersToDouble(String[] array) {
        double[] parametersInDouble = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            try {
                parametersInDouble[i] = Double.parseDouble(array[i]);
            } catch (NumberFormatException e) {
                System.err.print("Number format error! \n" +
                        "Please, enter the numbers in the parameters. \n");

                return new double[0];
            }
        }

        return parametersInDouble;
    }
}
