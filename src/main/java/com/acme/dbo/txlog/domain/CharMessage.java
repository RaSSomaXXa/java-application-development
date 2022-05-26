package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.domain.decorator.PrefixMessageDecorator;

public class CharMessage extends PrefixMessageDecorator {
    private static final String CHAR_PREFIX = "char: ";
    private char body;

    public char getBody() {
        return body;
    }

    public void setBody(char body) {
        this.body = body;
    }

    public CharMessage(char body){
        super(CHAR_PREFIX);
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return super.decorate(String.valueOf(getBody()));
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof CharMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += ((CharMessage)message).body;
    }

}
