
<%@ page import="com.twitter.Profile" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Timeline</title>
</head>
<body>
    <div class="col-sm-7">
        <h1>Messages</h1>
        <div class="col-sm-13">
            <g:form action="create" class="form-group">
                <g:textField id="content" name="content" class="form-control" placeholder="Message..."/>
                <g:submitButton name="Send" class="btn btn-primary" style="margin-top: 10px"/>
            </g:form>
        </div>
        <span class="text-success"><g:if test="${flash.message}">${flash.message}</g:if></span>
        <table class="table table-responsive">
            <thead>
                <tr>
                    <th>Profile</th>
                    <th>Message</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${profile.messages}" var="m">
                    <tr>
                        <td>${profile.username}</td>
                        <td>${m.content}</td>
                        <td>${m.dateCreated}</td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div><!-- /.col-sm-4 -->
</body>
</html>
