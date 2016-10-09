package tat.bsu.homework.lesson2.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Allows you to read from the keyboard.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
abstract public class FromKeyboardReader {
    /**
     * Read string from keyboard.
     *
     * @return a read line.
     * @throws IOException if string can't be built.
     */
    public static String stringRead() throws IOException {
        System.out.println("Enter your text.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
