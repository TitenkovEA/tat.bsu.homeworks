package triangle;

import java.math.BigDecimal;

/**
 * Model of triangle.
 * With method of short information, about the triangle.
 *
 * @author Eugeny Titenkov
 */
public class Triangle {
    public static final String EQUILATERAL_TYPE = "equilateral";
    public static final String ISOSCELES_TYPE = "isosceles";
    public static final String SCALENE_TYPE = "scalene";

    /* Triangle sides */
    private double sideA;
    private double sideB;
    private double sideC;

    /**
     * Create object of triangle with received sides.
     *
     * @param sideA - side A.
     * @param sideB - side B.
     * @param sideC - side C.
     * @throws Exception if triangle can't be build.
     */
    public Triangle(double sideA, double sideB, double sideC) throws Exception {
        if (!validateOnBuilding(sideA, sideB, sideC)) {
            throw new Exception("This triangle can't be build.");
        } else {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
    }

    /**
     * Return triangle type.
     *
     * @return type of triangle.
     */
    public String getTriangleType() {
        if (Double.compare(sideA, sideB) == 0 && Double.compare(sideA, sideC) == 0) {
            return EQUILATERAL_TYPE;
        } else if (Double.compare(sideA, sideB) == 0 ||
                Double.compare(sideA, sideC) == 0 ||
                Double.compare(sideC, sideB) == 0) {
            return ISOSCELES_TYPE;
        } else {
            return SCALENE_TYPE;
        }
    }

    /**
     * Validate triangle on building.
     *
     * @param sideA - first side.
     * @param sideB - second side.
     * @param sideC - third side.
     * @return true, if triangle can be build, else false.
     */
    private boolean validateOnBuilding(double sideA, double sideB, double sideC) {
        if (!validateSide(sideA) || !validateSide(sideB) || !validateSide(sideC)) {
            return false;
        } else {
            BigDecimal sumOfSideASideB = BigDecimal.valueOf(sideA).add(BigDecimal.valueOf(sideB));
            BigDecimal sumOfSideASideC = BigDecimal.valueOf(sideA).add(BigDecimal.valueOf(sideC));
            BigDecimal sumOfSideBSideC = BigDecimal.valueOf(sideB).add(BigDecimal.valueOf(sideC));
            return (sumOfSideASideB.compareTo(BigDecimal.valueOf(sideC)) > 0 &&
                    sumOfSideASideC.compareTo(BigDecimal.valueOf(sideB)) > 0 &&
                    sumOfSideBSideC.compareTo(BigDecimal.valueOf(sideA)) > 0);
        }
    }

    /**
     * Validates side of triangle.
     *
     * @param side - side of triangle.
     * @return true if side is valid, else false.
     */
    private boolean validateSide(double side) {
        return !(Double.valueOf(side).isNaN() || Double.valueOf(side).isInfinite() || side <= 0);
    }
}
