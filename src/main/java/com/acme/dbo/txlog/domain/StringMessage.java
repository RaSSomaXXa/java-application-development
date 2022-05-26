package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;

public class StringMessage extends PrefixMessageDecorator {
    private static final String STRING_PREFIX = "string: ";
    String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public StringMessage(String body){
        super(STRING_PREFIX);
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return super.decorate(getBody());
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof StringMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += ((StringMessage)message).body;
    }
}
