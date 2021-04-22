package demo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * try {
 *     main();
 * } catch (Throwable e) {
 *     ....
 *     e.printStackTrace();
 *     System.exit(-1);
 * }
 */
public class ExceptionsDemo {
    public static void main(String[] args) {
        final Controller controller = new Controller(new Printer());
        controller.log("HW!!");
        // -
    }
}

class Controller {
    private Printer printer;

    Controller(Printer printer) {
        this.printer = printer;
    }

    public void log(String message) {
        try {
            //...
            printer.print(message);
            // -
        } catch (RuntimeException e) {
            //log
            throw new RuntimeException("log didn't succeed for " + message, e);
        }
    }
}

class Printer {
    public void print(String message) {
        //....
        try (Connection conn = null) {
            //...
            systemLibWrite();
            // -
        } catch (RuntimeException | SQLException e) {
            //log(e)
            throw new RuntimeException(message + " didn't print", e);
            // -
        }
        //....
    }

    private void systemLibWrite() {
        //...
        throw new RuntimeException("cant read file .sys");
        // -
        // -
    }
}