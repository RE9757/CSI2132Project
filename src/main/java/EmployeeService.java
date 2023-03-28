import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public List<Employee> getEmployees() throws Exception {

        // sql query
        String sql = "SELECT * FROM Employee";
        // database connection object
        ConnectionDB db = new ConnectionDB();

        // data structure to keep all grades retrieved from database
        List<Employee> employees = new ArrayList<>();

        // try connect to database, catch any exceptions
        try (Connection con = db.getConnection()) {
            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // get the results from executing the query
            ResultSet rs = stmt.executeQuery();


            // iterate through the result set
            while (rs.next()) {
                // create new grade object
                Employee employee = new Employee(
                        rs.getInt("SSNSIN"),
                        rs.getInt("Hotel_ID"),
                        rs.getInt("RoomNumber"),
                        rs.getString("Address"),
                        rs.getString("FullName"),
                        rs.getString("Role")
                );

                // append grade in grades list
                employees.add(employee);
            }

            //close the result set
            rs.close();
            // close the statement
            stmt.close();
            con.close();
            db.close();

            // return the grades retrieved from database
            return employees;
        } catch (Exception e) {
            // throw any errors occurred
            throw new Exception(e.getMessage());
        }
    }

    public String deleteEmployee(Integer SSNSIN) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM Employee WHERE SSNSIN = ?;";

        // database connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            con = db.getConnection();

            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setInt(1, SSNSIN);

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while delete Employee: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Employee successfully deleted!";
        }

        return message;
    }


    public String createEmployee(Employee employee) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(employee.getSINSSN());
        System.out.println(employee.getHotel_ID());
        System.out.println(employee.getRoomNumber());
        System.out.println(employee.getAddress());
        System.out.println(employee.getFullName());
        System.out.println(employee.getRole());


        String insertEmployeeQuery = "INSERT INTO Employee (SINSSN, Hotel_ID, RoomNumber, Address, FullName, Role) VALUES (?, ?, ?, ?, ?, ?);";


        try {
            con = db.getConnection(); //get Connection

            // prepare the statement
            PreparedStatement stmt = con.prepareStatement(insertEmployeeQuery);

            // set every ? of statement
            stmt.setInt(1, employee.getSINSSN());
            stmt.setInt(2, employee.getHotel_ID());
            stmt.setInt(3, employee.getRoomNumber());
            stmt.setString(4, employee.getAddress());
            stmt.setString(5, employee.getFullName());
            stmt.setString(6, employee.getRole());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();

            db.close();
        } catch (Exception e) {
            message = "Error while inserting employee: " + e.getMessage();
        } finally {
            if (con != null) // if connection is still open, then close.
                con.close();
            if (message.equals("")) message = "Employee successfully inserted!";

        }

        // return respective message
        return message;
    }


    public String updateEmployee(Employee employee) throws Exception {
        Connection con = null;
        String message = "";


        String sql = "UPDATE employee SET Hotel_ID=?, RoomNumber=?, Address =?, FullName =?, Role =? WHERE SINSSN=?;";


        ConnectionDB db = new ConnectionDB();

        try {

            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setInt(1, employee.getSINSSN());//?
            stmt.setInt(2, employee.getHotel_ID());
            stmt.setInt(3, employee.getRoomNumber());
            stmt.setString(4, employee.getAddress());
            stmt.setString(5, employee.getFullName());
            stmt.setString(6, employee.getRole());


            stmt.executeUpdate();

            stmt.close();

        } catch (Exception e) {
            message = "Error while updating employee: " + e.getMessage();

        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Customer successfully updated!";
        }


        return message;
    }
}
