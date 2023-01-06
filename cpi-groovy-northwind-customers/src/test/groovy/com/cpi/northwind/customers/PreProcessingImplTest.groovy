package com.cpi.northwind.customers

import com.cpi.northwind.customers.fixtures.MessageFixture
import com.sap.gateway.ip.core.customdev.util.Message
import org.apache.commons.lang3.StringUtils
import org.junit.jupiter.api.Test

class PreProcessingImplTest {

    private static final String TEST_X_HTTP_PATH_EXP = 'countryId';

    @Test
    void main_Should_TransformJSONBodyMessage_When_Requested() {
        Message message_exp = MessageFixture.WITH_JSON_BODY();
        Message message_act = PreProcessingImpl.preProcessing(message_exp);

        Map<String, Object> headers = message_act.getHeaders();
        assert headers.get('x-http-path') == TEST_X_HTTP_PATH_EXP;
        assert headers.get('CamelHttpPath') == StringUtils.EMPTY;
        assert message_act.getBody() == message_exp.getBody();
    }

    @Test
    void main_Should_CreateInstance_When_Called() {
        assert new PreProcessingImpl() instanceof PreProcessingImpl;
    }

}
