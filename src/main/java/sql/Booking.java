package sql;

import java.sql.Date;

/**
 * This is the Java class for corresponding sql entity set 'Booking'
 */
public class Booking {

    /**This is the BookingID for booking a room which is a primary key for Booking entity set*/
    private int BookingID;

    /**This is SINSSN which means the SIN/SSN for whom books the room
     * it is an foreign key in booking entity set which reference to Customer(SINSSN)*/
    private int SINSSN;

    /**This is the integer value to indicate the room number booking*/
    private int RoomNumber;

    /**This Date represent the start date of booking*/
    private Date Start_Date;

    /**This Date represent the end date of booking*/
    private Date End_Date;

    /**Constructor is for Booking class initialization
     * @param BookingID
     * @param SINSSN
     * @param RoomNumber
     * @param Start_Date
     * @param End_Date*/
    public Booking(int BookingID, int SINSSN, int RoomNumber,
                   Date Start_Date, Date End_Date){
        this.BookingID = BookingID;
        this.SINSSN = SINSSN;
        this.RoomNumber = RoomNumber;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
    }

    /**A getter for Booking class*/
    public int getBookingID() {
        return BookingID;
    }

    /**A getter for Booking class*/
    public int getSINSSN() {
        return SINSSN;
    }

    /**A getter for Booking class*/
    public int getRoomNumber() {
        return RoomNumber;
    }

    /**A getter for Booking class*/
    public Date getStart_Date() {
        return Start_Date;
    }

    /**A getter for Booking class*/
    public Date getEnd_Date() {
        return End_Date;
    }

    /**A setter for Booking class*/
    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    /**A setter for Booking class*/
    public void setSINSSN(int SINSSN) {
        this.SINSSN = SINSSN;
    }

    /**A setter for Booking class*/
    public void setRoomNumber(int roomNumber) {
        RoomNumber = roomNumber;
    }

    /**A setter for Booking class*/
    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    /**A setter for Booking class*/
    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

    /**A toString function for Booking class*/
    @Override
    public String toString() {
        return "<ul>"
                + "<li>BookingID= " + BookingID + "</li>"
                + "<li>SINSSN= " + SINSSN + "</li>"
                + "<li>RoomNumber= " + RoomNumber + "</li>"
                + "<li>Start_Date= " + Start_Date + "</li>"
                + "<li>End_Date= " + End_Date + "</li>";
    }
}
