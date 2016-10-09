package tat.bsu.homework.lesson2.task7.rules;

import tat.bsu.homework.lesson2.task7.Dictionary;
import tat.bsu.homework.lesson2.task7.utils.RuleUtil;

/**
 * Represents rule, where string must contain one or more words from dictionary.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
public class WordFromDictionaryRule implements Rule {
    /**
     * Checking for compliance with rule.
     *
     * @param string - string to test with rule.
     * @return true if the string compliance with rule, else false.
     */
    @Override
    public boolean checkRule(String string) {
        for (String wordFromString : RuleUtil.divideOnWords(string)) {
            for (String wordFromDictionary : Dictionary.getDictionary()) {
                if (wordFromString.equals(wordFromDictionary)) {
                    return true;
                }
            }
        }
        return false;
    }
}
