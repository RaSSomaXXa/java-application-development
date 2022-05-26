package com.acme.dbo.txlog.domain;

public class CharMessage implements Message {
    private static final String CHAR_PREFIX = "char: ";
    char body;

    public char getBody() {
        return body;
    }

    public void setBody(char body) {
        this.body = body;
    }

    public CharMessage(char body){
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return CHAR_PREFIX + getBody();
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
