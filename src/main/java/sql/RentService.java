package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class RentService {

    public List<Rent> getRents() throws Exception {

        // sql query
        String sql = "SELECT * FROM Rent";
        ConnectionDB db = new ConnectionDB();


        List<Rent> rents = new ArrayList<>();


        try (Connection con = db.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();//"SELECT * FROM CSI2132Project.Rent"

            while (rs.next()) {

                Rent rent = new Rent(
                        rs.getInt("SINSSN"),
                        rs.getInt("RoomNumber"),
                        rs.getDate("Start_Date"),
                        rs.getDate("End_Date"),
                        rs.getInt("Rent_ID")
                );


                rents.add(rent);
            }


            rs.close();
            stmt.close();
            con.close();
            db.close();


            return rents;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public String deleteRent(Integer Rent_ID) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "DELETE FROM Rent WHERE Rent_ID = ?;";


        ConnectionDB db = new ConnectionDB();


        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, Rent_ID);

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while delete rent: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "rent successfully deleted!";
        }

        return message;
    }

    public String createRent(Rent rent) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();

        System.out.println(rent.getSINSSN());
        System.out.println(rent.getRoomNumber());
        System.out.println(rent.getStart_Date());
        System.out.println(rent.getEnd_Date());
        System.out.println(rent.getRent_ID());


        String insertRentQuery = "INSERT INTO rent (SINSSN,RoomNumber,Start_Date,End_Date,Rent_ID) VALUES (?, ?, ?, ?, ?);";


        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertRentQuery);

            // set every ? of statement
            stmt.setInt(1, rent.getSINSSN());
            stmt.setInt(2, rent.getRoomNumber());
            stmt.setDate(3, rent.getStart_Date());
            stmt.setDate(4, rent.getEnd_Date());
            stmt.setInt(5, rent.getRent_ID());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();

            db.close();
        } catch (Exception e) {
            message = "Error while inserting rent: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Rent successfully inserted!";

        }

        // return respective message
        return message;
    }


    public String updateRent(Rent rent) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "UPDATE rent SET SINSSN,RoomNumber,Start_Date,End_Date WHERE Rent_ID=?;";


        ConnectionDB db = new ConnectionDB();

        try {

            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);



            stmt.setInt(1, rent.getSINSSN());
            stmt.setInt(2, rent.getRoomNumber());
            stmt.setDate(3, rent.getStart_Date());
            stmt.setDate(4, rent.getEnd_Date());
            stmt.setInt(5, rent.getRent_ID());


            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while updating rent: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "rent successfully updated!";
        }


        return message;
    }
}
