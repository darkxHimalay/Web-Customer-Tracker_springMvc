<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 21-06-2018
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>CRM</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper" >
    <div id="header">
        <h2>CRM- Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <div id="">
            <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button">
        </div>
        <table>
            <tr>
                <th>First Name </th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Update</th>
            </tr>
            <c:forEach var="customers" items="${customers}">
                <c:url var="update" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${customers.id}"></c:param>
                </c:url>
                <c:url var="delete" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${customers.id}"></c:param>
                </c:url>
                <tr>
                    <td>${customers.firstName}</td>
                    <td>${customers.lastName}</td>
                    <td>${customers.email}</td>
                    <td><a href="${update}">Update</a>|<a href="${delete}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>