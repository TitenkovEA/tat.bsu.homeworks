package tat.bsu.homework.lesson1.task5;

/**
 *
 * Model of triangle.
 * With method of short information, about the triangle.
 *
 * @version 1.00
 * @since 4 Oct 2016
 * @author Eugeny Titenkov
 */
public class Triangle {
    /* Triangle sides */
    private double sideA;
    private double sideB;
    private double sideC;
    /**
     * Constructor of triangle.
     * @param sideA - side A.
     * @param sideB - side B.
     * @param sideC - side C.
     */
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    /**
     * Print information about a triangle, with verification.
     */
    public void printInfo() {
        if (verification()) {
            if ((sideA == sideB && sideA == sideC)) {
                System.out.println("Triangle is equilateral");
            } else if (sideA == sideB || sideB == sideC || sideC == sideA) {
                System.out.println("Triangle is isosceles");
            } else {
                System.out.println("Triangle is scalene");
            }
        }
    }
    /**
     * Check triangle on building.
     */
    private boolean verification(){
        if ((sideB + sideC) > sideA && (sideA + sideC) > sideB && (sideA + sideB) > sideC) {
            return true;
        } else {
            System.err.println("Error. Wrong sides. Triangle can't be build");
            return false;
        }
    }
}
