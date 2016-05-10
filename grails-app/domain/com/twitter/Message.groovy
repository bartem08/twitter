package com.twitter

class Message {

    String content
    Date dateCreated

    static belongsTo = [profile: Profile]

    static constraints = {
        content blank: false, maxSize: 1000
    }

    static mapping = {
        profile lazy: false
        sort dateCreated: 'desc'
    }
}
