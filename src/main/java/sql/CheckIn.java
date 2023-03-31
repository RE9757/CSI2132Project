package sql;

import java.sql.Date;

public class CheckIn {

    private Integer SINSSN;

    private Integer RoomNumber;

    private Integer CheckIn_ID;

    private Date Start_Date;

    private Date End_Date;

    public CheckIn(Integer SINSSN, Integer RoomNumber, Integer CheckIn_ID,
                   Date Start_Date, Date End_Date){
        this.SINSSN = SINSSN;
        this.RoomNumber = RoomNumber;
        this.CheckIn_ID = CheckIn_ID;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
    }

    public Integer getSINSSN() {
        return SINSSN;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public Integer getCheckIn_ID() {
        return CheckIn_ID;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setSINSSN(Integer SINSSN) {
        this.SINSSN = SINSSN;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setCheckIn_ID(Integer checkIn_ID) {
        CheckIn_ID = checkIn_ID;
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
                + "<li>SINSSN= " + SINSSN + "</li>"
                + "<li>RoomNumber = " + RoomNumber + "</li>"
                + "<li>CheckIn_ID = " + CheckIn_ID + "</li>"
                + "<li>Start_Date = " + Start_Date + "</li>"
                + "<li>End_Date = " + End_Date + "</li>";
    }
}
