package assignment;

import assignment.pay.PaymentTransaction;


public class Payment {
    private int totalCourtBooked = 0;
    private Booking[] courtBooked = new Booking[15];

    private Beverage[] beverageOrdered = new Beverage[10];
    private int totalBeverageOrder = 0;

    private double amount = 0;
    private static double TAX = 0.05;
    private double DISCOUNT = 0; //later see the membership to change discount
    private PaymentTransaction transaction;

    public Payment(){}

    public Payment(Booking[] courtBooked, Beverage[] beverageOrdered, int totalBeverageOrder, int totalCourtBooked, double amount, double discount){
        this.courtBooked = courtBooked;
        this.beverageOrdered = beverageOrdered;
        this.totalBeverageOrder = totalBeverageOrder;
        this.totalCourtBooked = totalCourtBooked;
        this.amount = amount;
        DISCOUNT = discount;

    }

    ///////////////////////   BOOKED COURT   /////////////////////////////////
    public void addCourtBooked(Booking courtBooking){
        amount += courtBooking.getCharge();
        courtBooked[totalCourtBooked++] = courtBooking;


    }

    public void removeAllCourtBooked(int index){
        while (true) {
            amount -= courtBooked[index].getCharge();
            courtBooked[index] = null;
            if(index == 0)
                break;
            totalCourtBooked--;
            index--;
        }
        totalCourtBooked--;

    }

    public void removeCourtBooked(int index){
        amount -= courtBooked[index].getCharge();

        if (!(index == (totalCourtBooked - 1))) {
            for (int k = index; k < totalCourtBooked - 1; k++) {
                courtBooked[k] = courtBooked[k + 1];
            }
        }
        courtBooked[totalCourtBooked - 1] = null;
        totalCourtBooked--;

    }

    public int getTotalCourtBooked(){
        return totalCourtBooked;
    }

    public void displayBookedCourt(){
        System.out.println(
                "\n                               Booked Court  "+
                        "\nBadminton" +
                        "\n============================================================================" +
                        "\n  CourtCode         TimeInHour           timeOutHour           Charge (RM)"  +
                        "\n----------------------------------------------------------------------------");

        for (int i = 0; i < totalCourtBooked; i++) {
            System.out.println(courtBooked[i].toStringBookedCourt());
        }
    }
    ///////////////////////  END BOOKED COURT   /////////////////////////////////


    ///////////////////////   BEVERAGE ORDER   /////////////////////////////////
    public void addBeverageOrder(Beverage beverageOrder){
        amount += beverageOrder.calculateSubtotal();
        beverageOrdered[totalBeverageOrder++] = beverageOrder;


    }

    public int getTotalBeverageOrder(){
        return totalBeverageOrder;
    }

    public void displayBeverageOrder(){
        System.out.println(
                "\n                               Beverage Ordered" +
                        "\n============================================================================" +
                        "\n  Name                           Quantity           Price          Subtotal" +
                        "\n----------------------------------------------------------------------------");


        for (int i = 0; i < totalBeverageOrder; i++) {
            System.out.println(beverageOrdered[i].toStringBeverageOrder());
        }
    }
    ///////////////////////  END BEVERAGE ORDER   /////////////////////////////////

    public void setTransaction(PaymentTransaction transaction){
        this.transaction = transaction;
    }

    public PaymentTransaction getTransaction(){
        return transaction;
    }

    public double getAmount() {
        return amount;
    }

    public void addAmount(double amount){
        this.amount += amount;
    }

    public void setDISCOUNT(double discount){
        DISCOUNT = discount;
    }

    public double calculateTAX(){
        return amount * TAX;
    }

    public double calculateDiscount(){
        return amount * DISCOUNT;
    }

    public double calculateSubtotal(){
        return amount + calculateTAX();
    }

    public double calculatePayment(){
        return calculateSubtotal() - calculateDiscount();
    }



    public String toString() {
        return  "\n                              Payment Details" +
                "\n----------------------------------------------------------------------------" +
                String.format("\n   Amount                                          RM %.2f", amount) +
                String.format("\n   Tax(5%%)                                         RM %.2f", calculateTAX() ) +
                String.format("\n   Subtotal                                        RM %.2f", calculateSubtotal()) +
                String.format("\n   Discount                                        RM %.2f", calculateDiscount() ) +
                String.format("\n   Grand Total                                     RM %.2f", calculatePayment()) +
                "\n============================================================================";

    }
}

