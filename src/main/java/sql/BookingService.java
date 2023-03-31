package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**This function is used to send queries to sql to get, delete, update, and insert entity*/
public class BookingService {


        public List<Booking> getBookings() throws Exception {

            // sql query
            String sql = "SELECT * FROM CSI2132Project.Booking";
            ConnectionDB db = new ConnectionDB();


            List<Booking> bookings = new ArrayList<>();


            try (Connection con = db.getConnection()) {

                PreparedStatement stmt = con.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();//"SELECT * FROM CSI2132Project.Booking"

                while (rs.next()) {

                    Booking booking = new Booking(
                            rs.getInt("Booking_ID"),
                            rs.getInt("SINSSN"),
                            rs.getInt("RoomNumber"),
                            rs.getDate("Start_Date"),
                            rs.getDate("End_Date")
                    );


                    bookings.add(booking);
                }


                rs.close();
                stmt.close();
                con.close();
                db.close();


                return bookings;
            } catch (Exception e) {

                throw new Exception(e.getMessage());
            }
        }

        public String deleteBooking(Integer BookingID) throws Exception {
            Connection con = null;
            String message = "";


            String sql = "DELETE FROM Booking WHERE BookingID = ?;";


            ConnectionDB db = new ConnectionDB();


            try {
                con = db.getConnection();

                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setInt(1, BookingID);

                stmt.executeUpdate();

                stmt.close();

            } catch (Exception e) {
                message = "Error while delete sql.Booking: " + e.getMessage();
            } finally {
                if (con != null) con.close();
                if (message.equals("")) message = "sql.Booking successfully deleted!";
            }

            return message;
        }

        public String createBooking(Booking booking) throws Exception {
            String message = "";
            Connection con = null;

            // connection object
            ConnectionDB db = new ConnectionDB();
            System.out.println(booking.getBookingID());
            System.out.println(booking.getSINSSN());
            System.out.println(booking.getRoomNumber());
            System.out.println(booking.getStart_Date());
            System.out.println(booking.getEnd_Date());


            String insertBookingQuery = "INSERT INTO Booking (BookingID, SINSSN, RoomNumber, Start_Date, End_Date) VALUES (?, ?, ?, ?, ?);";


            try {
                con = db.getConnection(); //get Connection

                // prepare the statement
                PreparedStatement stmt = con.prepareStatement(insertBookingQuery);

                // set every ? of statement
                stmt.setInt(1, booking.getBookingID());
                stmt.setInt(2, booking.getSINSSN());
                stmt.setInt(3, booking.getRoomNumber());
                stmt.setDate(4, booking.getStart_Date());
                stmt.setDate(5, booking.getEnd_Date());

                int output = stmt.executeUpdate();
                System.out.println(output);

                stmt.close();

                db.close();
            } catch (Exception e) {
                message = "Error while inserting booking: " + e.getMessage();
            } finally {
                if (con != null) // if connection is still open, then close.
                    con.close();
                if (message.equals("")) message = "sql.Booking successfully inserted!";

            }

            // return respective message
            return message;
        }


        public String updateBooking(Booking booking) throws Exception {
            Connection con = null;
            String message = "";


            String sql = "UPDATE booking SET SINSSN=?, RoomNumber = ?, Start_Date =?, End_Date = ? WHERE BookingID=?;";


            ConnectionDB db = new ConnectionDB();

            try {

                con = db.getConnection();

                PreparedStatement stmt = con.prepareStatement(sql);


                stmt.setInt(1, booking.getBookingID());
                stmt.setInt(2, booking.getSINSSN());
                stmt.setInt(3, booking.getRoomNumber());
                stmt.setDate(4, booking.getStart_Date());
                stmt.setDate(5, booking.getEnd_Date());


                stmt.executeUpdate();

                stmt.close();

            } catch (Exception e) {
                message = "Error while updating booking: " + e.getMessage();

            } finally {
                if (con != null) con.close();
                if (message.equals("")) message = "sql.Booking successfully updated!";
            }


            return message;
        }


}
