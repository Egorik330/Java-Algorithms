package com.task_3_3_42;

import java.util.Random;
import java.util.logging.Logger;

public class Main {
     private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        RBST<Integer, Integer> bst = new RBST<>();

        Random random = new Random();

    
        int n=100;
        for(int i=0;i<n;i++){
            int key=random.nextInt(n);
            bst.put(key, key);
        }

        double percentage = bst.redNodesPercentage();
        LOGGER.info("Процент красных узлов: "+percentage+"%");
    }

    //при разных значениях n процент красных узлов остается примерно одинаковым ввиду рандомности генерируемых ключей
}