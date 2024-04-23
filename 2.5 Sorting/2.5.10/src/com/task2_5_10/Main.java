package com.task2_5_10;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Введите первую версию:");
        String version1 = scanner.nextLine();

        LOGGER.info("Введите вторую версию:");
        String version2 = scanner.nextLine();

        scanner.close();

        Version v1 = new Version(version1);
        Version v2 = new Version(version2);

        int comparison = v1.compareTo(v2);

        if (comparison < 0) {
            LOGGER.info(version1 + " меньше чем " + version2);
        } else if (comparison > 0) {
            LOGGER.info(version1 + " больше чем " + version2);
        } else {
            LOGGER.info("Версии равны");
        }
    }
}
