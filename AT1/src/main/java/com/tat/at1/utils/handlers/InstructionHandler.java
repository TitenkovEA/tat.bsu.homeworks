package com.tat.at1.utils.handlers;

import com.tat.at1.instructions.PageInstruction;

import java.io.IOException;
import java.util.List;

/**
 * Represents interface of InstructionHandler.
 *
 * @author Eugeny Titenkov.
 */
public interface InstructionHandler {
    /**
     * Returns list of PageInstruction objects.
     *
     * @return list of PageInstruction objects.
     * @throws Exception if contains unvalid data.
     */
    List<PageInstruction> getPageInstruction() throws Exception;
}

