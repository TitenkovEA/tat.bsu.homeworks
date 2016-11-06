package triangle;

import org.testng.annotations.DataProvider;

public class TriangleDataProviders {
    @DataProvider(name = "notValidTriangleSides")
    public static Object[][] createNotValidTrianglesSides() {
        return new Object[][]{
                {Double.NaN, 2, 3},
                {2, Double.NaN, 3},
                {2, 3, Double.NaN},
                {Double.NaN, Double.NaN, Double.NaN},
                {Double.NaN, 2, Double.NaN},
                {Double.NaN, Double.NaN, 2},
                {2, Double.NaN, Double.NaN},
                {Double.POSITIVE_INFINITY, 2, 3},
                {2, Double.POSITIVE_INFINITY, 3},
                {2, 3, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                {2, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, 2, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2},
                {Double.NEGATIVE_INFINITY, 2, 3},
                {2, Double.NEGATIVE_INFINITY, 3},
                {2, 3, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {2, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, 2, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 2},
                {0, 0, 0},
                {0, 0, 3},
                {0, 3, 0},
                {3, 0, 0},
                {0, 2, 3},
                {2, 0, 3},
                {3, 2, 0},
                {1, 1, Double.MAX_VALUE},
                {1, Double.MAX_VALUE, 1},
                {Double.MAX_VALUE, 1, 1},
                {Double.MIN_VALUE, Double.MIN_VALUE, 1},
                {Double.MIN_VALUE, 1, Double.MIN_VALUE},
                {1, Double.MIN_VALUE, Double.MIN_VALUE},
                {1, 1, -1},
                {1, -1, 1},
                {-1, 1, 1},
                {-1, -1, 1},
                {1, -1, -1},
                {-1, 1, -1},
                {-1, -1, -1},
                {20, 2, 4},
                {2, 20, 4},
                {2, 2, 40},
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
    }

    @DataProvider(name = "scaleneTriangleSides")
    public static Object[][] createScaleneTriangleSides() {
        return new Object[][]{
                {3, 4, 6},
                {6, 3, 4},
                {4, 6, 3},
                {Double.MAX_VALUE, 1.7976931348623155E+308, 1.7976931348623153E+308},
                {1.7976931348623153E+308, Double.MAX_VALUE, 1.7976931348623155E+308},
                {1.7976931348623155E+308, 1.7976931348623153E+308, Double.MAX_VALUE},
                {Double.MIN_VALUE, 2.2250738585072011E-308, 2.2250738585072014E-308},
                {2.2250738585072014E-308, Double.MIN_VALUE, 2.2250738585072011E-308},
                {2.2250738585072011E-308, 2.2250738585072014E-308, Double.MIN_VALUE}
        };
    }

    @DataProvider(name = "isoscelesTriangleSides")
    public static Object[][] createIsoscelesTriangleSides() {
        return new Object[][]{
                {2, 3, 3},
                {3, 3, 2},
                {3, 2, 3},
                {1, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MAX_VALUE, 1, Double.MAX_VALUE},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1},
                {Double.MIN_VALUE, 1, 1},
                {1, Double.MIN_VALUE, 1},
                {1, 1, Double.MIN_VALUE}
        };
    }

    @DataProvider(name = "equilateralTriangleSides")
    public static Object[][] createEquilateralTriangleSides() {
        return new Object[][]{
                {3, 3, 3},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}
        };
    }
}
