package com.tat.at1.utils;

import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Represents class of InstructionService.
 *
 * @author Eugeny Titenkov.
 */
public class InstructionService {
    private static final Logger logger = LogManager.getLogger(InstructionService.class);

    /**
     * Allows to execute all instruction.
     *
     * @param pageInstructions - list of PageInstruction objects.
     */
    public void handleInstructions(List<PageInstruction> pageInstructions) {
        WebDriver webDriver = new ChromeDriver();
        for (PageInstruction pageInstruction : pageInstructions) {
            checkInstruction(pageInstruction, webDriver);
            for (AbstractInstruction instruction : pageInstruction.getInstructions()) {
                checkInstruction(instruction, webDriver);
            }
        }
        webDriver.close();
    }

    /**
     * Check execution object of PageInstruction.
     *
     * @param pageInstruction - object of PageInstruction.
     * @param webDriver       - where check instruction.
     */
    private void checkInstruction(PageInstruction pageInstruction, WebDriver webDriver) {
        long startTime = System.currentTimeMillis();
        boolean testResult = pageInstruction.open(webDriver);
        long finishTime = System.currentTimeMillis();
        //convert time from ms to seconds
        double elapsedTime = (double) (finishTime - startTime) / 1000;
        if (testResult) {
            logger.info("+ " + pageInstruction.getInfoMessage() + " " + elapsedTime);
            Statistic.addPassedTestInfo(elapsedTime);
        } else {
            logger.info("! " + pageInstruction.getInfoMessage() + " " + elapsedTime);
            Statistic.addFailedTestInfo(elapsedTime);
        }
    }

    /**
     * Check execution object type of AbstractInstruction.
     *
     * @param abstractInstruction - object type of AbstractInstruction.
     * @param webDriver           - where check instruction.
     */
    private void checkInstruction(AbstractInstruction abstractInstruction, WebDriver webDriver) {
        long startTime = System.currentTimeMillis();
        boolean testResult = abstractInstruction.execute(webDriver);
        long finishTime = System.currentTimeMillis();
        //convert time from ms to seconds
        double elapsedTime = (double) (finishTime - startTime) / 1000;
        if (testResult) {
            logger.info("+ " + abstractInstruction.getInfoMessage() + " " + elapsedTime);
            Statistic.addPassedTestInfo(elapsedTime);
        } else {
            logger.info("! " + abstractInstruction.getInfoMessage() + " " + elapsedTime);
            Statistic.addFailedTestInfo(elapsedTime);
        }
    }
}
