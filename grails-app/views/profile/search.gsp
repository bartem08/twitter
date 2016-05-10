<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div id="list-profile" class="content scaffold-list" role="main">
    <div class="col-sm-7">
        <h1>Profiles with username like '${term}'</h1>
        <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
        </g:if>
        <table class="table table-responsive">
            <thead>
            <tr>

                <g:sortableColumn property="firstName" title="${message(code: 'profile.firstName.label')}" />

                <g:sortableColumn property="lastName" title="${message(code: 'profile.lastName.label')}" />

                <g:sortableColumn property="email" title="${message(code: 'profile.email.label')}" />

                <td><g:message code="default.action.label"/></td>

            </tr>
            </thead>
            <tbody>
            <g:each in="${profiles}" status="i" var="profileInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td>${fieldValue(bean: profileInstance, field: "firstName")}</td>

                    <td>${fieldValue(bean: profileInstance, field: "lastName")}</td>

                    <td>${fieldValue(bean: profileInstance, field: "email")}</td>

                    <td>
                        <sec:ifLoggedIn>
                            <g:form url="[resource: profileInstance, action: 'subscribe']"  method="POST">
                                <g:submitButton name="Subscribe" class="btn btn-primary"/>
                            </g:form>
                        </sec:ifLoggedIn>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>