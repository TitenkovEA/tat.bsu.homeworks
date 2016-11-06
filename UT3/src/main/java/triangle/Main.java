package triangle;

/**
 * Receives from the keyboard length of the triangular sides.
 * And print short information about this triangle.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static final int GENERIC_ERROR = 1;

    /**
     * Read length of the triangular sides from the keyboard.
     * Print information about this triangle.
     *
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        try {
            Triangle triangle = null;
            TriangleBuilder triangleBuilder = new TriangleBuilder();
            while (triangle == null) {
                System.out.println("Enter triangle sides");
                triangle = triangleBuilder.build();
            }
            System.out.printf("Triangle is %s.", triangle.getTriangleType());
        } catch (Exception e) {
            System.err.println("Detected error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
