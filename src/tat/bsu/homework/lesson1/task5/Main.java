package tat.bsu.homework.lesson1.task5;

import java.io.IOException;

/**
 * Receives from the keyboard length of the triangular sides.
 * And print short information about this triangle.
 *
 * @version 2.00
 * @since 4 Oct 2016
 * @author Eugeny Titenkov
 */
public class Main {
    /**
     * Read length of the triangular sides from the keyboard.
     * Print information about this triangle.
     * @param args - command line parameters.
     * @throws IOException - if a triangle could not be built.
     */
    public static void main(String[] args) throws IOException {
        Triangle triangle = TriangleUtil.build();

        if (triangle != null) {
            triangle.printInfo();
        }
    }
}
