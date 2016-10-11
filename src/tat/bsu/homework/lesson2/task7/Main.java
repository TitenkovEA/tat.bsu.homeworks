package tat.bsu.homework.lesson2.task7;

import tat.bsu.homework.lesson2.task7.rules.*;
import tat.bsu.homework.lesson2.task7.utils.FromKeyboardReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains application entry point.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
public class Main {
    private static final int GENERIC_ERROR = 1;

    /**
     * Create a string, and checks her on the rules.
     *
     * @param args - command line parameters.
     */
    public static void main(String[] args) {
        try {
            String string = FromKeyboardReader.stringRead();
            for (Rule rule : getRules()) {
                if (rule.checkRule(string)) {
                    System.out.println(rule.getSuccessMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }

    /**
     * Create list with four different rules.
     *
     * @return list with four different rules.
     */
    private static List<Rule> getRules() {
        List<Rule> rules = new ArrayList<Rule>();
        rules.add(new WithoutNumbersRule());
        rules.add(new OnlyNumbersRule());
        rules.add(new MoreFiveWordsRule());
        rules.add(new WordFromDictionaryRule());
        return rules;
    }
}
