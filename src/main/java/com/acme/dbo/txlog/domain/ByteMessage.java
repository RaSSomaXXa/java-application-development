package com.acme.dbo.txlog.domain;

public class ByteMessage implements Message {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    byte body;

    public byte getBody() {
        return body;
    }

    public void setBody(byte body) {
        this.body = body;
    }

    public ByteMessage(byte body){
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return PRIMITIVE_PREFIX + Byte.valueOf(getBody()).toString();
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof ByteMessage;
    }

    @Override
    public void accumulate(Message message) {
        this.body += ((ByteMessage)message).body;
    }

}
