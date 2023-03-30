import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelChainService {

    public List<HotelChain> getHotelChain() throws Exception {

        // sql query
        String sql = "SELECT * FROM HotelChain";
        ConnectionDB db = new ConnectionDB();


        List<HotelChain> HotelChains = new ArrayList<>();


        try (Connection con = db.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                HotelChain HotelChain = new HotelChain(
                        rs.getInt("Hotel_ID"),
                        rs.getString("email"),
                        rs.getString("PhoneNumber"),
                        rs.getInt("NumberOfHotels"),
                        rs.getString("AddressOfCentralOffice"),
                        rs.getString("name")
                );


                HotelChains.add(HotelChain);
            }


            rs.close();
            stmt.close();
            con.close();
            db.close();


            return HotelChains;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public String deleteHotelChain(Integer Hotel_ID) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "DELETE FROM HotelChain WHERE Hotel_ID = ?;";


        ConnectionDB db = new ConnectionDB();


        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, Hotel_ID);

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while delete HotelChain: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "HotelChain successfully deleted!";
        }

        return message;
    }

    public String createHotelChain(HotelChain hotelChain) throws Exception {
        String message = "";
        Connection con = null;

        // connection object
        ConnectionDB db = new ConnectionDB();
        System.out.println(hotelChain.getHotel_ID());
        System.out.println(hotelChain.getEmail());
        System.out.println(hotelChain.getPhoneNumber());
        System.out.println(hotelChain.getNumberOfHotels());
        System.out.println(hotelChain.getAddressOfCentralOffice());
        System.out.println(hotelChain.getName());


        String insertHotelChainQuery = "INSERT INTO HotelChain (Hotel_ID,Email,PhoneNumber,NumberOfHotels,AddressOfCentralOffice,Name) VALUES (?, ?, ?, ?, ?, ?);";


        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertHotelChainQuery);

            // set every ? of statement
            stmt.setInt(1, hotelChain.getHotel_ID());
            stmt.setString(2, hotelChain.getEmail());
            stmt.setString(3, hotelChain.getPhoneNumber());
            stmt.setInt(4, hotelChain.getNumberOfHotels());
            stmt.setString(5, hotelChain.getAddressOfCentralOffice());
            stmt.setString(5, hotelChain.getName());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();

            db.close();
        } catch (Exception e) {
            message = "Error while inserting HotelChain: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "HotelChain successfully inserted!";

        }

        // return respective message
        return message;
    }


    public String updateHotelChain(HotelChain hotelChain) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "UPDATE HotelChain SET Email=?,PhoneNumber=?,NumberOfHotels=?,AddressOfCentralOffice=?,Name=? WHERE Hotel_ID=?;";


        ConnectionDB db = new ConnectionDB();

        try {

            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setInt(1, hotelChain.getHotel_ID());
            stmt.setString(2, hotelChain.getEmail());
            stmt.setString(3, hotelChain.getPhoneNumber());
            stmt.setInt(4, hotelChain.getNumberOfHotels());
            stmt.setString(5, hotelChain.getAddressOfCentralOffice());
            stmt.setString(5, hotelChain.getName());


            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while updating HotelChain: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "HotelChain successfully updated!";
        }


        return message;
    }
}
