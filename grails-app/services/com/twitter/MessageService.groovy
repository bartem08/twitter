package com.twitter

import grails.transaction.Transactional

@Transactional
class MessageService {

    def createMessage(final Profile profile, final String content) {
        if (profile) {
            def message = new Message(content: content);
            profile.addToMessages(message)
            if (profile.save(flush: true)) {
                return message
            } else {
                throw new MessageException(info: 'Message did not pass validation', msg: message)
            }
        } else {
            throw new MessageException(info: 'Could not attach message to the null profile')
        }
    }
}

class MessageException extends RuntimeException {
    String info
    Message msg
}
