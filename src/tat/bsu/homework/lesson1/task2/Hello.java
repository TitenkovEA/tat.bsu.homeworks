package tat.bsu.homework.lesson1.task2;

/**
 *
 *      Displays "Hello, username.".
 *      Username receives from the command line parameters.
 *
 * @version 1.02
 *      3 Oct 2016
 * @author Eugeny Titenkov  */
public class Hello {
    /**
     * Print "Hello, username.".
     * @param args - username.
     */
    public static void main(String[] args) {
        StringBuilder username = new StringBuilder("");
        /* If the username contain several words, unites them in one string. */
        for (String str : args) {
            username.append(" ").append(str);
        }
        System.out.println("Hello," + username + ".");
    }
}
