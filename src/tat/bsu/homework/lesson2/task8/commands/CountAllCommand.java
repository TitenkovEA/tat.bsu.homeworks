package tat.bsu.homework.lesson2.task8.commands;

import tat.bsu.homework.lesson2.task8.Product;

import java.util.List;

/**
 * This command calculates count of all products.
 *
 * @author Eugeny Titenkov
 */
public class CountAllCommand implements Command {
    public final static String COUNT_ALL = "count all";

    /**
     * Executes the command if it was called.
     *
     * @param commandName - name of command.
     * @param products    - list of products.
     */
    @Override
    public void execute(String commandName, List<Product> products) {
        if (commandName.equalsIgnoreCase(COUNT_ALL)) {
            System.out.printf("Quantity of all products: %s. \n", countAll(products));
        }
    }

    /**
     * Return command name.
     *
     * @return command name.
     */
    @Override
    public String getCommandName() {
        return COUNT_ALL;
    }

    /**
     * Calculates count of all products.
     *
     * @param products - list of products.
     * @return count of all products.
     */
    private int countAll(List<Product> products) {
        int count = 0;
        for (Product product : products) {
            count += product.getCount();
        }
        return count;
    }
}
