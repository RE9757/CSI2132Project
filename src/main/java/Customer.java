import java.util.*;

public class Customer {

    private Integer SINSSN;

    private String Address;

    private String FullName;

    private Date DateOfRegistration;

    private Integer CustomerId;

    public Customer(Integer SINSSN, String Address, String FullName, Date DateOfRegistration, Integer CustomerId){
        this.SINSSN = SINSSN;
        this.Address = Address;
        this.FullName = FullName;
        this.DateOfRegistration = DateOfRegistration;
        this.CustomerId = CustomerId;
    }

    public Integer getSINSSN() {
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

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setSINSSN(Integer SINSSN) {
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

    public void setCustomerId(Integer customerId) {
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
