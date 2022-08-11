
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henry Books - Inventory Update</title>
    </head>
    <c:if test="${!user.authenticated}">
        <script type="text/javascript">
            window.location = "/HenryBooks";
        </script>    
    </c:if>
    <body>
        <p>User: ${user.userID} - ${user.userName}, ${user.adminLevel} Level</p>
        <br>Branch #: <b>${store.storeID}</b>
        <br>Branch Name: <b>${store.storeName}</b>
        <br>Branch Location: <b>${store.storeAddr}</b><br>
        <br>
        <br>Book Cd: <b>${inv.bookID}</b>
        <br>Book Title: <b>${inv.title}</b>
        <br>Author: <b>${inv.author}</b> 
        <br>
        <br>
        <form action="UpdateInventory" method="post" > 
              Inventory on hand in Branch: <input type="text" name="onhand" id="onhand"
                                                  value="${inv.onHand}"/><br> 
                <input type="submit" value="Update Inventory"><br>
        </form>
        <br>
        <form action="StoreSelection.jsp">
            <input type="submit" value="cancel">
        </form>
     ${msg}   
     </body>
</html>
