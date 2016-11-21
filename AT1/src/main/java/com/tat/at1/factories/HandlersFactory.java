package com.tat.at1.factories;

import com.tat.at1.utils.handlers.*;

/**
 * Created by Я on 18.11.2016.
 */
public class HandlersFactory {
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
