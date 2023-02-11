<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link type="text/css" rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css">
<%--  <link type="text/css" rel="stylesheet"--%>
<%--        href="<c:url value="/resources/css/style.css" />" >--%>
</head>
<body>

<%--add product--%>
<input type="button" value="Add Product" onclick="window.location.href='formForAddProduct'; return false;">

<table class="main">
  <tr>
    <th>Name</th>
    <th>Description</th>
    <th>price</th>
    <th>Actions</th>
  </tr>


  <c:forEach var="product" items="${products}">

    <c:url var="updateLink" value="formForUpdate">
      <c:param name="ProductId" value="${product.id}"/>
    </c:url>
    <c:url var="deleteLink" value="delete">
      <c:param name="ProductId" value="${product.id}"/>
    </c:url>

    <tr>
      <th>${product.name}</th>
      <th>${product.description}</th>
      <th>${product.price}</th>
      <th>
        <a href="${updateLink}">Update</a>
        |
        <a href="${deleteLink}"
           onclick="if (!(confirm('Are you sure for deleting'))) return false ">Delete</a>
      </th>
    </tr>
  </c:forEach>

</table>
</body>
</html>