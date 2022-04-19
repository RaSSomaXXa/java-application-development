package com.acme.dbo.txlog;

public class Facade {
    private static int IntegerAccumulator;
    private static int StringAccumulator;
    private static boolean NeedIntegerFlush;
    private static boolean NeedStringFlush;
    private static String lastMessage;

    public static void log(int message) {
        if (NeedStringFlush) {
            flushString();
            NeedIntegerFlush = true;
            NeedStringFlush = false;
        }
        IntegerAccumulator += message;
    }

    public static void log(byte message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(char message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        if (NeedIntegerFlush) {
            flushInt();
            NeedIntegerFlush = false;
            NeedStringFlush = true;
        }
        if (!message.equals(lastMessage) && lastMessage != null) {
            flushString();
            NeedStringFlush = true;
        }
        lastMessage = message;
        StringAccumulator++;
    }

    public static void log(boolean message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void flushInt() {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(IntegerAccumulator));
        IntegerAccumulator = 0;
    }

    public static void flushString() {
        if (StringAccumulator == 1) {
            ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(lastMessage));
        } else if (StringAccumulator > 1) {
            ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(lastMessage + " (x" + StringAccumulator) + ")");
        }
        StringAccumulator = 0;
    }

}