<%@ page import="jsp.LayoutService" %>
<%@ page import="jsp.Pair" %>
<%@ page import="jsp.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    ArrayList<Message> messages;

    // get any incoming messages from session attribute named messages
    // if nothing exists then messages is an empty arraylist

     if ((ArrayList<Message>) session.getAttribute("messages") == null) messages = new ArrayList<>();
            // else get that value
        else messages = (ArrayList<Message>) session.getAttribute("messages");

        String msgField = "";

        // create the object in the form of a stringified json
        for (Message m : messages) {
            msgField += "{\"type\":\"" + m.type + "\",\"value\":\"" + m.value.replaceAll("['\"]+", "") + "\"},";
        }


                // empty session messages
                session.setAttribute("messages", new ArrayList<Message>());

                // retrieve best dribbler/shooter details from database
                Pair<String, Integer> bestDribblerDetails = null, bestShooterDetailes = null;
                LayoutService layoutService = new LayoutService();
                try {
                    bestDribblerDetails = layoutService.getBestDribblerDetails();
                    bestShooterDetailes = layoutService.getBestShooterDetails();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>




<html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Login Page </title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
</head>

<body>


    <jsp:include page="navbar.jsp"/>

    <input type="hidden" name="message" id="message" value='<%=msgField%>' >
    <div class="container" id="row-container">
        <div class="row" id="row">
            <div class="col-md-4">
                <div class="card" id="card-container-layout">
                    <div class="card-body" id="card">
                        <h4 class="card-title">Employee</h4>
                        <p class="card-text" id="paragraph">Employee only</p>
                        <a class="btn btn-primary" id="show-btn" href="LoginEmployee.jsp">Click</a>
                    </div>
                </div>
            </div>
            </div>


        <input type="hidden" name="message" id="message" value='<%=msgField%>' >
        <div class="container" id="row-container">
            <div class="row" id="row">
                <div class="col-md-4">
                    <div class="card" id="card-container-layout">
                        <div class="card-body" id="card">
                            <h4 class="card-title">Customer</h4>
                            <p class="card-text" id="paragraph">Customer only</p>
                            <a class="btn btn-primary" id="show-btn" href="LoginCustomer.jsp">Click</a>
                        </div>
                    </div>
                </div>
                </div>

</body>
</html>