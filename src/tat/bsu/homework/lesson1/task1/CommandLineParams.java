package tat.bsu.homework.lesson1.task1;

/**
 *
        Inverse print of command line parameters.
 *
 * @version 1.01
        2 Oct 2016  * @author
        Eugeny Titenkov  */
public class CommandLineParams {
    public static void main(String[] args) {

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.printf("Argument %s = %s \n", i, args[i]);
        }
    }
}
