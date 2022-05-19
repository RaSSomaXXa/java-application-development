package com.acme.dbo.txlog.domain;

public class IntMessage {
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
}
