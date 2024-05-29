package com.task5_2_14;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Введите текст: ");
        String text = scanner.nextLine();
        LOGGER.info("Введите длину подстрок (L): ");
        int L = scanner.nextInt();

        UniqueSubstrings trie = new UniqueSubstrings();
        Set<String> uniqueSubstrings = new HashSet<>();

        for (int i = 0; i <= text.length() - L; i++) {
            String substring = text.substring(i, i + L);
            if (!trie.search(substring)) {
                trie.insert(substring);
                uniqueSubstrings.add(substring);
            }
        }

        LOGGER.info("Количество уникальных подстрок длиной " + L + ": " + uniqueSubstrings.size());
        LOGGER.info("Уникальные подстроки: " + uniqueSubstrings);
    }
}
