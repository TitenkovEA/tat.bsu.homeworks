package tat.bsu.homework.lesson1.task3;

/**
 *
        Performs computational operations.
 *
 * @version 1.01
        2 Oct 2016  * @author
        Eugeny Titenkov  */
public class Calculator {
    /**
     * Calculate sum, subtraction, multiplication, division,
     * and print on display.
     * @param a first parameter.
     * @param b second parameter.
     */
    public static void calculate(double a, double b) {

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        if ((a / b) == Double.POSITIVE_INFINITY) {
            System.out.println("Error. Division by zero");
        } else if ((a / b) == Double.NEGATIVE_INFINITY) {
            System.out.println("Error. Division by zero");
        } else {
            System.out.println("Division: " + (a / b));
        }
    }
}
