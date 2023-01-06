package com.cpi.template;

import com.sap.gateway.ip.core.customdev.util.Message;

static void main(String[] args) {
    print(args);
}

static Message main(Message message) {
    Object body = message.getBody();

    message.setBody("${body} Body is modified");
    return message;
}

