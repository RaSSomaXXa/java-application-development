package com.acme.dbo.txlog;

public class Facade {

    public static void log(int message) {
        if (MessageAccumulator.isActiveStringFlush()) {
            MessageAccumulator.flushString();
        }
        if (MessageAccumulator.isActiveByteFlush()) {
            MessageAccumulator.flushByte();
        }
        MessageAccumulator.setActiveIntegerFlush();
        MessageAccumulator.IntegerAccumulator(message);
    }

    public static void log(byte message) {
        if (MessageAccumulator.isActiveStringFlush()) {
            MessageAccumulator.flushString();
        }
        if (MessageAccumulator.isActiveIntegerFlush()) {
            MessageAccumulator.flushInteger();
        }
        MessageAccumulator.setActiveByteFlush();
        MessageAccumulator.ByteAccumulator(message);
    }

    public static void log(char message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(String message) {
        if (MessageAccumulator.isActiveIntegerFlush()) {
            MessageAccumulator.flushInteger();
        }
        if (MessageAccumulator.isActiveByteFlush()) {
            MessageAccumulator.flushByte();
        }
        if (MessageAccumulator.isStringMessageChanged(message)) {
            MessageAccumulator.flushString();
        }
        MessageAccumulator.setActiveStringFlush();
        MessageAccumulator.StringAccumulator(message);
    }

    public static void log(boolean message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }

    public static void log(Object message) {
        ConsoleMessagePrinter.printMessage(PrefixMessageDecorator.decorateMessage(message));
    }
}