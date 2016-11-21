package com.tat.at1.utils;

import com.tat.at1.instructions.AbstractInstruction;
import com.tat.at1.instructions.PageInstruction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by Я on 18.11.2016.
 */
public class InstructionService {
    public void handleInstructions(List<PageInstruction> pageInstructions) {
        WebDriver webDriver = new ChromeDriver();
        for (PageInstruction pageInstruction : pageInstructions) {
            System.out.println(pageInstruction.open(webDriver));
            for (AbstractInstruction instruction : pageInstruction.getInstructions()) {
                System.out.println(instruction.execute(webDriver));
            }
        }
        webDriver.close();
    }
}
