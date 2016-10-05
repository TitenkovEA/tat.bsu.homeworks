package tat.bsu.homework.lesson1.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Receives from the keyboard length of the triangular sides,
 * and create triangle object.
 *
 * @version 1.00
 * @since 4 Oct 2016
 * @author Eugeny Titenkov
 */
public class TriangleUtil {
    /**
     * Read length of the triangular sides from the keyboard,
     * and return triangle with this sides.
     * @throws IOException - if a side could not be read.
     */
    public static Triangle build() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sideA;
        double sideB;
        double sideC;

        try {
            sideA = Double.parseDouble(reader.readLine());
            sideB = Double.parseDouble(reader.readLine());
            sideC = Double.parseDouble(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Number format error! Please, enter the numbers.");
            return null;
        }

        if (Double.isInfinite(sideA) || Double.isInfinite(sideB) || Double.isInfinite(sideC)) {
            System.out.println("Wrong length of side");
            return null;
        }
        return new Triangle(sideA, sideB, sideC);
    }
}
