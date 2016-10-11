package tat.bsu.homework.lesson2.task7;

/**
 * Contains regex constants.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
abstract public class RegularExpressions {
    public static final String ONLY_NUMBERS_REGEX = "\\d+";
    public static final String WITHOUT_NUMBERS_REGEX = "\\D+";
    public static final String ALL_SYMBOLS_EXCEPT_LETTERS_AND_NUMBERS_REGEX = "[\\W_]+";
}
