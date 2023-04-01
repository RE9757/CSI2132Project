package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    public List<Hotel> getHotels() throws Exception {

        // sql query
        String sql = "SELECT * FROM Hotel";
        ConnectionDB db = new ConnectionDB();


        List<Hotel> hotels = new ArrayList<>();


        try (Connection con = db.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();//"SELECT * FROM CSI2132Project.Hotel"

            while (rs.next()) {

                Hotel hotel = new Hotel(
                        rs.getString("Address"),
                        rs.getInt("Hotel_ID"),
                        rs.getString("Email"),
                        rs.getInt("NumberOfRooms"),
                        rs.getString("StarsRating"),
                        rs.getString("PhoneNumber")
                );


                hotels.add(hotel);
            }


            rs.close();
            stmt.close();
            con.close();
            db.close();


            return hotels;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public String deleteHotel(Integer Hotel_ID) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "DELETE FROM Hotel WHERE Hotel_ID = ?;";


        ConnectionDB db = new ConnectionDB();


        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, Hotel_ID);

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while delete Hotel: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Hotel successfully deleted!";
        }

        return message;
    }

    public String createHotel(Hotel hotel) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(hotel.getAddress());
        System.out.println(hotel.getHotel_ID());
        System.out.println(hotel.getEmail());
        System.out.println(hotel.getNumberOfRooms());
        System.out.println(hotel.getStarsRating());
        System.out.println(hotel.getPhoneNumber());


        String insertHotelQuery = "INSERT INTO Hotel (Address, Hotel_ID, Email, NumberOfRooms, StarsRating, PhoneNumber) VALUES (?, ?, ?, ?, ?, ?);";


        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertHotelQuery);

            // set every ? of statement
            stmt.setString(1, hotel.getAddress());
            stmt.setInt(2, hotel.getHotel_ID());
            stmt.setString(3, hotel.getEmail());
            stmt.setInt(4, hotel.getNumberOfRooms());
            stmt.setString(5, hotel.getStarsRating());
            stmt.setString(6, hotel.getPhoneNumber());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();

            db.close();
        } catch (Exception e) {
            message = "Error while inserting hotel: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Hotel successfully inserted!";

        }

        // return respective message
        return message;
    }


    public String updateHotel(Hotel hotel) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "UPDATE hotel SET Address=?, Email=?, NumberOfRooms =?, StarsRating =?, PhoneNumber =? WHERE Hotel_ID=?;";


        ConnectionDB db = new ConnectionDB();

        try {

            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1, hotel.getAddress());
            stmt.setInt(2, hotel.getHotel_ID());//?
            stmt.setString(3, hotel.getEmail());
            stmt.setInt(4, hotel.getNumberOfRooms());
            stmt.setString(5, hotel.getStarsRating());
            stmt.setString(6, hotel.getPhoneNumber());


            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while updating hotel: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "sql.Hotel successfully updated!";
        }


        return message;
    }

}
