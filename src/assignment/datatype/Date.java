package assignment.datatype;

public class Date {
    private int year;
    private int month;
    private int day;

    //non-arg constructor
    public Date(){
    }
    public Date(int day,int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public String toString(){
        return String.format("%02d",day)+"/"+String.format("%02d",month)+"/"+year;
    }

}

