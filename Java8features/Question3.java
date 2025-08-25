@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

public class Question3 {
    static void processMessage(String msg, MessagePrinter printer) {
        printer.print(msg);
    }

    public static void main(String[] args) {
        MessagePrinter printer = message -> System.out.println("Printed Message: " + message);
        processMessage("Hello from Lambda!", printer);
    }
}
