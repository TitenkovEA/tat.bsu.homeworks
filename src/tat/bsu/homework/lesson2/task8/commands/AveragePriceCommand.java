package tat.bsu.homework.lesson2.task8.commands;

import tat.bsu.homework.lesson2.task8.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * This command calculates average price of all products.
 *
 * @author Eugeny Titenkov
 */
public class AveragePriceCommand implements Command {
    public final static String AVERAGE_PRICE = "average price";

    /**
     * Executes the command if it was called.
     *
     * @param commandName - name of command.
     * @param products    - list of products.
     */
    @Override
    public void execute(String commandName, List<Product> products) {
        if (commandName.equalsIgnoreCase(AVERAGE_PRICE)) {
            System.out.printf("Average price: %s. \n", calculateAveragePrice(products));
        }
    }

    /**
     * Return command name.
     *
     * @return command name.
     */
    @Override
    public String getCommandName() {
        return AVERAGE_PRICE;
    }

    /**
     * Calculates average price of all products.
     *
     * @param products - list of products.
     * @return average price of all products.
     */
    private BigDecimal calculateAveragePrice(List<Product> products) {
        double count = 0.0;
        BigDecimal allCost = new BigDecimal(0);
        int scale = 2;
        for (Product product : products) {
            count += product.getCount();
            allCost = allCost.add(
                    product.getCost().multiply(BigDecimal.valueOf(product.getCount())));
        }
        return allCost.divide(BigDecimal.valueOf(count), scale, BigDecimal.ROUND_HALF_UP);
    }
}
