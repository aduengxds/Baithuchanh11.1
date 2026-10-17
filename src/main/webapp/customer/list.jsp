<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách khách hàng</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background: #1b2a7a; color: white; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
<h1>Danh sách khách hàng</h1>

<a href="${pageContext.request.contextPath}/customers?action=create">
    Thêm khách hàng mới
</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/customers?action=view&id=${customer.id}">
                    <c:out value="${customer.name}"/>
                </a>
            </td>
            <td><c:out value="${customer.email}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/customers?action=edit&id=${customer.id}">Sửa</a>
                <a href="${pageContext.request.contextPath}/customers?action=delete&id=${customer.id}">Xóa</a>
                <a href="${pageContext.request.contextPath}/customers?action=view&id=${customer.id}">Chi tiết</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>