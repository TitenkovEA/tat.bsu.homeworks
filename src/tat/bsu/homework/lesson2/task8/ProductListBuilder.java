package tat.bsu.homework.lesson2.task8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * It creates lists of products, filling them with the keyboard.
 *
 * @author Eugeny Titenkov
 */
public class ProductListBuilder {
    private List<Product> products = new ArrayList<Product>();

    /**
     * It creates list of products, filling them with the keyboard.
     */
    public void buildListProducts() {
        Scanner scanner = new Scanner(System.in);
        String continueMessage = "y";
        do {
            products.add(buildProduct());
            System.out.println("Do you want to add another product? (Please, enter [y] " +
                    "if you want to continue, else inter [n]!)");
        } while (continueMessage.equalsIgnoreCase(scanner.next()));
    }

    /**
     * It creates product, filling them with the keyboard.
     *
     * @return finished product.
     */
    private Product buildProduct() {
        Scanner scanner = new Scanner(System.in);
        String type = null;
        String name = null;
        int count = 0;
        BigDecimal cost = null;
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("Please, enter the type of product.");
                type = scanner.next();
                System.out.println("Please, enter the name of product.");
                name = scanner.next();
                System.out.println("Please, enter the count of product.");
                count = scanner.nextInt();
                System.out.println("Please, enter the cost for one item of product.");
                cost = scanner.nextBigDecimal();
                flag = false;
            } catch (InputMismatchException e) {
                System.err.printf("%s  is wrong input type, try again! \n", scanner.next());
            }
        }
        return new Product(type, name, count, cost);
    }

    /**
     * Return list of products.
     *
     * @return list of products.
     */
    public List<Product> getProducts() {
        return products;
    }
}
