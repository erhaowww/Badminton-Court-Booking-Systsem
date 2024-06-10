package assignment.pay;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

public abstract class PaymentTransaction {
    private LocalTime paymentTime = LocalTime.now();
    private LocalDate paymentDate = LocalDate.now();
    private int paymentID = 1001;
    private String transactionType;
    private String bankName;


    public PaymentTransaction(){}

    public PaymentTransaction(String transactionType, String bankName) {
        this.transactionType = transactionType;
        this.bankName = bankName;
        paymentID++;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getTransactionType(){
        return transactionType;
    }

    public String getBankName(){
        return bankName;
    }


    public String getPaymentDate() {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = paymentDate.format(formatDate);
        return formattedDate;
    }

    public String getPaymentTime() {
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = paymentTime.format(formatTime);
        return formattedTime;
    }

    public void setPaymentID(int paymentID){
        this.paymentID = paymentID;
    }

    public String toString(){
        return  "\n__________________________________________________________________________" +
                "\n__________________________________________________________________________" +
                "\nRECEIPT" +
                "\nPAYMENT ID : " + paymentID +
                "\nDATE       : " + getPaymentDate() +
                "\nTIME       : " + getPaymentTime();

    }

    public abstract void displayDetail();



}
