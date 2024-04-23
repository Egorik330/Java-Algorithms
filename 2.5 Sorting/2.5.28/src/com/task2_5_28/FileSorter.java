package com.task2_5_28;

import java.io.File;
import java.util.logging.Logger;

public class FileSorter {

    private static final Logger LOGGER= Logger.getLogger(FileSorter.class.getName());
    public static void main(String[] args) {
        if (args.length != 1) {
            LOGGER.info("Usage: java FileSorter <directory>");
            return;
        }

        File directory = new File(args[0]);

        if (!directory.exists()) {
            LOGGER.info("Directory does not exist: " + args[0]);
            return;
        }

        if (!directory.isDirectory()) {
            LOGGER.info("Not a directory: " + args[0]);
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            LOGGER.info("An error occurred while reading the directory");
            return;
        }

        Quick.sort(files);

        for (File file : files) {
            LOGGER.info(file.getName());
        }
    }
}
