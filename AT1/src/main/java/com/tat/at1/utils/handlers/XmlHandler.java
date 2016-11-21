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
 * Represents class of XmlHandler.
 *
 * @author Eugeny Titenkov.
 */
public class XmlHandler extends AbstractInstructionHandler
        implements InstructionHandler {
    private static final String INSTRUCTION_TAG = "instruction";

    private Document document;

    /**
     * Create object of XmlHandler with received params.
     *
     * @param filePath - path to xml file.
     */
    public XmlHandler(String filePath) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File(filePath));
    }

    /**
     * Returns list of PageInstruction objects by xml file.
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
        NodeList instructions = document.getElementsByTagName(INSTRUCTION_TAG);
        for (int i = 0; i < instructions.getLength(); i++) {
            pageInstruction = pageInstructionBuilder.build(instructions.item(i));
            if (pageInstruction == null) {
                instruction = instructionFactory.getInstruction(instructions.item(i));
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
