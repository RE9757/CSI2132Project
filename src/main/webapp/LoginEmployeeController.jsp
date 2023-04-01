<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="sql.CustomerService" %>
<%@ page import="sql.Customer" %>
<%@ page import="sql.ConnectionDB" %>
<%@ page import="jsp.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>

<%
    // get values from the request
    Integer SINSSN = Integer.parseInt(request.getParameter("SINSSN"));
    String FullName = request.getParameter("FullName");

    EmployeeService employeeService = new EmployeeService();

    List<Employee> employees = new ArrayList<>();

    try {
        employees = employeeService.getEmployees();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("error" + "Something went wrong!");
    }

    for (Employee e : employees) {
        if (e.getSINSSN()==(SINSSN) && e.getFullName()==(FullName)) {
            // set session attribute to indicate successful login
            session.setAttribute("loggedIn", true);
            // redirect to index
            //response.setAttribute()
            response.sendRedirect("LoginSuccessEmployee.jsp");
            return;
        }
    }

    // if no matching customer is found, redirect back to login
    response.sendRedirect("login.jsp");
%>