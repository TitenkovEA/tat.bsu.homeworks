package tat.bsu.homework.lesson2.task7.rules;

import tat.bsu.homework.lesson2.task7.RegularExpressions;

/**
 * Represents rule, where string must contain only numbers.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
public class OnlyNumbersRule implements Rule {
    /**
     * Checking for compliance with rule.
     *
     * @param string - string to test with rule.
     * @return true if the string compliance with rule, else false.
     */
    @Override
    public boolean checkRule(String string) {
        return string.matches(RegularExpressions.ONLY_NUMBERS_REGEX);
    }

    /**
     * Return success message.
     *
     * @return string that contain success message.
     */
    @Override
    public String getSuccessMessage() {
        return "Your text contain only numbers.";
    }
}
