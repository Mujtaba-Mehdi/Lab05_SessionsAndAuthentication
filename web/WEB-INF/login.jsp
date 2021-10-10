<%-- 
    Document   : login
    Created on : 6-Oct-2021, 1:52:14 PM
    Author     : mujta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <label>Username </label>
        <input type="text" name="username" value="${AccountService.username}">
        <br>
        <label>Password: </label>
        <input type="text" name="password">${AccountService.password}</input>
        <br>
        <input type="submit" value="Log In">
    </body>
</html>
