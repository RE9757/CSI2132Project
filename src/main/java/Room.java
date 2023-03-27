import javax.swing.text.View;

public class Room {

    private Integer RoomNumber;

    private String Address;

    private Integer Hotel_ID;

    private String Problem;

    private Integer Price;

    private String Amenities;

    private String Capacity;

    private String Extendability;

    private String View;

    private String Status;

    public Room(Integer RoomNumber, String Address, Integer Hotel_ID,
                String Problem, Integer Price, String Amenities,
                String Capacity, String Extendability, String View, String Status){
        this.RoomNumber = RoomNumber;
        this.Address = Address;
        this.Hotel_ID = Hotel_ID;
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

    public Integer getHotel_ID() {
        return Hotel_ID;
    }

    public String getProblem() {
        return Problem;
    }

    public Integer getPrice() {
        return Price;
    }

    public String getAmenities() {
        return Amenities;
    }

    public String getCapacity() {
        return Capacity;
    }

    public String getExtendability() {
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

    public void setHotel_ID(Integer hotel_ID) {
        Hotel_ID = hotel_ID;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public void setAmenities(String amenities) {
        Amenities = amenities;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public void setExtendability(String extendability) {
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
                + "<li>Hotel_ID= " + Hotel_ID + "</li>"
                + "<li>Problem= " + Problem + "</li>"
                + "<li>Price= " + Price + "</li>"
                + "<li>Amenities= " + Amenities + "</li>"
                + "<li>Capacity= " + Capacity + "</li>"
                + "<li>Extendability= " + Extendability + "</li>"
                + "<li>View= " + View + "</li>"
                + "<li>Status= " + Status + "</li>";
    }
}
