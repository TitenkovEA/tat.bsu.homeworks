package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Я on 18.11.2016.
 */
public class JsonHandler implements InstructionHandler {
    private static final String INSTRUCTIOON_OBJECT_NAME = "instructions";

    private JSONObject jsonObject;

    public JsonHandler(String filePath) throws Exception {
        FileReader reader = new FileReader(filePath);

        JSONParser jsonParser = new JSONParser();
        this.jsonObject = (JSONObject) jsonParser.parse(reader);
    }

    public List<PageInstruction> getPageInstruction() {
        List<PageInstruction> pageInstructions = new ArrayList<>();
        List<AbstractInstruction> checkInstructions = new ArrayList<>();

        PageInstruction pageInstruction;
        AbstractInstruction instruction;
        InstructionsFactory instructionFactory = new InstructionsFactory();
        PageInstructionBuilder pageInstructionBuilder = new PageInstructionBuilder();
        JSONArray lang = (JSONArray) jsonObject.get(INSTRUCTIOON_OBJECT_NAME);
        Iterator iterator = lang.iterator();
        while (iterator.hasNext()) {
            JSONObject innerObj = (JSONObject) iterator.next();
            pageInstruction = pageInstructionBuilder.build(innerObj);
            if (pageInstruction == null) {
                instruction = instructionFactory.getInstruction(innerObj);
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
}
