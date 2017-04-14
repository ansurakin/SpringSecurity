<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/resources/css/home.css" rel="stylesheet"/>
        <title>Insert title here</title>
    </head>
    <body>

        <form method="POST" action="<%=request.getContextPath()%>/login" class="box login">
            <fieldset class="boxBody">
                <label> Username </label> <input type='text' name='user_login' value=''>
                <label> Password </label> <input type='password' name='password_login' />
            </fieldset>
            <footer>
                <input type="submit" class="btnLogin" value="Submit">
                <c:if test="${not empty error}">
                    <span class="error">${error}</span>
                </c:if>
            </footer>
        </form>
        
    </body>    
</html>