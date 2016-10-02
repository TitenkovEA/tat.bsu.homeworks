package tat.bsu.homework.lesson1.task3;

/**
 *
        Checks a command line parameters.
 *
 * @version 1.01
        2 Oct 2016  * @author
        Eugeny Titenkov  */
public class ParametersChecker {
    /**
     * Checking on two numbers.
     * @param array - command line parameters.
     */
    public static boolean check(String[] array) {

        if (array.length > 2) {
            System.err.print("A lot of input parameters! \n" +
                    "Please, enter the two numbers in the parameters.");

            return false;
        } else {
            try {
                Double.parseDouble(array[0]);
                Double.parseDouble(array[1]);
            } catch (RuntimeException e){
                System.err.print("Number format or array index out error! \n" +
                        "Please, enter the two numbers in the parameters.");

                return false;
            }
        }

        return true;
    }
}
