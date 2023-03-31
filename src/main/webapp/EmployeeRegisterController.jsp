<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="sql.EmployeeService" %>
<%@ page import="sql.Employee" %>
<%@ page import="sql.Room" %>
<%@ page import="sql.ConnectionDB" %>
<%@ page import="jsp.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>


<%
    // get values from the request
    Integer SINSSN = Integer.parseInt(request.getParameter("SINSSN"));
    Integer Hotel_ID = Integer.parseInt(request.getParameter("Hotel_ID"));
    Integer RoomNumber = Integer.parseInt(request.getParameter("RoomNumber"));
    String Address = request.getParameter("Address");
    String FullName = request.getParameter("FullName");
    String Role = request.getParameter("Role");

    EmployeeService employeeService = new EmployeeService();

    // create student object
    Employee employee = new Employee(SINSSN, Hotel_ID, RoomNumber, Address, FullName, Role);

    Message msg;
    // try to create a new employee
    try {

        String value = employeeService.createEmployee(employee);
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
    response.sendRedirect("LoginSuccessEmployee.jsp");
%>