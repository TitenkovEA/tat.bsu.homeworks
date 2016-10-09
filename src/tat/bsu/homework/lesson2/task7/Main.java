package tat.bsu.homework.lesson2.task7;

import tat.bsu.homework.lesson2.task7.rules.MoreFiveWordsRule;
import tat.bsu.homework.lesson2.task7.rules.OnlyNumbersRule;
import tat.bsu.homework.lesson2.task7.rules.WithoutNumbersRule;
import tat.bsu.homework.lesson2.task7.rules.WordFromDictionaryRule;
import tat.bsu.homework.lesson2.task7.utils.FromKeyboardReader;

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
            if (new WithoutNumbersRule().checkRule(string)) {
                System.out.println("Your text not contain numbers.");
            }
            if (new OnlyNumbersRule().checkRule(string)) {
                System.out.println("Your text contain only numbers.");
            }
            if (new MoreFiveWordsRule().checkRule(string)) {
                System.out.println("Your text contain more than five words.");
            }
            if (new WordFromDictionaryRule().checkRule(string)) {
                System.out.println("Your text contain word or words from dictionary.");
            }
        } catch (Exception e) {
            System.err.println("Unrecognized error: " + e.getMessage());
            System.exit(GENERIC_ERROR);
        }
    }
}
