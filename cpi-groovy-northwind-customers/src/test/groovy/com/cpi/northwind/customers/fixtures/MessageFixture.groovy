package com.cpi.northwind.customers.fixtures

import com.cpi.northwind.customers.utils.FileUtils
import com.sap.gateway.ip.core.customdev.util.Message

class MessageFixture {

    private static body_application_json = '';
    private static Map<String, Object> headers = new HashMap<String, Object>();

    private static final Message JSON_MESSAGE = [
        getHeaders: { headers },
        setHeader : { String var1, Object var2 -> headers.put(var1, var2) },
        getBody   : { body_application_json },
        setBody   : { Object var1 -> body_application_json = var1 },
    ] as Message;

    static Message WITH_JSON_BODY() {
        headers.put('CamelHttpPath', 'countryId');
        headers.put('x-accept', 'application/xml');

        String jsonString = FileUtils.readFileToString("data.json", this);
        body_application_json = jsonString;
        return JSON_MESSAGE;
    }
}
