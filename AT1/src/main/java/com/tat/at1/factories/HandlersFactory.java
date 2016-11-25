package com.tat.at1.factories;

import com.tat.at1.utils.handlers.*;

/**
 * Represents factory of InstructionHandler.
 * Allows get InstructionHandler.
 *
 * @author Eugeny Titenkov.
 */
public class HandlersFactory {
    /**
     * Allows get InstructionHandler by array of String,
     * for example by command line args.
     *
     * @param args - array of String.
     * @return object type of InstructionHandler.
     * @throws Exception if some object can't be created.
     */
    public InstructionHandler getHeandler(String[] args) throws Exception {
        if (args.length == 1) {
            if (args[0].matches(".+.txt")) {
                return new TxtHandler(args[0]);
            } else if (args[0].matches(".+.xml")) {
                return new XmlHandler(args[0]);
            } else if (args[0].matches(".+.json")) {
                return new JsonHandler(args[0]);
            } else {
                return new CommandLineHandler(args);
            }
        } else {
            return new CommandLineHandler(args);
        }
    }
}
