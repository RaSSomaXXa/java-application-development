package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.domain.decorator.PrefixMessageDecorator;

public class BooleanMessage extends PrefixMessageDecorator {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private boolean body;

    public boolean getBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }

    public BooleanMessage(boolean body){
        super(PRIMITIVE_PREFIX);
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return super.decorate(String.valueOf(getBody()));
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body = this.body & ((BooleanMessage)message).getBody();
    }

}
