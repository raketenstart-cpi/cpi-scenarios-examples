package com.cpi.northwind.customers

import com.sap.gateway.ip.core.customdev.util.Message

static Message preProcessing(Message message) {
    Map<String, Object> headers = message.getHeaders();
    def httpPath = headers.get("CamelHttpPath");

    if (httpPath != null) {
        message.setHeader('x-http-path', httpPath);
        message.setHeader('CamelHttpPath', '');
    }

    return message;
}
