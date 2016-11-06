package triangle;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleTest {
    @Test(dataProvider = "notValidTriangleSides", dataProviderClass = TriangleDataProviders.class,
            expectedExceptions = Exception.class)
    public void negativeTriangleConstructor(double sideA, double sideB, double sideC) throws Exception {
        new Triangle(sideA, sideB, sideC);
    }

    @Test(dataProvider = "scaleneTriangleSides", dataProviderClass = TriangleDataProviders.class)
    public void positiveGetTriangleTypeOfScalene(double sideA, double sideB, double sideC) throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), Triangle.SCALENE_TYPE);
    }

    @Test(dataProvider = "isoscelesTriangleSides", dataProviderClass = TriangleDataProviders.class)
    public void positiveGetTriangleTypeOfIsosceles(double sideA, double sideB, double sideC) throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), Triangle.ISOSCELES_TYPE);
    }

    @Test(dataProvider = "equilateralTriangleSides", dataProviderClass = TriangleDataProviders.class)
    public void positiveGetTriangleTypeOfEquilatera(double sideA, double sideB, double sideC) throws Exception {
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        assertEquals(triangle.getTriangleType(), Triangle.EQUILATERAL_TYPE);
    }
}