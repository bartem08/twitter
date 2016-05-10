
<%@ page import="com.twitter.Profile" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Profile</title>
	</head>
	<body>
	<div class="col-sm-3">
		<div class="list-group">
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Username</h4>
				<p class="list-group-item-text"><g:fieldValue field="username" bean="${profileInstance}"/></p>
			</a>
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">First name</h4>
				<p class="list-group-item-text"><g:fieldValue field="firstName" bean="${profileInstance}"/></p>
			</a>
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Last name</h4>
				<p class="list-group-item-text"><g:fieldValue field="lastName" bean="${profileInstance}"/></p>
			</a>
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Email</h4>
				<p class="list-group-item-text"><g:fieldValue field="email" bean="${profileInstance}"/></p>
			</a>
			<g:if test="${profileInstance?.following}">
				<a href="#" class="list-group-item">
					<h4 class="list-group-item-heading">Following</h4>
					<g:each in="${profileInstance?.following}" var="follow">
						<p class="list-group-item-text">${follow?.username}</p>
					</g:each>
				</a>
			</g:if>
		</div>
	</div><!-- /.col-sm-4 -->
	</body>
</html>
