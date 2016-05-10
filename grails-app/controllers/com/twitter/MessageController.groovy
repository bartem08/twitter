package com.twitter

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('ROLE_USER')
class MessageController {

    def springSecurityService
    def messageService

    def timeline() {
        [profile: springSecurityService.currentUser]
    }

    def create() {
        try {
            messageService.createMessage(springSecurityService.currentUser, params.content)
            flash.message = 'New post added'
        } catch (MessageException me) {
            log.error 'Failed to create message', me
            flash.message = me.message
        }
        redirect action: 'timeline'
    }
}
