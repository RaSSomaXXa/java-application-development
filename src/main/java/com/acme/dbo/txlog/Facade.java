package com.acme.dbo.txlog;

import com.acme.dbo.txlog.domain.*;
import com.acme.dbo.txlog.service.LogService;

import java.util.Objects;

public class Facade {

    private static LogService logService = new LogService();

    public static void log(int message) {
        logService.log(new IntMessage(message));
    }

    public static void log(byte message) {
        logService.log(new ByteMessage(message));
    }

    public static void log(char message) {
        logService.log(new CharMessage(message));
    }

    public static void log(String message) {
        logService.log(new StringMessage(message));
    }

    public static void log(boolean message) {
        logService.log(new BooleanMessage(message));
    }

    public static void log(Object message) {
        logService.log(new ObjectMessage());
    }


    public static void flushInteger() {
        logService.flush();
    }

    /*

    public static void flushByte() {
        logService.flushByte();
    }

    public static void flushString() {
        logService.flushString();
    }



        public void log(byte message) {
        if (isActiveStringFlush()) flushString();
        if (isActiveIntegerFlush()) flushInteger();
        setActiveByteFlush();
        ByteAccumulator(message);
    }

    public void log(char message) {
        consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage(message));
    }

    public void log(StringMessage message) {
        if (isActiveIntegerFlush()) flushInteger();
        if (isActiveByteFlush()) flushByte();
        if (isChangedStringMessage(message.getBody())) flushString();
        setActiveStringFlush();
        StringAccumulator(message.getBody());
    }

    public void log(boolean message) {
        consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage(message));
    }

    public void log(Object message) {
        consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage(message));
    }

    public void log(int[] message) {
        consoleMessagePrinter.printMessage((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(int[][] message) {
        consoleMessagePrinter.printMessage((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(int[][][][] message) {
        consoleMessagePrinter.printMessage((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(String... message) {
        consoleMessagePrinter.printMessage((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(Integer... message) {
        consoleMessagePrinter.printMessage((prefixMessageDecorator.decorateMessage(message)));
    }

    private boolean isActiveStringFlush() {
        return NeedStringFlush;
    }

    private boolean isActiveByteFlush() {
        return NeedByteFlush;
    }

    private boolean isActiveIntegerFlush() {
        return NeedIntegerFlush;
    }

    private void setActiveStringFlush() {
        NeedStringFlush = true;
    }

    private void setActiveByteFlush() {
        NeedByteFlush = true;
    }

    private void setActiveIntegerFlush() {
        NeedIntegerFlush = true;
    }

    public void flushInteger() {
        for (int i = 0; i < IntegerOverflowCount; i++) {
            consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage((int)Integer.MAX_VALUE));
        }
        consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage((int)IntegerAccumulator));
        IntegerAccumulator = 0;
        IntegerOverflowCount = 0;
        NeedIntegerFlush = false;
    }

    public void flushByte() {
        for (int i = 0; i < ByteOverflowCount; i++) {
            consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage((byte)Byte.MAX_VALUE));
        }
        consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage((byte)ByteAccumulator));
        ByteAccumulator = 0;
        ByteOverflowCount = 0;
        NeedByteFlush = false;
    }

    public void flushString() {
        if (StringAccumulator == 1) {
            consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage(lastMessage));
        } else if (StringAccumulator > 1) {
            consoleMessagePrinter.printMessage(prefixMessageDecorator.decorateMessage(lastMessage + " (x" + StringAccumulator) + ")");
        }
        StringAccumulator = 0;
        lastMessage = null;
        NeedStringFlush = false;
    }

    private boolean isChangedStringMessage(String message) {
        return (!Objects.equals(message,lastMessage));
    }

    private void StringAccumulator(String message) {
        lastMessage = message;
        StringAccumulator++;
    }

    private void ByteAccumulator(byte message) {
        ByteAccumulator += message;
        if (ByteAccumulator > Byte.MAX_VALUE) {
            ByteOverflowCount = ByteAccumulator / Byte.MAX_VALUE;
            ByteAccumulator = ByteAccumulator % Byte.MAX_VALUE;
        }
    }

    private void IntegerAccumulator(int message) {
        IntegerAccumulator += message;
        if (IntegerAccumulator > Integer.MAX_VALUE) {
            IntegerOverflowCount = IntegerAccumulator / Integer.MAX_VALUE;
            IntegerAccumulator = IntegerAccumulator % Integer.MAX_VALUE;
        }
    }

 */
}