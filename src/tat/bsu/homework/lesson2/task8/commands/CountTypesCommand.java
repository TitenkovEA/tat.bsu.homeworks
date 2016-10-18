package tat.bsu.homework.lesson2.task8.commands;

import tat.bsu.homework.lesson2.task8.Product;

import java.util.List;

/**
 * This command calculates count of type all products.
 *
 * @author Eugeny Titenkov
 */
public class CountTypesCommand implements Command {
    public final static String COUNT_TYPES = "count types";

    /**
     * Executes the command if it was called.
     *
     * @param commandName - name of command.
     * @param products    - list of products.
     */
    @Override
    public void execute(String commandName, List<Product> products) {
        if (commandName.equalsIgnoreCase(COUNT_TYPES)) {
            System.out.printf("Count of all types products: %s. \n", getCountTypes(products));
        }
    }

    /**
     * Return command name.
     *
     * @return command name.
     */
    @Override
    public String getCommandName() {
        return COUNT_TYPES;
    }

    /**
     * Calculates count of type all products.
     *
     * @param products - list of products.
     * @return count of type all products.
     */
    private int getCountTypes(List<Product> products) {
        int count = 1;
        String firstType = products.get(0).getType();

        for (Product product : products) {
            if (!product.getType().equals(firstType)) {
                count++;
            }
        }
        return count;
    }
}
