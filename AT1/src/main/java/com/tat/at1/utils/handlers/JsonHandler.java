package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents class of JsonHandler.
 *
 * @author Eugeny Titenkov.
 */
public class JsonHandler extends AbstractInstructionHandler
        implements InstructionHandler {
    private static final String INSTRUCTION_OBJECT_NAME = "instructions";

    private JSONObject jsonObject;

    /**
     * Create object of JsonHandler with received params.
     *
     * @param filePath - path to json file.
     */
    public JsonHandler(String filePath) throws Exception {
        FileReader reader = new FileReader(filePath);

        JSONParser jsonParser = new JSONParser();
        this.jsonObject = (JSONObject) jsonParser.parse(reader);
    }

    /**
     * Returns list of PageInstruction objects by json file.
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
        JSONArray lang = (JSONArray) jsonObject.get(INSTRUCTION_OBJECT_NAME);
        Iterator iterator = lang.iterator();
        while (iterator.hasNext()) {
            JSONObject innerObj = (JSONObject) iterator.next();
            pageInstruction = pageInstructionBuilder.build(innerObj);
            if (pageInstruction == null) {
                instruction = instructionFactory.getInstruction(innerObj);
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
}
