<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết khách hàng</title>
</head>
<body>
<h1>Chi tiết khách hàng</h1>

<table>
    <tr>
        <th>ID</th>
        <td><c:out value="${customer.id}"/></td>
    </tr>
    <tr>
        <th>Họ tên</th>
        <td><c:out value="${customer.name}"/></td>
    </tr>
    <tr>
        <th>Email</th>
        <td><c:out value="${customer.email}"/></td>
    </tr>
    <tr>
        <th>Địa chỉ</th>
        <td><c:out value="${customer.address}"/></td>
    </tr>
</table>

<p>
    <a href="${pageContext.request.contextPath}/customers">Quay lại danh sách</a>
    <a href="${pageContext.request.contextPath}/customers?action=edit&id=${customer.id}">Sửa khách hàng</a>
</p>
</body>
</html>