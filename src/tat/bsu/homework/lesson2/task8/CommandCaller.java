package tat.bsu.homework.lesson2.task8;

import tat.bsu.homework.lesson2.task8.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * It's contain a list of commands, and calls them depending of
 * the input command, entered from the keyboard.
 *
 * @author Eugeny Titenkov
 */
public class CommandCaller {
    private List<Command> commands = new ArrayList<Command>();

    /**
     * Add command to commands list.
     *
     * @param command - command to add.
     * @return this.
     */
    public CommandCaller add(Command command) {
        commands.add(command);
        return this;
    }

    /**
     * Call the input command, entered from the keyboard.
     *
     * @param products - list of product.
     */
    public void callCommands(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        String commandName;
        String endMessage = "exit";

        displayCommandNames();
        do {
            System.out.println("If you want to finish, enter [exit]. \n" +
                    "Please, inter a command:");
            commandName = scanner.nextLine();
            for (Command command : commands) {
                command.execute(commandName, products);
            }
        } while (!commandName.equalsIgnoreCase(endMessage));
        scanner.close();
    }

    /**
     * Display all supported command.
     */
    private void displayCommandNames() {
        System.out.println("Supported commands:");
        for (Command command : commands) {
            System.out.println(command.getCommandName());
        }
    }
}
