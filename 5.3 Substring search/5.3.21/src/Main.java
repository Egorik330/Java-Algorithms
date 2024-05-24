package com.task_5_3_21;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        String txt = "abcabcabc";
        String pat = "abc?bca";
        RabinKarp rk = new RabinKarp(pat);
        int offset = rk.search(txt);
        if (offset == txt.length()) {
            LOGGER.info("Образец не найден");
        } else {
            LOGGER.info("Образец найден на позиции: " + offset);
        }
    }
}