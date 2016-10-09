package tat.bsu.homework.lesson2.task7;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains user dictionary.
 *
 * @author Eugeny Titenkov
 * @version 1.00
 * @since 9 Oct 2016
 */
abstract public class Dictionary {
    private static List<String> dictionary = new ArrayList<String>();

    static {
        dictionary.add("I");
        dictionary.add("love");
        dictionary.add("my");
        dictionary.add("job");
    }

    /**
     * Return dictionary list.
     *
     * @return List dictionary.
     */
    public static List<String> getDictionary() {
        return dictionary;
    }
}
