package com.cpi.template

import com.cpi.template.fixtures.MessageFixture
import com.sap.gateway.ip.core.customdev.util.Message
import org.junit.jupiter.api.Test

class MainTest {

    @Test
    void main_Should_TransformEmptyBodyMessage_When_Requested() {
        Message message = MainImpl.main(MessageFixture.WITH_EMPTY_BODY_TEXT() as Message);
        assert message.getBody().toString().contains('Body is modified');
    }

    @Test
    void main_Should_TransformBodyMessage_When_Requested() {
        Message message = MainImpl.main(MessageFixture.WITH_BODY_TEXT() as Message);
        assert message.getBody().toString() == 'test Body is modified';
    }

    @Test
    void main_Should_Execute_When_dummyCall() {
        MainImpl.main();
        assert true;
    }

}
