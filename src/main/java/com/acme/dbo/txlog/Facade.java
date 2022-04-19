package com.acme.dbo.txlog;

public class Facade {
    private static int IntAccumulator;

    public static void log(int message) {
        IntAccumulator += message;
    }

    public static void log(byte message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(char message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        flush();
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(boolean message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void flush() {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(IntAccumulator));
        IntAccumulator = 0;
    }
}