package com.acme.dbo.txlog.domain;

public class IntMessage implements Message {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    int body;

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public IntMessage(int body){
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return PRIMITIVE_PREFIX + Integer.valueOf(getBody()).toString();
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof IntMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += ((IntMessage)message).body;
    }

}
