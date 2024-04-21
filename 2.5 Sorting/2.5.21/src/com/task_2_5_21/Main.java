package com.task_2_5_21;

import java.util.logging.Logger;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
  public static void main(String[] args) {
    //ввод не считаю необходимым тут, просто демонстрация
    Vector[] vectors = {
        new Vector(1, 2, 3),
        new Vector(3, 2, 1),
        new Vector(2, 1, 3),
        new Vector(1, 3, 2),
        new Vector(2, 3, 1) };
    MergeSort.sort(vectors);

   LOGGER.info("Отсортированные вектора: ");

    for (Vector v : vectors) {
      LOGGER.info(v.toString());
    }
  }
}