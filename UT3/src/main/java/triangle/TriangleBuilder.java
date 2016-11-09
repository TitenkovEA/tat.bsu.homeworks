package triangle;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Receives from the keyboard length of the triangular sides,
 * and create triangle object.
 *
 * @author Eugeny Titenkov
 */
public class TriangleBuilder {
    /**
     * Read length of the triangular sides from the keyboard,
     * and return triangle with this sides.
     *
     * @return object of Triangle.
     */
    public Triangle build() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sideA;
        double sideB;
        double sideC;
        Triangle triangle;

        try {
            sideA = Double.parseDouble(reader.readLine());
            sideB = Double.parseDouble(reader.readLine());
            sideC = Double.parseDouble(reader.readLine());
            triangle = new Triangle(sideA, sideB, sideC);
        } catch (NumberFormatException e) {
            System.err.println("Number format error! Please, enter the numbers.");
            return null;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
        return triangle;
    }
}
