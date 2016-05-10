<%@ page import="com.twitter.Profile" %>



<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'username', 'error')} required">
	<label for="username" class="sr-only">
		<g:message code="profile.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField style="margin-bottom: 10px" class="form-control" placeholder="Username:" name="username" required="" value="${profileInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'password', 'error')} required">
	<label for="password" class="sr-only">
		<g:message code="profile.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField style="margin-bottom: 10px" placeholder="Password:" class="form-control" name="password" required="" value="${profileInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'firstName', 'error')} ">
	<label for="firstName" class="sr-only">
		<g:message code="profile.firstName.label" default="First Name" />
		
	</label>
	<g:textField style="margin-bottom: 10px" placeholder="First name:" class="form-control" name="firstName" value="${profileInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'lastName', 'error')} ">
	<label for="lastName" class="sr-only">
		<g:message code="profile.lastName.label" default="Last Name" />
		
	</label>
	<g:textField style="margin-bottom: 10px" class="form-control" placeholder="Last name" name="lastName" value="${profileInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileInstance, field: 'email', 'error')} required">
	<label for="email" class="sr-only">
		<g:message code="profile.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField style="margin-bottom: 10px" placeholder="Email:" class="form-control" type="email" name="email" required="" value="${profileInstance?.email}"/>

</div>



