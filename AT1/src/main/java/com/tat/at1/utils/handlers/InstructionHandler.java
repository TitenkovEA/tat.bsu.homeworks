package com.tat.at1.utils.handlers;

import com.tat.at1.instructions.PageInstruction;

import java.io.IOException;
import java.util.List;

/**
 * Created by Я on 18.11.2016.
 */
public interface InstructionHandler {
    List<PageInstruction> getPageInstruction() throws IOException;
}

