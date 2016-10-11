package tat.bsu.homework.lesson2.task7.utils;

import tat.bsu.homework.lesson2.task7.RegularExpressions;

/**
 * Utility for rules.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
abstract public class RuleUtil {
    /**
     * Divide string on words.
     *
     * @param string - string for division into words.
     * @return massive with words.
     */
    public static String[] divideOnWords(String string) {
        return string.split(RegularExpressions.ALL_SYMBOLS_EXCEPT_LETTERS_AND_NUMBERS_REGEX);
    }
}
