<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="sql.CustomerService" %>
<%@ page import="sql.Customer" %>
<%@ page import="sql.ConnectionDB" %>
<%@ page import="jsp.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>


<%
    // get values from the request
    Integer SINSSN = Integer.parseInt(request.getParameter("SINSSN"));
    String Address = request.getParameter("Address");
    String FullName = request.getParameter("FullName");

    java.util.Date today = new java.util.Date();
    java.sql.Date sqlToday = new java.sql.Date(today.getTime());

    Integer CustomerId = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;

    CustomerService customerService = new CustomerService();

    // create student object
    Customer customer = new Customer(SINSSN, Address, FullName, sqlToday, CustomerId);

    Message msg;
    // try to create a new student
    try {

        String value = customerService.createCustomer(customer);
        // if the value contains error/Error then this is an error message
        if (value.contains("Error") || value.contains("error")) msg = new Message("error", value);
        // else the student was successfully created
        else msg = new Message("success", value);
    } catch (Exception e) {
        e.printStackTrace();
        msg = new Message("error", "Something went wrong!");
    }

    // create an arraylist of messages and append the new message
    ArrayList<Message> messages = new ArrayList<>();
    messages.add(msg);

    // set session attribute named messages to messages value
    session.setAttribute("messages", messages);
    // redirect to index
    response.sendRedirect("LoginSuccessCustomer.jsp");
%>