package com.cpi.northwind.customers

import com.cpi.northwind.customers.fixtures.MessageFixture
import com.sap.gateway.ip.core.customdev.util.Message
import org.junit.jupiter.api.Test

class PostProcessing_XMLImplTest {

    @Test
    void main_Should_TransformJSONBodyMessage_When_Requested() {
        Message message = PostProcessing_XMLImpl.postProcessing_XML(MessageFixture.WITH_JSON_BODY());
        assert !message.getBody().toString().contains('"odata.context"');
    }

    @Test
    void main_Should_CreateInstance_When_Called() {
        assert new PostProcessing_XMLImpl() instanceof PostProcessing_XMLImpl;
    }

}
