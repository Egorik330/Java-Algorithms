package com.task3_2_6;

import java.util.logging.Logger;

public class Main {
    private static Logger LOGGER = Logger.getLogger(BinarySearchTree.class.getName());
    // не хочется прям менюшку делать для всех , чисто для высоты 2 вывода вот
    public static void main(String[] args) {
        BinarySearchTree<String, Integer> tree = new BinarySearchTree<>();
        tree.put("O", 5);
        tree.put("A", 7);
        tree.put("I", 2);
        tree.put("P",3);
        Integer h = tree.heightField();
        LOGGER.info(h.toString());
        h = tree.height();
        LOGGER.info(h.toString());
    }   
}
