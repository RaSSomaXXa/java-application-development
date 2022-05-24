package com.acme.dbo.txlog.printer;

public class ConsoleMessagePrinter implements MessagePrinter {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}