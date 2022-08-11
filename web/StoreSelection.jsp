
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
           
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Selection</title>
    </head>
    <c:if test="${!user.authenticated}">
        <script type="text/javascript">
            window.location = "/HenryBooks";
        </script>    
    </c:if>
    <body>
        <h1>Inventory View/Update:</h1>
        <p>
            User: ${user.userID} - ${user.userName}, ${user.adminLevel} Level
        </p>
        <form action="ViewInventory" id="selection" method="post" > 
            Stores:<br>
            <select id="storeid" name="storeid" >
                <c:forEach var="st" items="${stores}"> 
                    <option ${st.storeID == user.storeID ? 'Selected ' : ''}
                        value="${st.storeID}">${st.storeName}</option> 
                </c:forEach>
            </select>
            <input type="submit" value="View/Edit Inventory" >
        </form>
        <br>
        ${msg}
        <br>
    </body>
</html>
