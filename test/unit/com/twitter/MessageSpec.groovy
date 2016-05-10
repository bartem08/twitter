package com.twitter

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Message)
class MessageSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test content validation"() {
        setup:
            mockForConstraintsTests(Message)
            def message = new Message(content: messages)
        when:
            message.validate()
        then:
            message.errors['content'] == error
        where:
            messages << [null, '', 'hello']
            error << ['nullable', 'nullable', null]

    }

}

