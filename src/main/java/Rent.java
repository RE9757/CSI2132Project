import java.util.*;

public class Rent {

    private Integer SINSSN;

    private Integer RoomNumber;

    private Date Start_Date;

    private Date End_Date;

    private Integer Rent_ID;

    public Rent(Integer SINSSN, Integer RoomNumber, Date Start_Date,
                Date End_Date, Integer Rent_ID){
        this.SINSSN = SINSSN;
        this.RoomNumber = RoomNumber;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
        this.Rent_ID = Rent_ID;
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

    public Integer getRent_ID() {
        return Rent_ID;
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

    public void setRent_ID(Integer rent_ID) {
        Rent_ID = rent_ID;
    }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>SINSSN= " + SINSSN + "</li>"
                + "<li>RoomNumber= " + RoomNumber + "</li>"
                + "<li>Start_Date= " + Start_Date + "</li>"
                + "<li>End_Date= " + End_Date + "</li>"
                + "<li>Rent_ID= " + Rent_ID + "</li>";
    }
}
