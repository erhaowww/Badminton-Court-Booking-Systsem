package assignment;

import assignment.datatype.Date;
enum ReservationStatus{
    Pending,
    Completed,
    Cancelled
}

public class Booking {
    private Date bookingDate;
    private Date reservationDate;
    private String courtCode;
    private String courtName;
    private int timeInHour;
    private int timeOutHour;
    private String user_id;
    private double charge;
    private ReservationStatus status;

    public Booking(){}
    public Booking(Date bookingDate,Date reservationDate,String user_id, String courtCode,String courtName,int timeInHour,int timeOutHour,double charge,ReservationStatus status){
        this.bookingDate=bookingDate;
        this.reservationDate=reservationDate;
        this.user_id=user_id;
        this.courtCode=courtCode;
        this.courtName = courtName;
        this.timeInHour=timeInHour;
        this.timeOutHour=timeOutHour;
        this.charge = charge;
        this.status = status;
    }
    public String getUser_id() {
        return user_id;
    }
    public Date getReservationDate() {
        return reservationDate;
    }
    public double getCharge(){return charge;}
    public String getCourtCode() {
        return courtCode;
    }
    public int getTimeInHour() {
        return timeInHour;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    
    public String toString(){
        return  "\nDate:"+bookingDate.toString()+
                "\nReservation Date:"+reservationDate.toString()+
                "\nCustomer ID: "+user_id+
                "\nCourt Code: "+courtCode+
                "\nCourt Name: "+courtName+
                "\nTime In: "+timeInHour+
                "\nTime Out: "+timeOutHour+
                String.format("\nCharge: RM%.2f\n", charge);

    }
    public String toStringList(){
        if(status==ReservationStatus.Pending){
            return "|  "+reservationDate.toString()+"  |      "+courtCode+"      |    "+timeInHour+"00   |    "+(timeOutHour)+"00    |";
        }else{
            return "|  "+reservationDate.toString()+"  |      "+courtCode+"      |    "+timeInHour+"00   |    "+(timeOutHour)+"00    |";
        }
    }
    public String toStringListStatus(){
        if(status==ReservationStatus.Pending){
            return "|  "+reservationDate.toString()+"  |      "+courtCode+"      |    "+timeInHour+"00   |    "+(timeOutHour)+"00    |      "+status+"       |";
        }else{
            return "|  "+reservationDate.toString()+"  |      "+courtCode+"      |    "+timeInHour+"00   |    "+(timeOutHour)+"00    |     "+status+"      |";
        }
    }

    public String toStringBookingList(){
        if(status==ReservationStatus.Pending){
            return "|   "+bookingDate+"   |    "+reservationDate.toString()+"    |      "+courtCode+"      |    "+timeInHour+"00   |    "+(timeOutHour)+"00    |      "+status+"       |";
        }else{
            return "|   "+bookingDate+"   |    "+reservationDate.toString()+"    |      "+courtCode+"      |    "+timeInHour+"00   |    "+(timeOutHour)+"00    |     "+status+"      |";    }
        }

    public String toStringBookedCourt(){
        return String.format(" %6s %7s %10d %9s %10d %15s RM %.2f",courtCode,"",timeInHour,"",timeOutHour,"",charge);
    }
}

