package com.acme.dbo.txlog;

public class MessageAccumulator {
    private static long IntegerAccumulator;
    private static long IntegerOverflowCount;
    private static int StringAccumulator;
    private static int ByteAccumulator;
    private static int ByteOverflowCount;
    private static boolean NeedIntegerFlush;
    private static boolean NeedStringFlush;
    private static boolean NeedByteFlush;
    private static String lastMessage;

    public static boolean isActiveStringFlush() {
        return NeedStringFlush;
    }

    public static boolean isActiveByteFlush() {
        return NeedByteFlush;
    }

    public static boolean isActiveIntegerFlush() {
        return NeedIntegerFlush;
    }

    public static void setActiveStringFlush() {
        NeedStringFlush = true;
    }

    public static void setActiveByteFlush() {
        NeedByteFlush = true;
    }

    public static void setActiveIntegerFlush() {
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

    public static boolean isStringMessageChanged(String message) {
        return (!message.equals(lastMessage) && lastMessage != null);
    }

    public static void StringAccumulator(String message) {
        lastMessage = message;
        StringAccumulator++;
    }

    public static void ByteAccumulator(byte message) {
        ByteAccumulator += message;
        if (ByteAccumulator > Byte.MAX_VALUE) {
            ByteOverflowCount = ByteAccumulator / Byte.MAX_VALUE;
            ByteAccumulator = ByteAccumulator % Byte.MAX_VALUE;
        }
    }

    public static void IntegerAccumulator(int message) {
        IntegerAccumulator += message;
        if (IntegerAccumulator > Integer.MAX_VALUE) {
            IntegerOverflowCount = IntegerAccumulator / Integer.MAX_VALUE;
            IntegerAccumulator = IntegerAccumulator % Integer.MAX_VALUE;
        }
    }
}
