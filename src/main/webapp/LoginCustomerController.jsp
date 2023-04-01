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
    int SINSSN = Integer.parseInt(request.getParameter("SINSSN"));
    String FullName = request.getParameter("FullName");

    CustomerService customerService = new CustomerService();

    List<Customer> customers = new ArrayList<>();

    try {
        customers = customerService.getCustomers();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("error" + "Something went wrong!");
    }

    boolean flag = false;

    for (Customer c : customers) {
        if (c.getSINSSN()==(SINSSN) && c.getFullName().equals(FullName)) {//.equals?
            // set session attribute to indicate successful login
            //session.setAttribute("loggedIn", true);

            flag = true;
            break;
        }
    }

    //System.out.println(flag);

    if(flag) {
    // redirect to index
        response.sendRedirect("LoginSuccessCustomer.jsp");
    }
    else{
        // if no matching customer is found, redirect back to login
          response.sendRedirect("login.jsp");
    }


%>
