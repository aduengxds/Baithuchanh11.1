package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Tiếp nhận yêu cầu và điều hướng các chức năng quản lý khách hàng.
 */
@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    private final CustomerService customerService =
            new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null || action.isBlank()) {
            listCustomers(request, response);
            return;
        }

        switch (action) {
            case "create":
                request.getRequestDispatcher("/customer/create.jsp")
                        .forward(request, response);
                break;

            case "edit":
                showCustomerForm(request, response, "edit");
                break;

            case "delete":
                showCustomerForm(request, response, "delete");
                break;

            case "view":
                showCustomerForm(request, response, "view");
                break;

            default:
                listCustomers(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        switch (action) {
            case "create":
                createCustomer(request, response);
                break;

            case "edit":
                updateCustomer(request, response);
                break;

            case "delete":
                deleteCustomer(request, response);
                break;

            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void listCustomers(HttpServletRequest request,
                               HttpServletResponse response)
            throws ServletException, IOException {

        List<Customer> customers = customerService.findAll();
        request.setAttribute("customers", customers);

        request.getRequestDispatcher("/customer/list.jsp")
                .forward(request, response);
    }

    private void showCustomerForm(HttpServletRequest request,
                                  HttpServletResponse response,
                                  String action)
            throws ServletException, IOException {

        Customer customer = getCustomer(request);

        if (customer == null) {
            showNotFound(request, response);
            return;
        }

        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/customer/" + action + ".jsp")
                .forward(request, response);
    }

    private Customer getCustomer(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            return customerService.findById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void createCustomer(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        if (isBlank(name) || isBlank(email) || isBlank(address)) {
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("/customer/create.jsp")
                    .forward(request, response);
            return;
        }

        Customer customer = new Customer(
                0, name.trim(), email.trim(), address.trim());

        customerService.save(customer);

        response.sendRedirect(request.getContextPath() + "/customers");
    }

    private void updateCustomer(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        Customer existing = getCustomer(request);

        if (existing == null) {
            showNotFound(request, response);
            return;
        }

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        if (isBlank(name) || isBlank(email) || isBlank(address)) {
            request.setAttribute("customer", existing);
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin.");
            request.getRequestDispatcher("/customer/edit.jsp")
                    .forward(request, response);
            return;
        }

        Customer updated = new Customer(
                existing.getId(), name.trim(), email.trim(), address.trim());

        customerService.update(existing.getId(), updated);

        response.sendRedirect(request.getContextPath() + "/customers");
    }

    private void deleteCustomer(HttpServletRequest request,
                                HttpServletResponse response)
            throws ServletException, IOException {

        Customer customer = getCustomer(request);

        if (customer == null) {
            showNotFound(request, response);
            return;
        }

        customerService.remove(customer.getId());

        response.sendRedirect(request.getContextPath() + "/customers");
    }

    private void showNotFound(HttpServletRequest request,
                              HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        request.getRequestDispatcher("/error-404.jsp")
                .forward(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}