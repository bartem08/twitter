<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'profile.label', default: 'Profile')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="col-sm-4" style="text-align: center">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Registration</h3>
			</div>
			<div class="panel-body">
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
				<g:hasErrors bean="${profileInstance}">
					<ul class="errors" role="alert">
						<g:eachError bean="${profileInstance}" var="error">
							<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
						</g:eachError>
					</ul>
				</g:hasErrors>
				<g:form url="[resource:profileInstance, action:'save']" class="form-inline form-group" >
					<fieldset class="form">
						<g:render template="form"/>
					</fieldset>
					<fieldset class="buttons">
						<g:submitButton name="create" class="btn btn-default" value="Register" />
					</fieldset>
				</g:form>
			</div>
		</div>
	</div><!-- /.col-sm-4 -->

	</body>
</html>
