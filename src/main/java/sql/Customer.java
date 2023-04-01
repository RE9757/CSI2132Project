package sql;

import java.util.*;
import java.sql.Date;

public class Customer {

    private int SINSSN;

    private String Address;

    private String FullName;

    private Date DateOfRegistration;

    private int CustomerId;

    public Customer(int SINSSN, String Address, String FullName, Date DateOfRegistration, int CustomerId){
        this.SINSSN = SINSSN;
        this.Address = Address;
        this.FullName = FullName;
        this.DateOfRegistration = DateOfRegistration;
        this.CustomerId = CustomerId;
    }

    public int getSINSSN() {
        return SINSSN;
    }

    public String getAddress() {
        return Address;
    }

    public String getFullName() {
        return FullName;
    }

    public Date getDateOfRegistration() {
        return DateOfRegistration;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setSINSSN(int SINSSN) {
        this.SINSSN = SINSSN;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        DateOfRegistration = dateOfRegistration;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>SINSSN= " + SINSSN + "</li>"
                + "<li>Address= " + Address + "</li>"
                + "<li>FullName= " + FullName + "</li>"
                + "<li>DateOfRegistration= " + DateOfRegistration + "</li>"
                + "<li>CustomerId= " + CustomerId + "</li>";
    }
}
