import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        TST<Integer> tst = new TST<>();
        tst.put("apple", 1);
        tst.put("orange", 2);
        tst.put("banana", 3);

        System.out.println("Keys: ");
        for (String key : tst.keys()) LOGGER.info(key);
    }
}
