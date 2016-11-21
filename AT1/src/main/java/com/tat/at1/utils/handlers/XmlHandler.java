package com.tat.at1.utils.handlers;

import com.tat.at1.factories.InstructionsFactory;
import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import com.tat.at1.utils.PageInstructionBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Я on 18.11.2016.
 */
public class XmlHandler implements InstructionHandler {
    private static final String INSTRUCTION_TAG = "instruction";

    private Document document;

    public XmlHandler(String filePath) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File(filePath));
    }

    public List<PageInstruction> getPageInstruction() {
        List<PageInstruction> pageInstructions = new ArrayList<>();
        List<AbstractInstruction> checkInstructions = new ArrayList<>();

        PageInstruction pageInstruction;
        AbstractInstruction instruction;
        InstructionsFactory instructionFactory = new InstructionsFactory();
        PageInstructionBuilder pageInstructionBuilder = new PageInstructionBuilder();
        NodeList instructions = document.getElementsByTagName(INSTRUCTION_TAG);
        for (int i = 0; i < instructions.getLength(); i++) {
            pageInstruction = pageInstructionBuilder.build(instructions.item(i));
            if (pageInstruction == null) {
                instruction = instructionFactory.getInstruction(instructions.item(i));
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
