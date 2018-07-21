<%--
  Created by IntelliJ IDEA.
  User: Himalay
  Date: 24-06-2018
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper" >
    <div id="header">
        <h2>CRM- Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <form:hidden path="id" />
     <table>
         <tbody>
         <tr><td><label>First Name :</label></td>
             <td><form:input path="firstName"/></td>
         </tr>
         <tr>
             <td><label>Last Name :</label></td>
             <td><form:input path="lastName"></form:input></td>
         </tr>
         <tr>
             <td><label>Email :</label></td>
             <td><form:input path="email"></form:input></td>
         </tr>
         <tr>
             <td><label></label></td>
             <td><input type="submit" value="Save" class="add-button save"></td>
         </tr>
         </tbody>
     </table>
    </form:form>
    <div style="clear: both;">
        <p>
            <a href="${pageContext.request.contextPath}/customer/list" class="add-button">Go BacK To List</a>
        </p>
    </div>
</div>
</body>
</html>
