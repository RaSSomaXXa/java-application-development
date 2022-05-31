package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.domain.Message;
import com.acme.dbo.txlog.printer.ConsoleMessagePrinter;
import com.acme.dbo.txlog.printer.MessagePrinter;

import java.util.Objects;


public class LogService {

    private long IntegerAccumulator;
    private long IntegerOverflowCount;
    private int StringAccumulator;
    private int ByteAccumulator;
    private int ByteOverflowCount;
    private boolean NeedIntegerFlush;
    private boolean NeedStringFlush;
    private boolean NeedByteFlush;

    private Message lastMessage;
    //should add logic for NPE when it's not initialize;
    //as idea - replace message and lastMessage into equal...but also need protect from null;
    //also it's look like better to use DI;

    private MessagePrinter printer = new ConsoleMessagePrinter();

    public void log(Message message) {
        if (!(Objects.equals(null,lastMessage)) && lastMessage.isSame(message)) {
            lastMessage.accumulate(message);
        } else if (!(Objects.equals(null,lastMessage))){
            printer.print(lastMessage.decorate());
        } else {
            lastMessage = message;
        }
    }

    public void flush() {
        printer.print(lastMessage.decorate());
        lastMessage.flush();
    }

    /*

    public void log(int[] message) {
        printer.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(int[][] message) {
        printer.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(int[][][][] message) {
        printer.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(String... message) {
        printer.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(Integer... message) {
        printer.print((prefixMessageDecorator.decorateMessage(message)));
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
            printer.print(prefixMessageDecorator.decorateMessage((int)Integer.MAX_VALUE));
        }
        printer.print(prefixMessageDecorator.decorateMessage((int)IntegerAccumulator));
        IntegerAccumulator = 0;
        IntegerOverflowCount = 0;
        NeedIntegerFlush = false;
    }

    public void flushByte() {
        for (int i = 0; i < ByteOverflowCount; i++) {
            printer.print(prefixMessageDecorator.decorateMessage((byte)Byte.MAX_VALUE));
        }
        printer.print(prefixMessageDecorator.decorateMessage((byte)ByteAccumulator));
        ByteAccumulator = 0;
        ByteOverflowCount = 0;
        NeedByteFlush = false;
    }

    public void flushString() {
        if (StringAccumulator == 1) {
            printer.print(prefixMessageDecorator.decorateMessage(lastMessage));
        } else if (StringAccumulator > 1) {
            printer.print(prefixMessageDecorator.decorateMessage(lastMessage + " (x" + StringAccumulator) + ")");
        }
        StringAccumulator = 0;
        lastMessage = null;
        NeedStringFlush = false;
    }

    private boolean isChangedStringMessage(String message) {
        return (!Objects.equals(message,lastMessage));
    }

    private void StringAccumulator(String message) {
        this.lastMessage = message;
        this.StringAccumulator++;
    }

    private void ByteAccumulator(byte message) {
        ByteAccumulator += message;
        if (ByteAccumulator > Byte.MAX_VALUE) {
            ByteOverflowCount = ByteAccumulator / Byte.MAX_VALUE;
            ByteAccumulator = ByteAccumulator % Byte.MAX_VALUE;
        }
    }

    private void IntegerAccumulator(int message) {
        this.IntegerAccumulator += message;
        if (IntegerAccumulator > Integer.MAX_VALUE) {
            IntegerOverflowCount = IntegerAccumulator / Integer.MAX_VALUE;
            IntegerAccumulator = IntegerAccumulator % Integer.MAX_VALUE;
        }
    }

     */
}