<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Xóa khách hàng</title>
</head>
<body>
<h1>Xác nhận xóa khách hàng</h1>

<p>Bạn có chắc chắn muốn xóa khách hàng này không?</p>

<p>ID: <c:out value="${customer.id}"/></p>
<p>Họ tên: <c:out value="${customer.name}"/></p>
<p>Email: <c:out value="${customer.email}"/></p>
<p>Địa chỉ: <c:out value="${customer.address}"/></p>

<form action="${pageContext.request.contextPath}/customers?action=delete"
      method="post">
    <input type="hidden" name="id" value="${customer.id}">
    <button type="submit">Xác nhận xóa</button>
    <a href="${pageContext.request.contextPath}/customers">Hủy</a>
</form>
</body>
</html>