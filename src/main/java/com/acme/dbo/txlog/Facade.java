package com.acme.dbo.txlog;

public class Facade {

    public static void log(int message) {
        MessagePrinter.printMessage(MessageDecorator.decorateMessage(message));
    }

    public static void log(byte message) {
        MessagePrinter.printMessage(MessageDecorator.decorateMessage(message));
    }

    public static void log(char message) {
        MessagePrinter.printMessage(MessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        MessagePrinter.printMessage(MessageDecorator.decorateMessage(message));
    }

    public static void log(boolean message) {
        MessagePrinter.printMessage(MessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        MessagePrinter.printMessage(MessageDecorator.decorateMessage(message));
    }

}
