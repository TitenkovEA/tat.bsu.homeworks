package tat.bsu.homework.lesson1.task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * Receives from the keyboard length of the triangular sides.
 * And print short information about this triangle.
 *
 * @version 1.00
 * @since 4 Oct 2016
 * @author Eugeny Titenkov
 */
public class Main {
    /**
     * Read length of the triangular sides from the keyboard.
     * Print information about this triangle.
     * @param args - command line parameters.
     * @throws IOException - if a side could not be read.
     */
    public static void main(String[] args) throws IOException {
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
            return;
        }

        if (Double.isInfinite(sideA) || Double.isInfinite(sideB) || Double.isInfinite(sideC)) {
            System.out.println("Wrong length of side");
        } else {
            Triangle triangle = new Triangle(sideA, sideB, sideC);
            triangle.printInfo();
        }
    }
}
