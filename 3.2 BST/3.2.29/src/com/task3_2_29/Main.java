package com.task3_2_29;

import java.util.logging.Logger;

public class Main {
    private static Logger LOGGER = Logger.getLogger(BinarySearchTree.class.getName());
    public static void main(String[] args){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(2, "two");
        bst.put(4, "four");
        bst.put(6, "six");
        bst.put(5, "aaaaaaaaa");
        LOGGER.info("Answer for root: " + bst.isBinaryTree(bst.getRoot()));
    }   
}
