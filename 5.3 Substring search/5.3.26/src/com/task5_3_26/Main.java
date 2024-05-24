package com.task5_3_26;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static boolean isCyclicPermutation(String str1, String str2) {
    
        if (str1.length() != str2.length()) {
            return false;
        }

        String concatenated = str1 + str1;
        return concatenated.contains(str2);
    }
    public static void main(String[] args) {
        String str1 = "пальто";
        String str2 = "топаль";

        if (isCyclicPermutation(str1, str2)) {
            LOGGER.info(str2 + " является циклической перестановкой " + str1);
        } else {
            LOGGER.info(str2 + " не является циклической перестановкой " + str1);
        }
    }
}