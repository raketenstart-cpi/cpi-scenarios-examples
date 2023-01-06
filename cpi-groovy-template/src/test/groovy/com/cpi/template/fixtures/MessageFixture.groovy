package com.cpi.template.fixtures

import com.sap.gateway.ip.core.customdev.util.Message

class MessageFixture {

    private static final TEXT_TEST = 'test';

    private static body_application_text_plain = '';
    private static Map<String, Object> headers = new HashMap<String, Object>();

    private static final Message BODY_TEXT = [
        getHeaders: { headers },
        setHeader : { String var1, Object var2 -> headers.put(var1, var2) },
        getBody: { body_application_text_plain },
        setBody: { Object var1 -> body_application_text_plain = var1 },
    ] as Message;

    static Message WITH_EMPTY_BODY_TEXT() {
        return BODY_TEXT;
    }

    static Message WITH_BODY_TEXT() {
        body_application_text_plain = TEXT_TEST;
        return BODY_TEXT;
    }
}
