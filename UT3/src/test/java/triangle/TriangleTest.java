package triangle;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {
    @Test(dataProvider = "notValidTriangleSides", dataProviderClass = TriangleDataProviders.class,
            expectedExceptions = Exception.class)
    public void negativeTriangleConstructor(double sideA, double sideB, double sideC)
            throws Exception {
        new Triangle(sideA, sideB, sideC);
    }

    @Test(dataProvider = "validTriangleSides", dataProviderClass = TriangleDataProviders.class)
    public void positiveGetTriangleType(String triangleType,
                                        double sideA, double sideB, double sideC)
            throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), triangleType);
    }
}