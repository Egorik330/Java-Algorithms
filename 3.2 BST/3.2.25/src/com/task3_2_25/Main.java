package com.task3_2_25;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main
{
    private static Logger LOGGER = Logger.getLogger(BinarySearchTree.class.getName());
    // не хочется прям менюшку делать для всех , чисто для высоты 2 вывода вот
    public static void main(String[] args) {

        BinarySearchTree<String, Integer> tree = new BinarySearchTree<>();
        List<String> strList = new ArrayList<>();
        strList.add("O");
        strList.add("A");
        strList.add("I");
        strList.add("P");
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(5);
        intList.add(2);
        intList.add(14);
        tree.getArray(strList, intList);
        for(int i = 0; i < tree.size(); i++){
            LOGGER.info(tree.get(tree.select(i)).toString());
        }
    }   
}
