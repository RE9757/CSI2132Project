package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    public List<Room> getRooms() throws Exception {


        String sql = "SELECT * FROM Room";

        ConnectionDB db = new ConnectionDB();


        List<Room> rooms = new ArrayList<>();


        try (Connection con = db.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();//"SELECT * FROM CSI2132Project.Room"



            while (rs.next()) {

                Room room = new Room(
                        rs.getInt("RoomNumber"),
                        rs.getString("Address"),
                        rs.getInt("Hotel_ID"),
                        rs.getString("Problem"),
                        rs.getInt("Price"),
                        rs.getBoolean("Amenities"),
                        rs.getString("Capacity"),
                        rs.getBoolean("Extendability"),
                        rs.getString("View"),
                        rs.getString("Status")

                );


                rooms.add(room);
            }


            rs.close();
            stmt.close();
            con.close();
            db.close();


            return rooms;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public String deleteRoom(Integer RoomNumber) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "DELETE FROM Room WHERE RoomNumber = ?;";

        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, RoomNumber);

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while delete room: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Room successfully deleted!";
        }

        return message;
    }


    public String createRoom(Room room) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();


        System.out.println(room.getRoomNumber());
        System.out.println(room.getAddress());
        System.out.println(room.getHotel_ID());
        System.out.println(room.getProblem());
        System.out.println(room.getPrice());
        System.out.println(room.getAmenities());
        System.out.println(room.getCapacity());
        System.out.println(room.getExtendability());
        System.out.println(room.getView());
        System.out.println(room.getStatus());


        String insertRoomQuery = "INSERT INTO Room (RoomNumber, Address, Hotel_ID, Problem, Price, Amenities, Capacity, Extendability, View, Status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";


        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertRoomQuery);

            // set every ? of statement
            stmt.setInt(1, room.getRoomNumber());
            stmt.setString(2, room.getAddress());
            stmt.setInt(3, room.getHotel_ID());
            stmt.setString(4, room.getProblem());
            stmt.setInt(5, room.getPrice());
            stmt.setBoolean(6, room.getAmenities());
            stmt.setString(7, room.getCapacity());
            stmt.setBoolean(8, room.getExtendability());
            stmt.setString(9, room.getView());
            stmt.setString(10, room.getStatus());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();

            db.close();
        } catch (Exception e) {
            message = "Error while inserting room: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "sql.Room successfully inserted!";

        }

        // return respective message
        return message;
    }


    public String updateRoom(Room room) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "UPDATE Room SET Address = ?, Hotel_ID = ?, Problem = ?, Price = ?, Amenities = ?, Capacity = ?, Extendability =?," +
                " View = ?, Status = ? WHERE RoomNumber=?;";


        ConnectionDB db = new ConnectionDB();

        try {

            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setInt(1, room.getRoomNumber());//?
            stmt.setString(2, room.getAddress());
            stmt.setInt(3, room.getHotel_ID());
            stmt.setString(4, room.getProblem());
            stmt.setInt(5, room.getPrice());
            stmt.setBoolean(6, room.getAmenities());
            stmt.setString(7, room.getCapacity());
            stmt.setBoolean(8, room.getExtendability());
            stmt.setString(9, room.getView());
            stmt.setString(10, room.getStatus());


            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while updating room: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Room successfully updated!";
        }


        return message;
    }
}




