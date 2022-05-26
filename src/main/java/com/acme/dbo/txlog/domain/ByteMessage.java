package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;

public class ByteMessage extends PrefixMessageDecorator {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private byte body;

    public byte getBody() {
        return body;
    }

    public void setBody(byte body) {
        this.body = body;
    }

    public ByteMessage(byte body){
        super(PRIMITIVE_PREFIX);
        this.setBody(body);
    }

    @Override
    public String decorate() {
        return super.decorate(Byte.valueOf(getBody()).toString());
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
