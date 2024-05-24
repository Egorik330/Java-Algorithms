package com.task5_3_23;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final int PRIME = 101; 

    private static boolean isPrefixPalindrome(String s, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) return true;

        long forwardHash = 0, backwardHash = 0;
        long power = 1;

        for (int i = 0; i < n; i++) {
            forwardHash = (forwardHash * PRIME + s.charAt(i)) % Long.MAX_VALUE;
            backwardHash = (backwardHash + s.charAt(i) * power) % Long.MAX_VALUE;
            if (forwardHash == backwardHash && isPrefixPalindrome(s, i + 1)) {
                return true;
            }
            power = (power * PRIME) % Long.MAX_VALUE;
        }
        return false;
    }

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder currentString = new StringBuilder();
        
        while (scanner.hasNext()) {
            char c = scanner.next().charAt(0);
            currentString.append(c);
            if (isPalindrome(currentString.toString())) {
                LOGGER.info("Current string \"" + currentString + "\" is a palindrome");
            } else {
                LOGGER.info("Current string \"" + currentString + "\" is not a palindrome");
            }
        }
        scanner.close();
    }
}
