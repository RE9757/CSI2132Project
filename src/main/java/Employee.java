

import java.util.Iterator;

public class Employee {

    private Integer SINSSN;

    private Integer Hotel_ID;

    private Integer RoomNumber;

    private String Address;

    private String FullName;

    private String Role;

    public Employee(Integer SINSSN, Integer Hotel_ID, Integer RoomNumber,
                    String Address, String FullName, String Role){
        this.SINSSN = SINSSN;
        this.Hotel_ID = Hotel_ID;
        this.RoomNumber = RoomNumber;
        this.Address = Address;
        this.FullName = FullName;
        this.Role = Role;
    }

    public Integer getSINSSN() {
        return SINSSN;
    }

    public Integer getHotel_ID() {
        return Hotel_ID;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getFullName() {
        return FullName;
    }

    public String getRole() {
        return Role;
    }

    public void setSINSSN(Integer SINSSN) {
        this.SINSSN = SINSSN;
    }

    public void setHotel_ID(Integer hotel_ID) {
        Hotel_ID = hotel_ID;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>SINSSN= " + SINSSN + "</li>"
                + "<li>Hotel_ID= " + Hotel_ID + "</li>"
                + "<li>RoomNumber= " + RoomNumber + "</li>"
                + "<li>Address= " + Address + "</li>"
                + "<li>FullName= " + FullName + "</li>"
                + "<li>Role= " + Role + "</li>";
    }
}
