# Customer Management

Ứng dụng quản lý khách hàng sử dụng Java JSP/Servlet theo kiến trúc MVC.

## Công nghệ

- Java 17
- Maven
- Jakarta Servlet 6
- JSP 3.1
- JSTL 3
- Apache Tomcat 10.1+

## Chức năng

- Hiển thị danh sách khách hàng
- Thêm khách hàng
- Sửa thông tin khách hàng
- Xóa khách hàng
- Xem chi tiết khách hàng

## Cấu trúc MVC

- Model: Customer
- Service: CustomerService, CustomerServiceImpl
- Controller: CustomerServlet
- View: Các trang JSP trong thư mục customer

## Chạy ứng dụng

```bash
mvn clean package