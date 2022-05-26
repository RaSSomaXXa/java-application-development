package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;

public class IntMessage extends PrefixMessageDecorator {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private int body;

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public IntMessage(int body){
        super(PRIMITIVE_PREFIX);
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return super.decorate(Integer.valueOf(getBody()).toString());
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += ((IntMessage)message).getBody();
    }

}
