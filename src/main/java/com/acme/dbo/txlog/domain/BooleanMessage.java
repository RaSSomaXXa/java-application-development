package com.acme.dbo.txlog.domain;

public class BooleanMessage implements Message {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    boolean body;

    public boolean getBody() {
        return body;
    }

    public void setBody(boolean body) {
        this.body = body;
    }

    public BooleanMessage(boolean body){
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return PRIMITIVE_PREFIX + getBody();
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof BooleanMessage;
    }

    @Override
    public void accumulate(Message message) {

    }

}
