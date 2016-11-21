package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents class of CommandLineHandler.
 *
 * @author Eugeny Titenkov.
 */
public class CommandLineHandler extends AbstractInstructionHandler
        implements InstructionHandler {
    private String[] args;

    /**
     * Create object of CommandLineHandler with received params.
     *
     * @param args - command line args.
     */
    public CommandLineHandler(String[] args) {
        this.args = args;
    }

    /**
     * Returns list of PageInstruction objects by command line args.
     *
     * @return list of PageInstruction objects.
     * @throws Exception if contains unvalid data.
     */
    public List<PageInstruction> getPageInstruction() throws Exception {
        List<PageInstruction> pageInstructions = new ArrayList<>();
        List<AbstractInstruction> checkInstructions = new ArrayList<>();

        PageInstruction pageInstruction;
        AbstractInstruction instruction;
        InstructionsFactory instructionFactory = new InstructionsFactory();
        PageInstructionBuilder pageInstructionBuilder = new PageInstructionBuilder();
        for (String arg : args) {
            String[] params = parseLine(arg);
            pageInstruction = pageInstructionBuilder.build(params);
            if (pageInstruction == null) {
                instruction = instructionFactory.getInstruction(params);
                if (instruction == null) {
                    throw new Exception("Unvalid data");
                } else {
                    checkInstructions.add(instruction);
                }
            } else {
                pageInstructions.add(pageInstruction);
            }
        }
        return this.addInstructionsToPages(pageInstructions, checkInstructions);
    }

    /**
     * Returns String array of params.
     *
     * @param line - line to parse.
     * @return String array of params.
     */
    private String[] parseLine(String line) {
        String[] params = line.split("\\|");
        return params;
    }
}
