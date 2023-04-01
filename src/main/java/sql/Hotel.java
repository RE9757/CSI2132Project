package sql;

public class Hotel {

    private String Address;

    private Integer HotelChain_ID;

    private String Email;

    private Integer NumberOfRooms;

    private String StarsRating;

    private String PhoneNumber;

    private String City;

    public Hotel(String Address, Integer HotelChain_ID, String Email,
                 Integer NumberOfRooms, String StarsRating, String PhoneNumber, String City){
        this.Address = Address;
        this.HotelChain_ID = HotelChain_ID;
        this.Email = Email;
        this.NumberOfRooms = NumberOfRooms;
        this.StarsRating = StarsRating;
        this.PhoneNumber = PhoneNumber;
        this.City = City;
    }

    public String getAddress() {
        return Address;
    }

    public Integer getHotelChain_ID() {
        return HotelChain_ID;
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

    public String getCity(){return City;}

    public void setAddress(String address) {
        Address = address;
    }

    public void setHotelChain_ID(Integer hotelchain_ID) {
        HotelChain_ID = hotelchain_ID;
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

    public void setCity(String city){
        City=city;
    }

    @Override
    public String toString() {

        return "<ul>"
                + "<li>Address= " + Address + "</li>"
                + "<li>HotelID= " + HotelChain_ID + "</li>"
                + "<li>Email= " + Email + "</li>"
                + "<li>NumberOfRooms= " + NumberOfRooms + "</li>"
                + "<li>StarsRating= " + StarsRating + "</li>"
                + "<li>PhoneNumber= " + PhoneNumber + "</li>"
                + "<li>City= " + City + "</li>";
    }
}
