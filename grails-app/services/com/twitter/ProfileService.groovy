package com.twitter

import grails.transaction.Transactional

@Transactional
class ProfileService {

    def createProfile(final Profile profile) {
        if (!profile) {
            throw new ProfileException(info: 'Could not create null profile', profile: profile)
        } else if (profile.hasErrors()) {
            throw new ProfileException(info: 'Profile did not pass validation', profile: profile)
        } else if (!profile.save(flash: true)) {
            throw new ProfileException(info: 'Could not create profile', profile: profile)
        } else {
            ProfileRole.create profile, Role.findByAuthority('ROLE_USER'), true
        }
    }

    def subscribe(final Profile current, final Profile following) {
        if (!current || !following) {
            throw new ProfileException(info: 'Could not subscribe with null profile', profile: current)
        } else {
            current.addToFollowing(following)
            if (!current.save(flush: true)) {
                throw new ProfileException(info: 'Could not subscribe', profile: current)
            }
        }
    }

    def search(final String username) {
        if (!username) {
            throw new ProfileException(info: 'Could not find null profile')
        } else {
            return Profile.findAllByUsername(username)
        }
    }
}

class ProfileException extends RuntimeException {
    String info
    Profile profile
}
