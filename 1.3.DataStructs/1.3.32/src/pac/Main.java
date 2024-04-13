package pac; 
import java.util.Scanner; 
import java.util.logging.Logger; 
 
import structs.LinkedStackQueue; 
 
public class Main { 
 
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName()); 
     
    public static void main() { 
        LinkedStackQueue<Integer> stackQueue = new LinkedStackQueue<>(); 
        Scanner scanner = new Scanner(System.in); 
        String input; 
 
        do { 
            LOGGER.info("\nМеню:\n1. Добавить элемент в стек\n2. Добавить элемент в очередь\n3. Удалить элемент из стека\n4. Удалить элемент из очереди\n5. Посмотреть размер стека/очереди\n6. Выход"); 
            input = scanner.nextLine(); 
 
            if (!input.matches("[123456]")) { 
                LOGGER.info("Неверный ввод. Пожалуйста, введите 1, 2, 3, 4, 5 или 6."); 
                continue; 
            } 
 
            switch (input) { 
                case "1": 
                    LOGGER.info("Введите число для добавления в стек:"); 
                    String numberInput = scanner.nextLine(); 
                     
                    if (!numberInput.matches("\\d+")) { 
                        LOGGER.info("Неверный ввод. Пожалуйста, введите число."); 
                    } else { 
                        int number = Integer.parseInt(numberInput); 
                        stackQueue.push(number); 
                        LOGGER.info("Добавлено число в стек: " + number); 
                    } 
                    break; 
                case "2": 
                    LOGGER.info("Введите число для добавления в очередь:"); 
                    numberInput = scanner.nextLine(); 
                     
                    if (!numberInput.matches("\\d+")) { 
                        LOGGER.info("Неверный ввод. Пожалуйста, введите число."); 
                    } else { 
                        int number = Integer.parseInt(numberInput); 
                        stackQueue.enqueue(number); 
                        LOGGER.info("Добавлено число в очередь: " + number); 
                    } 
                    break; 
                case "3": 
                    if (stackQueue.isEmpty()) { 
                        LOGGER.info("Стек пуст."); 
                    } else { 
                        LOGGER.info("Удаленный элемент из стека: " + stackQueue.pop()); 
                    } 
                    break; 
                case "4": 
                    if (stackQueue.isEmpty()) { 
                        LOGGER.info("Очередь пуста."); 
                    } else { 
                        LOGGER.info("Удаленный элемент из очереди: " + stackQueue.dequeue()); 
                    } 
                    break; 
                case "5": 
                    LOGGER.info("Текущий размер стека/очереди: " + stackQueue.size()); 
                    break; 
                case "6": 
                    LOGGER.info("Выход из программы."); 
                    break; 
            } 
        } while (!input.equals("6")); 
 
        scanner.close(); 
    } 
}