package triangle;

import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class TriangleDataProviders {
    private static final String XML_DATA_FILE_PATH = "src" + File.separator +
            "data" + File.separator + "trianglesData.xml";
    private static final String NEGATIVE_TRIANGLE = "negative";
    private static final String SCALENE_TRIANGLE = "scalene";
    private static final String ISOSCELES_TRIANGLE = "isosceles";
    private static final String EQUILATERAL_TRIANGLE = "equilateral";
    private static final String SIDE_A = "side_a";
    private static final String SIDE_B = "side_b";
    private static final String SIDE_C = "side_c";

    @DataProvider(name = "notValidTriangleSides")
    public static Object[][] createNotValidTrianglesSides()
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(XML_DATA_FILE_PATH));

        NodeList negativeTriangles = document.getElementsByTagName(NEGATIVE_TRIANGLE);
        Object[][] result = new Double[negativeTriangles.getLength()][];
        for (int i = 0; i < negativeTriangles.getLength(); i++) {
            NamedNodeMap namedNodeMap = negativeTriangles.item(i).getAttributes();
            result[i] = new Double[]{
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_C).getNodeValue()),
            };
        }

        return result;
    }

    @DataProvider(name = "validTriangleSides")
    public static Object[][] createValidTrianglesSides()
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(XML_DATA_FILE_PATH));

        NodeList scaleneTriangles = document.getElementsByTagName(SCALENE_TRIANGLE);
        NodeList isoscelesTriangles = document.getElementsByTagName(ISOSCELES_TRIANGLE);
        NodeList equilateralTriangles = document.getElementsByTagName(EQUILATERAL_TRIANGLE);
        int fullLength = scaleneTriangles.getLength() + isoscelesTriangles.getLength() +
                equilateralTriangles.getLength();
        Object[][] result = new Object[fullLength][];
        for (int i = 0; i < scaleneTriangles.getLength(); i++) {
            NamedNodeMap namedNodeMap = scaleneTriangles.item(i).getAttributes();
            result[i] = new Object[]{
                    SCALENE_TRIANGLE,
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        for (int i = 0; i < isoscelesTriangles.getLength(); i++) {
            NamedNodeMap namedNodeMap = isoscelesTriangles.item(i).getAttributes();
            result[i + scaleneTriangles.getLength()] = new Object[]{
                    ISOSCELES_TRIANGLE,
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_C).getNodeValue()),
            };
        }
        for (int i = 0; i < equilateralTriangles.getLength(); i++) {
            NamedNodeMap namedNodeMap = equilateralTriangles.item(i).getAttributes();
            result[i + scaleneTriangles.getLength() +
                    isoscelesTriangles.getLength()] = new Object[]{
                    EQUILATERAL_TRIANGLE,
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_A).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_B).getNodeValue()),
                    Double.parseDouble(namedNodeMap.getNamedItem(SIDE_C).getNodeValue()),
            };
        }

        return result;
    }
}
