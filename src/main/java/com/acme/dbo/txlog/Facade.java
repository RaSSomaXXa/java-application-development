package com.acme.dbo.txlog;

public class Facade {

    public static void log(int message) {
        MessagePrinter.printMessageToConsole(MessageDecorator.decorateMessage(message));
    }

    public static void log(byte message) {
        MessagePrinter.printMessageToConsole(MessageDecorator.decorateMessage(message));
    }

    public static void log(char message) {
        MessagePrinter.printMessageToConsole(MessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        MessagePrinter.printMessageToConsole(MessageDecorator.decorateMessage(message));
    }

    public static void log(boolean message) {
        MessagePrinter.printMessageToConsole(MessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        MessagePrinter.printMessageToConsole(MessageDecorator.decorateMessage(message));
    }

}
