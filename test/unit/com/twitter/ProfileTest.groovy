package com.twitter

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Profile)
class ProfileTest extends Specification {

    def "test password validation"() {
        setup:
            mockForConstraintsTests(Profile)
            def profile = new Profile(password: password)
        when:
            profile.validate()
        then:
            profile.errors['password'] == error
        where:
            password << [null, '', 'xyz']
            error << ['nullable', 'nullable', null]
    }

    def "test email validation"() {
        setup:
            mockForConstraintsTests(Profile)
            def profile = new Profile(email: email)
        when:
            profile.validate()
        then:
            profile.errors['email'] == error
        where:
            email << [null, '', 'a', 'a@b', 'a@b.com']
            error << ['nullable', 'nullable', 'email', 'email', null]

    }

}
