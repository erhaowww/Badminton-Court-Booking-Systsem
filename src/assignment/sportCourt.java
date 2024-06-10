package assignment;

import assignment.datatype.*;

enum SportCourtStatus{
    Available,
    Reserved
}

public class sportCourt {
    final protected String name = "badminton";
    final private static double CHARGE = 30;
    private String courtCode;
    private int timeInHour;
    private int timeOutHour;
    Address location;
    private SportCourtStatus status;
    public static int no=0;
    private Date date;

    //non-arg constructor
    public sportCourt(){}

    public double getCharge() {
        return CHARGE;
    }
    public SportCourtStatus getStatus() {
        return status;
    }
    public String getCourtCode() {
        return courtCode;
    }
    public void setStatus(SportCourtStatus status) {
        this.status = status;
    }

    public sportCourt(String courtCode,Address location,SportCourtStatus status,int timeInHour,int timeOutHour,Date date){
        this.courtCode=courtCode;
        this.location=location;
        this.status=status;
        this.timeInHour=timeInHour;
        this.timeOutHour=timeOutHour;
        this.date=date;
    }
    public Date getDate() {
        return date;
    }
    public int getTimeOutHour() {
        return timeOutHour;
    }
    public int getTimeInHour() {
        return timeInHour;
    }

    public String toStringCourt(){
        return  "\nCourt Name:"+name+
                "\nCharge: RM"+CHARGE;
    }

    public String toStringCourtDetailAndTime(){
        return  "\n\n\nDate:"+date.toString()+
                "\nCourt Name:"+name+
                "\nCourt Code:"+courtCode+
                "\nStreet Address:"+location.getStreetAddress()+
                "\nCity:"+location.getCity()+
                "\nPostcode:"+location.getPostCode()+
                "\nState:"+location.getState()+
                "\nTime Table"+
                "\n+---------+---------+---------+---------+---------+"+
                "\n|  10-12  |  12-14  |  14-16  |  16-18  |  18-20  |"+
                "\n+---------+---------+---------+---------+---------+";


    }
    public String toStringTimeSlot(){
        if(timeOutHour!=20){
            if(this.status==SportCourtStatus.Available){
                return  "|         ";
            }else{
                return  "|/////////";
            }
        }else{
            if(this.status==SportCourtStatus.Available){
                return  "|         |";
            }else{
                return  "|/////////|";
            }
        }

    }
    public String toStringTime(){
        if(this.status==SportCourtStatus.Available){
            no++;
            return "|                         "+no+"."+timeInHour+"-"+timeOutHour+"                         |";
        }else{
            return "";
        }

    }
}
