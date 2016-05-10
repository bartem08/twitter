package com.twitter

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class ProfileRole implements Serializable {

	private static final long serialVersionUID = 1

	Profile profile
	Role role

	ProfileRole(Profile u, Role r) {
		this()
		profile = u
		role = r
	}

	@Override
	boolean equals(other) {
		if (!(other instanceof ProfileRole)) {
			return false
		}

		other.profile?.id == profile?.id && other.role?.id == role?.id
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (profile) builder.append(profile.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static ProfileRole get(long profileId, long roleId) {
		criteriaFor(profileId, roleId).get()
	}

	static boolean exists(long profileId, long roleId) {
		criteriaFor(profileId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long profileId, long roleId) {
		ProfileRole.where {
			profile == Profile.load(profileId) &&
			role == Role.load(roleId)
		}
	}

	static ProfileRole create(Profile profile, Role role, boolean flush = false) {
		def instance = new ProfileRole(profile: profile, role: role)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Profile u, Role r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = ProfileRole.where { profile == u && role == r }.deleteAll()

		if (flush) { ProfileRole.withSession { it.flush() } }

		rowCount
	}

	static void removeAll(Profile u, boolean flush = false) {
		if (u == null) return

		ProfileRole.where { profile == u }.deleteAll()

		if (flush) { ProfileRole.withSession { it.flush() } }
	}

	static void removeAll(Role r, boolean flush = false) {
		if (r == null) return

		ProfileRole.where { role == r }.deleteAll()

		if (flush) { ProfileRole.withSession { it.flush() } }
	}

	static constraints = {
		role validator: { Role r, ProfileRole ur ->
			if (ur.profile == null || ur.profile.id == null) return
			boolean existing = false
			ProfileRole.withNewSession {
				existing = ProfileRole.exists(ur.profile.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['profile', 'role']
		version false
	}
}
