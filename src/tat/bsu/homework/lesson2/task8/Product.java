package tat.bsu.homework.lesson2.task8;

import java.math.BigDecimal;

/**
 * Model of product.
 *
 * @author Eugeny Titenkov
 */
public class Product {
    private String type;
    private String name;
    private int count;
    private BigDecimal cost = null;

    /**
     * Product constructor, create object of product.
     *
     * @param type  - type of product.
     * @param name  - name of product.
     * @param count - count of product.
     * @param cost  - cost of product.
     */
    public Product(String type, String name, int count, BigDecimal cost) {
        this.type = type;
        this.name = name;
        this.count = count;
        this.cost = cost;
    }

    /**
     * Return type of product.
     *
     * @return type of product
     */
    public String getType() {
        return type;
    }

    /**
     * Return name of product.
     *
     * @return name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Return count of product.
     *
     * @return count of product
     */
    public int getCount() {
        return count;
    }

    /**
     * Return cost of product.
     *
     * @return cost of product
     */
    public BigDecimal getCost() {
        return cost;
    }
}
