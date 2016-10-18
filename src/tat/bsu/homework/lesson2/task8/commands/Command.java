package tat.bsu.homework.lesson2.task8.commands;

import tat.bsu.homework.lesson2.task8.Product;

import java.util.List;

/**
 * Represents command interface.
 * Contains command execution method.
 *
 * @author Eugeny Titenkov
 */
public interface Command {
    /**
     * Execute command.
     */
    public void execute(String command, List<Product> products);

    /**
     * Return command name.
     *
     * @return command name.
     */
    public String getCommandName();
}
