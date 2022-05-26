package com.acme.dbo.txlog.domain;

public class StringMessage implements Message {
    private static final String STRING_PREFIX = "string: ";
    String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public StringMessage(String body){
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return STRING_PREFIX + getBody();
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
