package com.acme.dbo.txlog.domain;

public class StringMessage {
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
}
