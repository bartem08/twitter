<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Twitter"/></title>
  		<asset:stylesheet src="bootstrap.min.css"/>
		<asset:javascript src="bootstrap.js"/>
		<g:layoutHead/>
	</head>
	<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/twitter">Twitter</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<sec:ifNotLoggedIn>
						<li><g:link controller="profile" action="create">Registration</g:link></li>
						<li><g:link controller="profile" action="all">All users</g:link></li>
						<li><g:link controller="login" action="auth">Login</g:link></li>
					</sec:ifNotLoggedIn>
					<sec:ifLoggedIn>
						<li><g:link controller="profile" action="index">Home</g:link></li>
						<li><g:link controller="message" action="timeline">Timeline</g:link></li>
						<li><g:link controller="profile" action="all">All users</g:link></li>
						<li><g:link controller="logout" action="index">Logout</g:link></li>
					</sec:ifLoggedIn>
					<g:form controller="profile" action="search" class="navbar-form navbar-right">
						<g:textField name="username" class="form-control" placeholder="Search..."/>
					</g:form>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</nav>
		<g:layoutBody/>

	</body>
</html>
