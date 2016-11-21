package com.tat.at1.utils;

import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import org.json.simple.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * Created by Я on 20.11.2016.
 */
public class PageInstructionBuilder {
    private static final String NAME = "name";
    private static final String URL = "url";
    private static final String TIMEOUT = "timeout";
    private static final String ID = "id";

    public PageInstruction build(String[] params) {
        if (params.length != 4) {
            return null;
        } else {
            String name = params[0];
            String url = params[1];
            String timeout = params[2];
            String id = params[3];
            if (PageInstruction.NAME.equals(name)) {
                try {
                    return new PageInstruction(url, Double.parseDouble(timeout), id,
                            new ArrayList<AbstractInstruction>());
                } catch (Exception e) {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public PageInstruction build(Node instruction) {
        NamedNodeMap params = instruction.getAttributes();
        try {
            if (PageInstruction.NAME.equals(params.getNamedItem(NAME).getNodeValue())) {
                String url = params.getNamedItem(URL).getNodeValue();
                String timeout = params.getNamedItem(TIMEOUT).getNodeValue();
                String id = params.getNamedItem(ID).getNodeValue();
                return new PageInstruction(url, Double.parseDouble(timeout), id,
                        new ArrayList<AbstractInstruction>());
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public PageInstruction build(JSONObject instruction) {
        try {
            if (PageInstruction.NAME.equals(instruction.get(NAME).toString())) {
                String url = instruction.get(URL).toString();
                String timeout = instruction.get(TIMEOUT).toString();
                String id = instruction.get(ID).toString();
                return new PageInstruction(url, Double.parseDouble(timeout), id,
                        new ArrayList<AbstractInstruction>());
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
