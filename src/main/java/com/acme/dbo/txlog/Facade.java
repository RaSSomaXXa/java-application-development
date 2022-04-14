package com.acme.dbo.txlog;

public class Facade {
    public static void log(int message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(byte message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(char message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(boolean message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }
}