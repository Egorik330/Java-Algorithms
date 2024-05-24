package com.task5_3_8;

import java.util.logging.Logger;

    public class Main {

        private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
        public static void main(String[] args) {
            String text = "abcabcabcabcabc";
            String pattern = "abc";
    
            KMP kmp = new KMP(pattern);
    
            int count = kmp.count(text);
            LOGGER.info("Count: " + count);
    
            List<Integer> positions = kmp.searchAll(text);
            LOGGER.info("Positions: " + positions);
        }
    }