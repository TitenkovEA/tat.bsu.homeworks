package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents class of TxtHandler.
 *
 * @author Eugeny Titenkov.
 */
public class TxtHandler extends AbstractInstructionHandler
        implements InstructionHandler {
    private File txtFile;

    /**
     * Create object of TxtHandler with received params.
     *
     * @param filePath - path to txt file.
     */
    public TxtHandler(String filePath) {
        this.txtFile = new File(filePath);
    }

    /**
     * Returns list of PageInstruction objects by txt file.
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
        for (String dataLine : readFile()) {
            String[] params = parseLine(dataLine);
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
     * Read txt file.
     *
     * @return txt file in String array.
     * @throws IOException if file can't be read.
     */
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

    /**
     * Returns String array of params.
     *
     * @param line - line to parse.
     * @return String array of params.
     */
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
