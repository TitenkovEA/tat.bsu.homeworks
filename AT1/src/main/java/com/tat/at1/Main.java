package com.tat.at1;

import com.tat.at1.factories.HandlersFactory;
import com.tat.at1.utils.InstructionService;
import com.tat.at1.utils.handlers.InstructionHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by Я on 20.11.2016.
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        HandlersFactory handlersFactory = new HandlersFactory();
        InstructionHandler instructionHandler = handlersFactory.getHeandler(args);
        new InstructionService().handleInstructions(instructionHandler.getPageInstruction());
    }
}
