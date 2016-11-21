package com.tat.at1.factories;

import com.tat.at1.instructions.*;
import org.json.simple.JSONObject;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Created by Я on 18.11.2016.
 */
public class InstructionsFactory {
    private static final String NAME = "name";
    private static final String VALUE = "value";
    private static final String PAGE_ID = "page_id";

    public AbstractInstruction getInstruction(String[] instructionParams) {
        if (instructionParams.length != 3) {
            return null;
        } else {
            String name = instructionParams[0];
            String value = instructionParams[1];
            String pageId = instructionParams[2];
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

    public AbstractInstruction getInstruction(Node instruction) {
        NamedNodeMap params = instruction.getAttributes();
        try {
            String name = params.getNamedItem(NAME).getNodeValue();
            String value = params.getNamedItem(VALUE).getNodeValue();
            String pageId = params.getNamedItem(PAGE_ID).getNodeValue();
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
        } catch (Exception e) {
            return null;
        }
    }

    public AbstractInstruction getInstruction(JSONObject instruction) {
        try {
            String name = instruction.get(NAME).toString();
            String value = instruction.get(VALUE).toString();
            String pageId = instruction.get(PAGE_ID).toString();
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
        } catch (Exception e) {
            return null;
        }
    }
}
