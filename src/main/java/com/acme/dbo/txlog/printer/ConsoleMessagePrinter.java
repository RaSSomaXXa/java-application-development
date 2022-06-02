package com.acme.dbo.txlog.printer;

public class ConsoleMessagePrinter implements MessagePrinter {
    @Override
    public void print(String message) throws PrintOperationException{
        if (message == null) throw new PrintOperationException("Incorrect message value. It's can' be null");
        System.out.println(message);
    }
}