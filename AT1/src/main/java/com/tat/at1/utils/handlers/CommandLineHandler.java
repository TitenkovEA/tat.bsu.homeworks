package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Я on 18.11.2016.
 */
public class CommandLineHandler implements InstructionHandler {
    private String[] args;

    public CommandLineHandler(String[] args) {
        this.args = args;
    }

    public List<PageInstruction> getPageInstruction() throws IOException {
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
                    //skip
                } else {
                    checkInstructions.add(instruction);
                }
            } else {
                pageInstructions.add(pageInstruction);
            }
        }

        for (PageInstruction page : pageInstructions) {
            String pageId = page.getId();
            for (int i = 0; i < checkInstructions.size(); i++) {
                if (checkInstructions.get(i).getPageId().equals(pageId)) {
                    page.addInstruction(checkInstructions.get(i));
                    checkInstructions.remove(i);
                    i--;
                }
            }
        }

        for (AbstractInstruction lostInstraction :
                checkInstructions) {
            //skip
        }
        return pageInstructions;
    }

    private String[] parseLine(String line) {
        String[] params = line.split("\\|");
        return params;
    }
}
