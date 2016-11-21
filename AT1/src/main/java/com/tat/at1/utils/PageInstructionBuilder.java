package com.tat.at1.utils;

import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import org.json.simple.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * Represents class of PageInstructionBuilder.
 * Allows build object of PageInstruction.
 *
 * @author Eugeny Titenkov.
 */
public class PageInstructionBuilder {
    private static final String NAME = "name";
    private static final String URL = "url";
    private static final String TIMEOUT = "timeout";
    private static final String ID = "id";

    /**
     * Allows build object of PageInstruction by String array.
     *
     * @param params - String array.
     * @return object of PageInstruction.
     */
    public PageInstruction build(String[] params) {
        if (params.length != 4) {
            return null;
        } else {
            String name = params[0];
            String url = params[1];
            String timeout = params[2];
            String id = params[3];
            if (PageInstruction.NAME.equals(name)) {
                return new PageInstruction(url, Double.parseDouble(timeout), id,
                        new ArrayList<AbstractInstruction>());
            } else {
                return null;
            }
        }
    }

    /**
     * Allows build object of PageInstruction by xml Node.
     *
     * @param instruction - xml Node.
     * @return object of PageInstruction.
     */
    public PageInstruction build(Node instruction) {
        NamedNodeMap params = instruction.getAttributes();
        if (PageInstruction.NAME.equals(params.getNamedItem(NAME).getNodeValue())) {
            String url = params.getNamedItem(URL).getNodeValue();
            String timeout = params.getNamedItem(TIMEOUT).getNodeValue();
            String id = params.getNamedItem(ID).getNodeValue();
            return new PageInstruction(url, Double.parseDouble(timeout), id,
                    new ArrayList<AbstractInstruction>());
        } else {
            return null;
        }
    }

    /**
     * Allows build object of PageInstruction by JSON object.
     *
     * @param instruction - JSON object.
     * @return object of PageInstruction
     */
    public PageInstruction build(JSONObject instruction) {
        if (PageInstruction.NAME.equals(instruction.get(NAME).toString())) {
            String url = instruction.get(URL).toString();
            String timeout = instruction.get(TIMEOUT).toString();
            String id = instruction.get(ID).toString();
            return new PageInstruction(url, Double.parseDouble(timeout), id,
                    new ArrayList<AbstractInstruction>());
        } else {
            return null;
        }
    }
}
