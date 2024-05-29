package com.task5_2_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        if (args.length != 1) {
            LOGGER.info("Использование: java SpellChecker <file>");
            return;
        }

        String dictionaryFile = args[0];
        SpellChecker spellChecker = new SpellChecker();

        try (Scanner fileScanner = new Scanner(new File(dictionaryFile))) {
            while (fileScanner.hasNext()) {
                spellChecker.insert(fileScanner.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            LOGGER.info("Файл не найден: " + dictionaryFile);
            return;
        }

        Scanner inputScanner = new Scanner(System.in);
        LOGGER.info("Введите строку для проверки орфографии:");
        String inputText = inputScanner.nextLine().toLowerCase();

        String[] words = inputText.split("\\W+");
        for (String word : words) {
            if (!spellChecker.contains(word)) {
                LOGGER.info("Неправильное слово: " + word);
            }
        }
    }
}