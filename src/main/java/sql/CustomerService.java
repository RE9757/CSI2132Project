package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<Customer> getCustomers() throws Exception {


        String sql = "SELECT * FROM sql.Customer";

        ConnectionDB db = new ConnectionDB();


        List<Customer> customers = new ArrayList<>();


        try (Connection con = db.getConnection()) {

            PreparedStatement stmt = con.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Customer customer = new Customer(
                        rs.getInt("SSNSIN"),
                        rs.getString("Address"),
                        rs.getString("FullName"),
                        rs.getDate("DateOfRegistration"),
                        rs.getInt("CustomerId")
                );


                customers.add(customer);
            }


            rs.close();
            stmt.close();
            con.close();
            db.close();


            return customers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public String deleteCustomer(Integer CustomerId) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "DELETE FROM sql.Customer WHERE CustomerId = ?;";

        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, CustomerId);

            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while delete sql.Customer: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "sql.Customer successfully deleted!";
        }

        return message;
    }


    public String createCustomer(Customer customer) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();


        System.out.println(customer.getSINSSN());
        System.out.println(customer.getAddress());
        System.out.println(customer.getFullName());
        System.out.println(customer.getDateOfRegistration());
        System.out.println(customer.getCustomerId());


        String insertCustomerQuery = "INSERT INTO sql.Customer (SINSSN, Address, FullName, DateOfRegistration, CustomerId) VALUES (?, ?, ?, ?, ?);";


        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertCustomerQuery);

            // set every ? of statement
            stmt.setInt(1, customer.getSINSSN());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getFullName());
            stmt.setDate(4, customer.getDateOfRegistration());
            stmt.setInt(5, customer.getCustomerId());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();

            db.close();
        } catch (Exception e) {
            message = "Error while inserting customer: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "sql.Customer successfully inserted!";

        }

        // return respective message
        return message;
    }


    public String updateCustomer(Customer customer) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "UPDATE customer SET SINSSN=?, Address=?, FullName =?, DateOfRegistration =? WHERE CustomerId=?;";


        ConnectionDB db = new ConnectionDB();

        try {

            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setInt(1, customer.getSINSSN());//?
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getFullName());
            stmt.setDate(4, customer.getDateOfRegistration());
            stmt.setInt(5, customer.getCustomerId());


            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while updating customer: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "sql.Customer successfully updated!";
        }


        return message;
    }



}
