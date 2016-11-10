package triangle;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Allows read xml triangles data file.
 */
public class TriangleXmlDataReader {
    private static final String NEGATIVE_TRIANGLE = "negative";
    private static final String SIDE_A = "side_a";
    private static final String SIDE_B = "side_b";
    private static final String SIDE_C = "side_c";
    private static final String DOUBLE_MAX = "max";
    private static final String DOUBLE_MIN = "min";

    private Document document;

    /**
     * Creates object of TriangleXmlDataReader with parsed document.
     *
     * @param filePath - file to parse.
     * @throws Exception if there were some troubles during parsing.
     */
    public TriangleXmlDataReader(String filePath)
            throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File(filePath));
    }

    /**
     * Returns array of sides triangles, with the given type.
     *
     * @param triangleType - the given type of triangle.
     * @return array of sides triangles.
     */
    public Object[][] getTriangles(String triangleType) {
        NodeList triangles = document.getElementsByTagName(triangleType);
        Object[][] result = new Object[triangles.getLength()][];
        for (int i = 0; i < triangles.getLength(); i++) {
            result[i] = getTriangleSides(triangles.item(i).getAttributes(),
                    triangleType);
        }
        return result;
    }

    /**
     * Returns array of sides triangle, with type of triangle it he exist.
     *
     * @param namedNodeMap - object of NamedNodeMap.
     * @param triangleType - type of triangle.
     * @return array of sides triangle, with type of triangle it he exist.
     */
    private Object[] getTriangleSides(NamedNodeMap namedNodeMap, String triangleType) {
        return (triangleType.equals(NEGATIVE_TRIANGLE)) ? new Object[]{
                getDoubleValue(namedNodeMap.getNamedItem(SIDE_A)),
                getDoubleValue(namedNodeMap.getNamedItem(SIDE_B)),
                getDoubleValue(namedNodeMap.getNamedItem(SIDE_C)),
        } : new Object[]{
                triangleType,
                getDoubleValue(namedNodeMap.getNamedItem(SIDE_A)),
                getDoubleValue(namedNodeMap.getNamedItem(SIDE_B)),
                getDoubleValue(namedNodeMap.getNamedItem(SIDE_C)),
        };
    }

    /**
     * Returns side of triangle from node.
     *
     * @param node - object of Node.
     * @return side of triangle type of double.
     */
    private double getDoubleValue(Node node) {
        String nodeValue = node.getNodeValue();
        if (nodeValue.equals(DOUBLE_MAX)) {
            return Double.MAX_VALUE;
        } else if (nodeValue.equals(DOUBLE_MIN)) {
            return Double.MIN_VALUE;
        } else {
            return Double.parseDouble(nodeValue);
        }
    }
}
