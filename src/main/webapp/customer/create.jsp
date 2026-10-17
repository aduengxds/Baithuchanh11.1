<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm khách hàng</title>
</head>
<body>
<h1>Thêm khách hàng mới</h1>

<c:if test="${not empty error}">
    <p style="color:red"><c:out value="${error}"/></p>
</c:if>

<form action="${pageContext.request.contextPath}/customers?action=create"
      method="post">
    <p>
        <label>Họ tên:</label>
        <input type="text" name="name" required>
    </p>
    <p>
        <label>Email:</label>
        <input type="email" name="email" required>
    </p>
    <p>
        <label>Địa chỉ:</label>
        <input type="text" name="address" required>
    </p>
    <button type="submit">Lưu khách hàng</button>
</form>

<a href="${pageContext.request.contextPath}/customers">Quay lại danh sách</a>
</body>
</html>