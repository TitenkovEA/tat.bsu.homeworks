package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TxtHandler implements InstructionHandler {
    private File txtFile;

    public TxtHandler(String filePath) {
        this.txtFile = new File(filePath);
    }

    public List<PageInstruction> getPageInstruction() throws IOException {
        List<PageInstruction> pageInstructions = new ArrayList<>();
        List<AbstractInstruction> checkInstructions = new ArrayList<>();

        PageInstruction pageInstruction;
        AbstractInstruction instruction;
        InstructionsFactory instructionFactory = new InstructionsFactory();
        PageInstructionBuilder pageInstructionBuilder = new PageInstructionBuilder();
        for (String dataLine : readFile()) {
            String[] params = parseLine(dataLine);
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

    private String[] readFile() throws IOException {
        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(txtFile));

        String line = reader.readLine();
        while (line != null) {
            fileData.append(line);
            fileData.append(System.lineSeparator());
            line = reader.readLine();
        }

        return fileData.toString().split(System.lineSeparator());
    }

    private String[] parseLine(String line) {
        String[] params = line.split("\\s\"|\"\\s\"");
        for (int i = 0; i < params.length; i++) {
            params[i] = params[i].replace("\\\"", "\"");
        }
        String lastParam = params[params.length - 1];
        lastParam = lastParam.substring(0, lastParam.length() - 1);
        params[params.length - 1] = lastParam;
        return params;
    }
}
