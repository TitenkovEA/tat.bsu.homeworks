package com.tat.at1.factories;

import com.tat.at1.instructions.*;
import org.json.simple.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Represents factory of Instructions.
 * Allows get object type of AbstractInstruction.
 *
 * @author Eugeny Titenkov.
 */
public class InstructionsFactory {
    private static final String NAME = "name";
    private static final String VALUE = "value";
    private static final String PAGE_ID = "page_id";

    /**
     * Returns object type of AbstractInstruction by String array.
     *
     * @param instructionParams - String array, with instruction params.
     * @return object type of AbstractInstruction.
     */
    public AbstractInstruction getInstruction(String[] instructionParams) {
        if (instructionParams.length != 3) {
            return null;
        } else {
            String name = instructionParams[0];
            String value = instructionParams[1];
            String pageId = instructionParams[2];
            return getInstruction(name, value, pageId);
        }
    }

    /**
     * Returns object type of AbstractInstruction by XML Node.
     *
     * @param instruction - XML Node, with instruction attributes.
     * @return object type of AbstractInstruction.
     */
    public AbstractInstruction getInstruction(Node instruction) {
        NamedNodeMap params = instruction.getAttributes();
        String name = params.getNamedItem(NAME).getNodeValue();
        String value = params.getNamedItem(VALUE).getNodeValue();
        String pageId = params.getNamedItem(PAGE_ID).getNodeValue();

        return getInstruction(name, value, pageId);
    }

    /**
     * Returns object type of AbstractInstruction by JSON object.
     *
     * @param instruction - JSON object, with instruction params.
     * @return object type of AbstractInstruction.
     */
    public AbstractInstruction getInstruction(JSONObject instruction) {
        String name = instruction.get(NAME).toString();
        String value = instruction.get(VALUE).toString();
        String pageId = instruction.get(PAGE_ID).toString();

        return getInstruction(name, value, pageId);
    }

    /**
     * Returns object type of AbstractInstruction.
     *
     * @param name   - name of instruction.
     * @param value  - name of instruction.
     * @param pageId - name of instruction.
     * @return object type of AbstractInstruction.
     */
    private AbstractInstruction getInstruction(String name, String value, String pageId) {
        if (name.equals(CheckLinkPresentByHrefInstruction.NAME)) {
            return new CheckLinkPresentByHrefInstruction(value, pageId);
        } else if (name.equals(CheckLinkPresentByNameInstruction.NAME)) {
            return new CheckLinkPresentByNameInstruction(value, pageId);
        } else if (name.equals(CheckPageContainsInstruction.NAME)) {
            return new CheckPageContainsInstruction(value, pageId);
        } else if (name.equals(CheckPageTitleInstruction.NAME)) {
            return new CheckPageTitleInstruction(value, pageId);
        } else {
            return null;
        }
    }
}
