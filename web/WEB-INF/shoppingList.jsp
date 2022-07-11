<%-- 
    Document   : shoppingList
    Author     : parveen Kaur
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <main>
         
                  <c:out value="${message}"></c:out>
                  <a href="<c:url value='/ShoppingList'/>">Log Out</a>
                  
                  <div>
                  <h2>List</h2>
                  <form action="" method="post">
                      <label>Add item:</label>
                      <input type="text" name="item" value="">
                      <input type="submit" value="Add" name="action">
                      
                  </form>
                  </div>
                  
                  
                  
                  <div>
                      <form action="" method="post">
                          <div>
                      <c:forEach var="item" items="${itemlist}">
                          <li><input type="radio" name="shoppingitems" value="${item}">${item}</li>
                       </c:forEach>
                  </div>
                          <input type="submit" value="Delete" name="action">
                      </form>
                  </div>
                    
        </main>
    </body>
</html>
