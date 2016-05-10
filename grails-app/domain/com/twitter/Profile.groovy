package com.twitter

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Profile implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String firstName
	String lastName
	String email
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<Role> getAuthorities() {
		ProfileRole.findAllByProfile(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static hasMany = [messages: Message, following: Profile]

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
		firstName nullable: true
		lastName nullable: true
		email email: true
		messages nullable: true
		following nullable: true
	}

	static mapping = {
		password column: '`password`'
	}
}
