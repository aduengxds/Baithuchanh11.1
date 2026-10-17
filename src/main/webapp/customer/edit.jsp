<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Sửa khách hàng</title>
</head>
<body>
<h1>Cập nhật thông tin khách hàng</h1>

<c:if test="${not empty error}">
    <p style="color:red"><c:out value="${error}"/></p>
</c:if>

<form action="${pageContext.request.contextPath}/customers?action=edit"
      method="post">
    <input type="hidden" name="id" value="${customer.id}">

    <p>
        <label>Họ tên:</label>
        <input type="text" name="name"
               value="<c:out value='${customer.name}'/>" required>
    </p>
    <p>
        <label>Email:</label>
        <input type="email" name="email"
               value="<c:out value='${customer.email}'/>" required>
    </p>
    <p>
        <label>Địa chỉ:</label>
        <input type="text" name="address"
               value="<c:out value='${customer.address}'/>" required>
    </p>

    <button type="submit">Cập nhật</button>
</form>

<a href="${pageContext.request.contextPath}/customers">Quay lại danh sách</a>
</body>
</html>