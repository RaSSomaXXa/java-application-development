package com.acme.dbo.txlog.domain;

public interface Message {
    String decorate();
    boolean isSame(Message message);
    void accumulate(Message message);
    void flush();
}
