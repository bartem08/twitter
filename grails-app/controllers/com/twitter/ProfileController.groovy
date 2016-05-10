package com.twitter

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProfileController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService
    def profileService

    @Secured('ROLE_USER')
    def index() {
        respond springSecurityService.currentUser
    }

    def all(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Profile.list(params)
    }

    def create() {
        respond new Profile(params)
    }

    def search() {
        try {
            return [profiles: profileService.search(params.username), term: params.username]
        } catch (ProfileException pe) {
            log.error 'Could not find profiles', pe
            flash.message = pe
            redirect action: 'all'
        }
    }

    @Secured('ROLE_USER')
    def subscribe(Profile profileInstance) {
        try {
            profileService.subscribe(springSecurityService.currentUser, profileInstance)
        } catch (ProfileException pe) {
            log.error 'Could not subscribe', pe
            flash.message = pe
        }
        redirect action: 'index'
    }

    @Transactional
    def save(Profile profileInstance) {
        try {
            profileService.createProfile(profileInstance)
            redirect controller: 'login', action: 'auth'
        } catch (ProfileException pe) {
            log.error 'Could not create profile', pe
            flash.message = pe
            respond profileInstance.errors, view: 'create'
        }
    }

}
