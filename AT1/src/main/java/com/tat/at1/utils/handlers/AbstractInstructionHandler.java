package com.tat.at1.utils.handlers;

import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;

import java.util.List;

/**
 * Represents abstract class of AbstractInstructionHandler.
 *
 * @author Eugeny Titenkov.
 */
public class AbstractInstructionHandler {
    /**
     * Adds instruction from checkInstructions to pageInstructions.
     *
     * @param pageInstructions  - list which add.
     * @param checkInstructions - list from add.
     * @return full list of pageInstructions.
     * @throws Exception if lists contain unvalid data.
     */
    protected List<PageInstruction> addInstructionsToPages(List<PageInstruction> pageInstructions,
                                                           List<AbstractInstruction> checkInstructions) throws Exception {
        boolean instructiontIsFound;
        for (PageInstruction page : pageInstructions) {
            String pageId = page.getId();
            instructiontIsFound = false;
            for (int i = 0; i < checkInstructions.size(); i++) {
                if (checkInstructions.get(i).getPageId().equals(pageId)) {
                    instructiontIsFound = true;
                    page.addInstruction(checkInstructions.get(i));
                    checkInstructions.remove(i);
                    i--;
                }
            }
            if (!instructiontIsFound) {
                throw new Exception("Unvalid data. Some instruction have unvalid \"page id\"");
            }
        }
        return pageInstructions;
    }
}
