package tat.bsu.homework.lesson2.task8.commands;

import tat.bsu.homework.lesson2.task8.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * This command calculates average price of type all products.
 *
 * @author Eugeny Titenkov
 */
public class AveragePriceOfTypeCommand implements Command {
    public final static String AVERAGE_PRICE_OF = "average price of ";

    /**
     * Executes the command if it was called.
     *
     * @param commandName - name of command.
     * @param products    - list of products.
     */
    @Override
    public void execute(String commandName, List<Product> products) {
        int commandLength = AVERAGE_PRICE_OF.length();
        if (commandName.matches("^average price of .+$")) {
            String type = commandName.substring(commandLength);
            System.out.printf("Average price of %s: %s \n",
                    type, calculateAveragePriceOfType(type, products));
        }
    }

    /**
     * Return command name.
     *
     * @return command name.
     */
    @Override
    public String getCommandName() {
        return AVERAGE_PRICE_OF;
    }

    /**
     * Calculates average price of type all products.
     *
     * @param type     - type of products.
     * @param products - list of products.
     * @return average price of type all products.
     */
    private BigDecimal calculateAveragePriceOfType(String type, List<Product> products) {
        double count = 0.0;
        BigDecimal allCost = new BigDecimal(0);
        int scale = 2;
        for (Product product : products) {
            if (product.getType().equals(type)) {
                count += product.getCount();
                allCost = allCost.add(
                        product.getCost().multiply(BigDecimal.valueOf(product.getCount())));
            }
        }
        return allCost.divide(BigDecimal.valueOf(count), scale, BigDecimal.ROUND_HALF_UP);
    }
}
