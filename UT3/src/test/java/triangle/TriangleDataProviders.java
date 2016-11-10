package triangle;

import org.testng.annotations.DataProvider;

import java.io.File;

public class TriangleDataProviders {
    private static final String XML_DATA_FILE_PATH = "src" + File.separator +
            "data" + File.separator + "trianglesData.xml";
    private static final String NEGATIVE_TRIANGLE = "negative";
    private static final String SCALENE_TRIANGLE = "scalene";
    private static final String ISOSCELES_TRIANGLE = "isosceles";
    private static final String EQUILATERAL_TRIANGLE = "equilateral";

    @DataProvider(name = "notValidTriangleSides")
    public static Object[][] createNotValidTrianglesSides() throws Exception {
        TriangleXmlDataReader dataReader = new TriangleXmlDataReader(XML_DATA_FILE_PATH);
        return dataReader.getTriangles(NEGATIVE_TRIANGLE);
    }

    @DataProvider(name = "validTriangleSides")
    public static Object[][] createValidTrianglesSides() throws Exception {
        TriangleXmlDataReader dataReader = new TriangleXmlDataReader(XML_DATA_FILE_PATH);
        Object[][] scaleneTriangles = dataReader.getTriangles(SCALENE_TRIANGLE);
        Object[][] isoscelesTriangles = dataReader.getTriangles(ISOSCELES_TRIANGLE);
        Object[][] equilateralTriangles = dataReader.getTriangles(EQUILATERAL_TRIANGLE);

        int fullSize = scaleneTriangles.length + isoscelesTriangles.length +
                equilateralTriangles.length;
        Object[][] result = new Object[fullSize][];
        for (int i = 0; i < scaleneTriangles.length; i++) {
            result[i] = scaleneTriangles[i];
        }
        for (int i = 0; i < isoscelesTriangles.length; i++) {
            result[i + scaleneTriangles.length] = isoscelesTriangles[i];
        }
        for (int i = 0; i < equilateralTriangles.length; i++) {
            result[i + scaleneTriangles.length +
                    isoscelesTriangles.length] = equilateralTriangles[i];
        }

        return result;
    }
}
