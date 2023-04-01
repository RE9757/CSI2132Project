package sql;

import javax.swing.text.View;

public class Room {

    private Integer RoomNumber;

    private String Address;

    private Integer HotelChain_ID;

    private String Problem;

    private Integer Price;

    private Boolean Amenities;

    private String Capacity;

    private Boolean Extendability;

    private String View;

    private String Status;

    public Room(Integer RoomNumber, String Address, Integer HotelChain_ID,
                String Problem, Integer Price, Boolean Amenities,
                String Capacity, Boolean Extendability, String View, String Status){
        this.RoomNumber = RoomNumber;
        this.Address = Address;
        this.HotelChain_ID = HotelChain_ID;
        this.Problem = Problem;
        this.Price = Price;
        this.Amenities = Amenities;
        this.Capacity = Capacity;
        this.Extendability = Extendability;
        this.View = View;
        this.Status = Status;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public String getAddress() {
        return Address;
    }

    public Integer getHotelChain_ID() {
        return HotelChain_ID;
    }

    public String getProblem() {
        return Problem;
    }

    public Integer getPrice() {
        return Price;
    }

    public Boolean getAmenities() {
        return Amenities;
    }

    public String getCapacity() {
        return Capacity;
    }

    public Boolean getExtendability() {
        return Extendability;
    }

    public String getView() {
        return View;
    }

    public String getStatus() {
        return Status;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setHotelChain_ID(Integer hotelChain_ID) {
        HotelChain_ID = hotelChain_ID;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public void setAmenities(Boolean amenities) {
        Amenities = amenities;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public void setExtendability(Boolean extendability) {
        Extendability = extendability;
    }

    public void setView(String view) {
        View = view;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>RoomNumber= " + RoomNumber + "</li>"
                + "<li>Address= " + Address + "</li>"
                + "<li>Hotel_ID= " + HotelChain_ID + "</li>"
                + "<li>Problem= " + Problem + "</li>"
                + "<li>Price= " + Price + "</li>"
                + "<li>Amenities= " + Amenities + "</li>"
                + "<li>Capacity= " + Capacity + "</li>"
                + "<li>Extendability= " + Extendability + "</li>"
                + "<li>View= " + View + "</li>"
                + "<li>Status= " + Status + "</li>";
    }
}
