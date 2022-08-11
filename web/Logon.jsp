
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html >

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henry Books Inventory System</title>
    </head>
    <body>
        <h1>Welcome to the Inventory System</h1> 
        <p>Please Enter your id and password:</p>
        <form action="Logon" method="post">
            <table>
                <tr>
                    <td>User ID:</td>
                    <td><input type="text" name="userid" id="userid"
                         value="${empty user.userid ? cookie.memid.value : user.userID }" /></td>           
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" id="password">
                    </td>
                </tr>
            </table>
            <br>        
            <input type="submit" value="Logon">
        </form>
        <br>
        ${msg}
        Cookies: <br>
        <% 
           Cookie[] cookies = request.getCookies();
           if (cookies != null) {
               for (Cookie c: cookies) {
        %>
        <%= c.getName() %> = <%= c.getValue() %> <br>
         <%
               }
           }    
        %>
    </body>
</html>
