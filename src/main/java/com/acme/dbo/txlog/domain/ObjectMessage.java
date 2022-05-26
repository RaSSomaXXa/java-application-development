package com.acme.dbo.txlog.domain;

import com.acme.dbo.txlog.decorator.PrefixMessageDecorator;

public class ObjectMessage extends PrefixMessageDecorator {
    private static final String OBJECT_PREFIX = "reference: ";

    public ObjectMessage(){
        super(OBJECT_PREFIX);
    }

    @Override
    public String decorate() {
        return super.decorate(this.toString());
    }

    @Override
    public boolean isSame(Message message) {
        return message instanceof ObjectMessage;
    }

    @Override
    public void accumulate(Message message) {

    }
}
