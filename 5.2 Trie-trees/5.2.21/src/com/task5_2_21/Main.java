package com.task5_2_21;

import java.util.List;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        SubstringMatcher matcher = new SubstringMatcher();
        String[] words = {"победа", "обеда", "беда", "еда", "да", "а"};

        for (String word : words) {
            matcher.insert(word);
        }

        String query = "еда";
        List<String> results = matcher.search(query);
        LOGGER.info("Строки, содержащие подстроку \"" + query + "\":");
        for (String result : results) {
            LOGGER.info(result);
        }
    }
}
