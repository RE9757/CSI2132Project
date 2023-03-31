package sql;

import java.sql.Date;

public class Booking {

    private Integer BookingID;

    private Integer SINSSN;

    private Integer RoomNumber;

    private Date Start_Date;

    private Date End_Date;

    public Booking(Integer BookingID, Integer SINSSN, Integer RoomNumber,
                   Date Start_Date, Date End_Date){
        this.BookingID = BookingID;
        this.SINSSN = SINSSN;
        this.RoomNumber = RoomNumber;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
    }

    public Integer getBookingID() {
        return BookingID;
    }

    public Integer getSINSSN() {
        return SINSSN;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setBookingID(Integer bookingID) {
        BookingID = bookingID;
    }

    public void setSINSSN(Integer SINSSN) {
        this.SINSSN = SINSSN;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

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
