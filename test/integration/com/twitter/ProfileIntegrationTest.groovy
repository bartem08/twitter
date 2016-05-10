package com.twitter

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Profile)
@Mock([Profile, SpringSecurityService])
class ProfileIntegrationTest extends Specification {

    def testProfile

    void setup() {
        testProfile = new Profile(username: 'bbb', password: 'b', email: 'a@a.com', firstName: 'a', lastName: 'a')
                .save()
    }

    void cleanup() {
        Profile.deleteAll()
    }

    def "test save method"() {
        setup:
            mockForConstraintsTests(Profile)
            def profile = new Profile(username: 'aaa', password: 'b', email: 'a@a.com', firstName: 'a', lastName: 'a')
        when:
            def result = profile.save()
        then:
            result
            Profile.findAllByUsernameLike('aaa')
            Profile.exists(result.id)
            Profile.count == 2
    }

    def "test delete method"() {
        setup:
            mockForConstraintsTests(Profile)
            def profile = new Profile(username: 'bbb', password: 'b', email: 'a@a.com', firstName: 'a', lastName: 'a')
                .save()
        when:
            profile.delete()
        then:
            Profile.count == 1
            !Profile.exists(profile.id)
    }

    def "test add message method"() {
        when:
            testProfile
                    .addToMessages(new Message(content: 'first'))
                    .addToMessages(new Message(content: 'second'))
                    .addToMessages(new Message(content: 'third'))
        then:
            testProfile.getMessages().size() == 3
    }

    def "test add followings method"() {
        setup:
            def first = new Profile(username: 'a').save(false)
            def second = new Profile(username: 'b').save(false)
            def third = new Profile(username: 'c').save(false)
        when:
            testProfile
                .addToFollowing(first).addToFollowing(second).addToFollowing(third)
        then:
            testProfile.getFollowing().size() == 3
            testProfile.getFollowing().contains(first)
    }

    def "test update method"() {
        setup:
            testProfile.username = 'kukuwka'
        when:
            def res = Profile.get(testProfile.id)
        then:
            res
            res.username == 'kukuwka'
    }
}
