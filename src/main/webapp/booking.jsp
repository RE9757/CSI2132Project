<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Booking</title>
    <link rel="stylesheet" href="booking.css">   
</head>

<body>
    <div class="container">
        <h1>Hotel Booking</h1>

        <form id="booking-form" action="BookingServlet">
            <label for="sdate">Start Date:</label>
            <input type="date" id="sdate" name="sdate">
            
            <label for="edate">End Date:</label>
            <input type="date" id="edate" name="edate">
            
            <label for="rcap">Room Capacity:</label>
            <select id="rcap" name="rcap">
                <option value="">Select Capacity</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            
            <label for="area">Area:</label>
            <input type="text" id="area" name="area" placeholder="Enter the City you wish to stay">
            
            <label for="hotel-chain">Hotel Chain:</label>
            <select id="hotel-chain" name="hotel-chain">
                <option value="">Select hotel chain</option>
                <option value="1">first hotel </option>
                <option value="2">golden hotel</option>
                <option value="3">Moon hotel</option>
                <option value="4">Western hotel</option>
                <option value="5">Happy hotel</option>
            </select>
            
            <label for="hotel-category">Hotel Category:</label>

            <select id="hotel-category" name="hotel-category">
                <option value="">Select Category</option>
                <option value="1">1 Star</option>
                <option value="2">2 Stars</option>
                <option value="3">3 Stars</option>
                <option value="4">4 Stars</option>
                <option value="5">5 Stars</option>
            </select>
            
            <label for="total-rooms">Total Number of Rooms:</label>
            <input type="number" id="total-rooms" name="total-rooms" placeholder="Enter Total Number of Rooms">
            
            <label for="room-price">Price of Room:</label>
            <input type="number" id="min-room-price" name="min-room-price" placeholder="Enter the minimum Room Price expected">
            <input type="number" id="max-room-price" name="max-room-price" placeholder="Enter the maxmum Room Price expected">
            
            <button type="submit">Submit</button>
        </form>

        <h2>Results</h2>
        <table id="results-table">
            <thead>
                <tr>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Room Capacity</th>
                    <th>Area</th>
                    <th>Hotel Chain</th>
                    <th>Hotel Category</th>
                    <th>Total Rooms</th>
                    <th>Room Price</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Results will be populated here by JavaScript -->
            </tbody>
        </table>
    </div>

    <script src="booking.js"></script>
</body>
</html>