package com.tat.at1;

import com.tat.at1.factories.HandlersFactory;
import com.tat.at1.utils.InstructionService;
import com.tat.at1.utils.Statistic;
import com.tat.at1.utils.handlers.InstructionHandler;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int GENERIC_ERROR = 1;

    /**
     * Read all instruction depend on command line args.
     * Its could be command line args, json file, txt file, xml file.
     * And tests all received instruction.
     *
     * @param args - command line args.
     */
    public static void main(String[] args) {
        try {
            HandlersFactory handlersFactory = new HandlersFactory();
            InstructionHandler instructionHandler = handlersFactory.getHeandler(args);
            new InstructionService().handleInstructions(instructionHandler.getPageInstruction());
            logger.info(Statistic.getTotalCountInfo());
            logger.info(Statistic.getTestsInfo());
            logger.info(Statistic.getTotalTimeInfo());
            logger.info(Statistic.getAverageTimeInfo());
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
