package tat.bsu.homework.lesson1.task3;

/**
 *
        Print on display sum, subtraction, multiplication, division of two parameters.
 *
 * @version 1.01
        2 Oct 2016  * @author
        Eugeny Titenkov  */
public class Main {
    public static void main(String[] args) {

        if (ParametersChecker.check(args)){
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            Calculator.calculate(a, b);
        }
    }
}
