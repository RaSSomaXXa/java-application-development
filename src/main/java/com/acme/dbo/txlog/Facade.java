package com.acme.dbo.txlog;

import java.util.Objects;

public class Facade {
    private static long IntegerAccumulator;
    private static long IntegerOverflowCount;
    private static int StringAccumulator;
    private static int ByteAccumulator;
    private static int ByteOverflowCount;
    private static boolean NeedIntegerFlush;
    private static boolean NeedStringFlush;
    private static boolean NeedByteFlush;
    private static String lastMessage;

    public static void log(int message) {
        if (isActiveStringFlush()) flushString();
        if (isActiveByteFlush()) flushByte();
        setActiveIntegerFlush();
        IntegerAccumulator(message);
    }

    public static void log(byte message) {
        if (isActiveStringFlush()) flushString();
        if (isActiveIntegerFlush()) flushInteger();
        setActiveByteFlush();
        ByteAccumulator(message);
    }

    public static void log(char message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        if (isActiveIntegerFlush()) flushInteger();
        if (isActiveByteFlush()) flushByte();
        if (isChangedStringMessage(message)) flushString();
        setActiveStringFlush();
        StringAccumulator(message);
    }

    public static void log(boolean message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    private static boolean isActiveStringFlush() {
        return NeedStringFlush;
    }

    private static boolean isActiveByteFlush() {
        return NeedByteFlush;
    }

    private static boolean isActiveIntegerFlush() {
        return NeedIntegerFlush;
    }

    private static void setActiveStringFlush() {
        NeedStringFlush = true;
    }

    private static void setActiveByteFlush() {
        NeedByteFlush = true;
    }

    private static void setActiveIntegerFlush() {
        NeedIntegerFlush = true;
    }

    public static void flushInteger() {
        for (int i = 0; i < IntegerOverflowCount; i++) {
            ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage((int)Integer.MAX_VALUE));
        }
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage((int)IntegerAccumulator));
        IntegerAccumulator = 0;
        IntegerOverflowCount = 0;
        NeedIntegerFlush = false;
    }

    public static void flushByte() {
        for (int i = 0; i < ByteOverflowCount; i++) {
            ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage((byte)Byte.MAX_VALUE));
        }
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage((byte)ByteAccumulator));
        ByteAccumulator = 0;
        ByteOverflowCount = 0;
        NeedByteFlush = false;
    }

    public static void flushString() {
        if (StringAccumulator == 1) {
            ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(lastMessage));
        } else if (StringAccumulator > 1) {
            ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(lastMessage + " (x" + StringAccumulator) + ")");
        }
        StringAccumulator = 0;
        lastMessage = null;
        NeedStringFlush = false;
    }

    private static boolean isChangedStringMessage(String message) {
        return (!Objects.equals(message,lastMessage));
    }

    private static void StringAccumulator(String message) {
        lastMessage = message;
        StringAccumulator++;
    }

    private static void ByteAccumulator(byte message) {
        ByteAccumulator += message;
        if (ByteAccumulator > Byte.MAX_VALUE) {
            ByteOverflowCount = ByteAccumulator / Byte.MAX_VALUE;
            ByteAccumulator = ByteAccumulator % Byte.MAX_VALUE;
        }
    }

    private static void IntegerAccumulator(int message) {
        IntegerAccumulator += message;
        if (IntegerAccumulator > Integer.MAX_VALUE) {
            IntegerOverflowCount = IntegerAccumulator / Integer.MAX_VALUE;
            IntegerAccumulator = IntegerAccumulator % Integer.MAX_VALUE;
        }
    }
}