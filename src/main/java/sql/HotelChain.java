package sql;

public class HotelChain {

    private Integer Hotel_ID;

    private String email;

    private String PhoneNumber;

    private Integer NumberOfHotels;

    private String AddressOfCentralOffice;

    private String name;

    public HotelChain(Integer Hotel_ID, String email, String PhoneNumber,
                      Integer NumberOfHotels, String AddressOfCentralOffice, String name){
        this.Hotel_ID = Hotel_ID;
        this.email = email;
        this.PhoneNumber = PhoneNumber;
        this.NumberOfHotels = NumberOfHotels;
        this.AddressOfCentralOffice = AddressOfCentralOffice;
        this.name = name;
    }

    public Integer getHotel_ID() {
        return Hotel_ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Integer getNumberOfHotels() {
        return NumberOfHotels;
    }
    public String getAddressOfCentralOffice() {
        return AddressOfCentralOffice;
    }

    public String getName() {
        return name;
    }

    public void setHotel_ID(Integer hotel_ID) {
        Hotel_ID = hotel_ID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setNumberOfHotels(Integer numberOfHotels) {
        NumberOfHotels = numberOfHotels;
    }

    public void setAddressOfCentralOffice(String addressOfCentralOffice) {
        AddressOfCentralOffice = addressOfCentralOffice;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "<ul>"
                + "<li>Hotel_ID= " + Hotel_ID + "</li>"
                + "<li>email= " + email + "</li>"
                + "<li>PhoneNumber= " + PhoneNumber + "</li>"
                + "<li>NumberOfHotels= " + NumberOfHotels + "</li>"
                + "<li>AddressOfCentralOffice= " + AddressOfCentralOffice + "</li>"
                + "<li>name= " + name + "</li>";
    }

}
