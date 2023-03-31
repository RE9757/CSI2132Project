package sql;

public class Hotel {

    private String Address;

    private Integer Hotel_ID;

    private String Email;

    private Integer NumberOfRooms;

    private String StarsRating;

    private String PhoneNumber;

    public Hotel(String Address, Integer Hotel_ID, String Email,
                 Integer NumberOfRooms, String StarsRating, String PhoneNumber){
        this.Address = Address;
        this.Hotel_ID = Hotel_ID;
        this.Email = Email;
        this.NumberOfRooms = NumberOfRooms;
        this.StarsRating = StarsRating;
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public Integer getHotel_ID() {
        return Hotel_ID;
    }

    public String getEmail() {
        return Email;
    }

    public Integer getNumberOfRooms() {
        return NumberOfRooms;
    }

    public String getStarsRating() {
        return StarsRating;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setHotel_ID(Integer hotel_ID) {
        Hotel_ID = hotel_ID;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        NumberOfRooms = numberOfRooms;
    }

    public void setStarsRating(String starsRating) {
        StarsRating = starsRating;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {

        return "<ul>"
                + "<li>Address= " + Address + "</li>"
                + "<li>HotelID= " + Hotel_ID + "</li>"
                + "<li>Email= " + Email + "</li>"
                + "<li>NumberOfRooms= " + NumberOfRooms + "</li>"
                + "<li>StarsRating= " + StarsRating + "</li>"
                + "<li>PhoneNumber= " + PhoneNumber + "</li>";
    }
}
