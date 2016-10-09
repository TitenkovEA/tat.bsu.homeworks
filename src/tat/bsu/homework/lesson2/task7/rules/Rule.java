package tat.bsu.homework.lesson2.task7.rules;

/**
 * Represents rule, with checking for compliance with this rule.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
public interface Rule {
    /**
     * Checking for compliance with rule.
     *
     * @param string - string to test with rule.
     * @return true if the string compliance with rule, else false.
     */
    public boolean checkRule(String string);
}
