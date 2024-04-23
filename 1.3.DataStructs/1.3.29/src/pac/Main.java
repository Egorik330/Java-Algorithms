package pac;
import java.util.Scanner;
import java.util.logging.Logger;
import java.lang.IllegalStateException;

import structs.Queue;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private Main() {
        throw new IllegalStateException("Utility class");
    }

    public static void main() {
        Queue<Integer> queue = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        String input;

    do {
        LOGGER.info("\nМеню:\n1. Добавить элемент\n2. Удалить элемент\n3. Посмотреть размер очереди\n4. Выход");
        input = scanner.nextLine();

        // Проверка ввода
        if (!input.matches("[1234]")) {
            LOGGER.info("Неверный ввод. Пожалуйста, введите 1, 2, 3 или 4.");
            continue;
        }

        switch (input) {
            case "1":
                LOGGER.info("Введите число для добавления в очередь:");
                String numberInput = scanner.nextLine();
                
                if (!numberInput.matches("\\d+")) {
                    LOGGER.info("Неверный ввод. Пожалуйста, введите число.");
                } else {
                    int number = Integer.parseInt(numberInput);
                    queue.enqueue(number);
                    LOGGER.info("Добавлено число: " + number);
                }
                break;
            case "2":
                if (queue.isEmpty()) {
                    LOGGER.info("Очередь пуста.");
                } else {
                    LOGGER.info("Удаленный элемент: " + queue.dequeue());
                }
                break;
            case "3":
                LOGGER.info("Текущий размер: " + queue.size());
                break;
            case "4":
                LOGGER.info("Выход из программы.");
                break;
        }
    } while (!input.equals("4"));

    scanner.close();
}
}