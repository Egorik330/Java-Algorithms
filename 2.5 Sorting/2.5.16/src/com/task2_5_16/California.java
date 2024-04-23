package com.task2_5_16;

import java.util.Scanner;
import java.util.logging.Logger;

public class California {
    private static final Logger LOGGER = Logger.getLogger(California.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Enter the number of strings:");
        int n =0;

        String input = scanner.nextLine();

        try {
            n = Integer.parseInt(input);
            LOGGER.info("The input is a valid integer: " + n);
        } catch (NumberFormatException e) {
            LOGGER.info("The input is not a valid integer.");
        }

        scanner.nextLine();  

        String[] strings = new String[n];
        LOGGER.info("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine().toUpperCase();
        }

        Quick.sort(strings);

        LOGGER.info("Sorted names:");
        for (String str : strings) {
            LOGGER.info(str);
        }

        scanner.close();
    }
}
