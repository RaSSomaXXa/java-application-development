package com.acme.dbo.txlog.service;

import com.acme.dbo.txlog.printer.ConsoleMessagePrinter;
import com.acme.dbo.txlog.printer.MessagePrinter;
import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;
import com.acme.dbo.txlog.domain.IntMessage;
import com.acme.dbo.txlog.domain.StringMessage;

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
    private String lastMessage;

    MessagePrinter MessagePrinter = new ConsoleMessagePrinter();
    PrefixMessageDecorator prefixMessageDecorator = new PrefixMessageDecorator();

    public void log(IntMessage message) {
        if (this.isActiveStringFlush()) flushString();
        if (this.isActiveByteFlush()) flushByte();
        this.setActiveIntegerFlush();
        this.IntegerAccumulator(message.getBody());
    }

    public void log(byte message) {
        if (isActiveStringFlush()) flushString();
        if (isActiveIntegerFlush()) flushInteger();
        setActiveByteFlush();
        ByteAccumulator(message);
    }

    public void log(char message) {
        MessagePrinter.print(prefixMessageDecorator.decorateMessage(message));
    }

    public void log(StringMessage message) {
        if (isActiveIntegerFlush()) flushInteger();
        if (isActiveByteFlush()) flushByte();
        if (isChangedStringMessage(message.getBody())) flushString();
        setActiveStringFlush();
        StringAccumulator(message.getBody());
    }

    public void log(boolean message) {
        MessagePrinter.print(prefixMessageDecorator.decorateMessage(message));
    }

    public void log(Object message) {
        MessagePrinter.print(prefixMessageDecorator.decorateMessage(message));
    }
    public void log(int[] message) {
        MessagePrinter.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(int[][] message) {
        MessagePrinter.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(int[][][][] message) {
        MessagePrinter.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(String... message) {
        MessagePrinter.print((prefixMessageDecorator.decorateMessage(message)));
    }

    public void log(Integer... message) {
        MessagePrinter.print((prefixMessageDecorator.decorateMessage(message)));
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
            MessagePrinter.print(prefixMessageDecorator.decorateMessage((int)Integer.MAX_VALUE));
        }
        MessagePrinter.print(prefixMessageDecorator.decorateMessage((int)IntegerAccumulator));
        IntegerAccumulator = 0;
        IntegerOverflowCount = 0;
        NeedIntegerFlush = false;
    }

    public void flushByte() {
        for (int i = 0; i < ByteOverflowCount; i++) {
            MessagePrinter.print(prefixMessageDecorator.decorateMessage((byte)Byte.MAX_VALUE));
        }
        MessagePrinter.print(prefixMessageDecorator.decorateMessage((byte)ByteAccumulator));
        ByteAccumulator = 0;
        ByteOverflowCount = 0;
        NeedByteFlush = false;
    }

    public void flushString() {
        if (StringAccumulator == 1) {
            MessagePrinter.print(prefixMessageDecorator.decorateMessage(lastMessage));
        } else if (StringAccumulator > 1) {
            MessagePrinter.print(prefixMessageDecorator.decorateMessage(lastMessage + " (x" + StringAccumulator) + ")");
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
}