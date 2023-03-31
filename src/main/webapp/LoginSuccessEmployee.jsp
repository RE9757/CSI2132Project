<%@ page import="sql.Room" %>
<%@ page import="sql.RoomService" %>
<%@ page import="sql.Rent" %>
<%@ page import="sql.RentService" %>
<%@ page import="sql.ConnectionDB" %>
<%@ page import="java.util.List" %>
<%@ page import="jsp.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    // retrieve grades from database
    RoomService roomService = new RoomService();
    List<Room> rooms = null;
    try {
        rooms = roomService.getRooms();
    } catch (Exception e) {
        e.printStackTrace();
    }



    RentService rentService = new RentService();
    List<Rent> rents = null;
    try {
        rents = rentService.getRents();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title> Browse Room Page </title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
</head>

<body>

    <jsp:include page="navbar.jsp"/>

    <h2>My Account Information:</h2>

    <input type="hidden" name="message" id="message" value='<%=msgField%>' >
    <div class="container">
        <div class="row" id="row">
            <div class="col-md-12">
                <div class="card" id="card-container">
                    <div class="card-body" id="card">
                        <% if (rooms == null || rooms.size() == 0) { %>
                        <h1 style="margin-top: 5rem;">No Rooms found!</h1>
                        <% } else { %>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>RoomNumber</th>
                                    <th>Address</th>
                                    <th>Hotel_ID</th>
                                    <th>Problem</th>
                                    <th>Price</th>
                                    <th>Amenities</th>
                                    <th>Capacity</th>
                                    <th>Extendability</th>
                                    <th>View</th>
                                    <th>Status</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                for (Room room : rooms) { %>
                                <tr>
                                    <td><%= room.getRoomNumber() %></td>
                                    <td><%= room.getAddress() %></td>
                                    <td><%= room.getHotel_ID() %></td>
                                    <td><%= room.getProblem() %></td>
                                    <td><%= room.getPrice() %></td>
                                    <td><%= room.getAmenities() %></td>
                                    <td><%= room.getCapacity() %></td>
                                    <td><%= room.getExtendability() %></td>
                                    <td><%= room.getView() %></td>
                                    <td><%= room.getStatus() %></td>
                                </tr>
                                <% } %>
                                </tbody>
                            </table>
                        </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>


    <input type="hidden" name="message" id="message" value='<%=msgField%>' >
        <div class="container">
            <div class="row" id="row">
                <div class="col-md-12">
                    <div class="card" id="card-container">
                       <% if (rents == null || rents.size() == 0) { %>
                           <h1 style="margin-top: 5rem;">No Rents found!</h1>
                               <% } else { %>
                                   <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                            <tr>
                                            <th>SINSSN</th>
                                            <th>RoomNumber</th>
                                            <th>Start_Date</th>
                                            <th>End_Date</th>
                                            <th>Rent_ID</th>
                                            <th></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                             <% for (Rent rent : rents) { %>
                                             <tr>
                                            <td><%= rent.getSINSSN() %></td>
                                            <td><%= rent.getRoomNumber() %></td>
                                            <td><%= rent.getStart_Date() %></td>
                                            <td><%= rent.getEnd_Date() %></td>
                                            <td><%= rent.getRent_ID() %></td>
                                            <td></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    <% } %>
    </div>
    </div>
    </div>
  </div>

  <h2>Change Room Status button(update rooms, rent):</h2>



    <script src="/assets/js/jquery.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
</body>

</html>