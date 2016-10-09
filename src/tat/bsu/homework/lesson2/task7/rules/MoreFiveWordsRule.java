package tat.bsu.homework.lesson2.task7.rules;

import tat.bsu.homework.lesson2.task7.RegularExpressions;
import tat.bsu.homework.lesson2.task7.utils.RuleUtil;

/**
 * Represents rule, where string must contain more than five word.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
public class MoreFiveWordsRule implements Rule {
    /**
     * Checking for compliance with rule.
     *
     * @param string - string to test with rule.
     * @return true if the string compliance with rule, else false.
     */
    @Override
    public boolean checkRule(String string) {
        int countOfWords = 0;

        for (String str : RuleUtil.divideOnWords(string)) {
            if (!str.matches(RegularExpressions.ONLY_NUMBERS_REGEX)) {
                countOfWords++;
            }
        }

        return countOfWords > 5;
    }
}
