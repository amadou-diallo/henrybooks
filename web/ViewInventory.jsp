<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Henry Books</title>
    </head>
    <style>
        .right {
            text-align: right;
        }
        .left {
            text-align: left;
        }
    </style>
    <c:if test="${!user.authenticated}">
        <script type="text/javascript">
            window.location = "/HenryBooks";
        </script>    
    </c:if>
    <body>
        <h3>User: ${user.userID} - ${user.userName}, ${user.adminLevel} Level</h3>
        <br>Branch #: <b>${store.storeID}</b>
        <br>Branch Name: <b>${store.storeName}</b>
        <br>Branch Location: <b>${store.storeAddr}</b><br>
        <br>
        <c:if test="${user.adminLevel == 'Admn'}">
            <form action="SelectedBook" method="post" > 
                Book Cd: <input type="text" name="bookcd" id="bookcd"/>
                <input type="submit" value="Edit Record"><br>
            </form>
            ${msg}
            <br>
        </c:if>
        <table border="1">
            <tr>
                <th>Store</th>
                <th>Book Cd</th>
                <th>Title</th>
                <th>Retail Price</th>
                <th>Quantity</th>
            </tr>
            <c:forEach var="inv" items="${inventory}">
                <tr>
                    <td class="right">${inv.storeID}</td>
                    <td class="right">${inv.bookID}</td>
                    <td class="left">${inv.title}</td>
                    <td class="right">${inv.priceF}</td>
                    <td class="right">${inv.onHand}</td>
                </tr>
            </c:forEach> 
       </table>
    </body>
</html>
