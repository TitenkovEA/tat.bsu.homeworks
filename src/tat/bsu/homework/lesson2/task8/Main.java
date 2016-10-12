package tat.bsu.homework.lesson2.task8;

import tat.bsu.homework.lesson2.task8.commands.AveragePriceCommand;
import tat.bsu.homework.lesson2.task8.commands.AveragePriceOfTypeCommand;
import tat.bsu.homework.lesson2.task8.commands.CountAllCommand;
import tat.bsu.homework.lesson2.task8.commands.CountTypesCommand;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static final int GENERIC_ERROR = 1;

    /**
     * It creates a list of products, then requests the commands.
     *
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        try {
            ProductListBuilder productListBuilder = new ProductListBuilder();
            productListBuilder.BuildListProducts();
            CommandCaller commandCaller = new CommandCaller().add(new CountAllCommand())
                    .add(new CountTypesCommand())
                    .add(new AveragePriceCommand())
                    .add(new AveragePriceOfTypeCommand());
            commandCaller.callCommands(productListBuilder.getProducts());
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
