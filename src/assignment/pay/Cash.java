package assignment.pay;

public class Cash extends PaymentTransaction {
    private double cashTendered;
    private double cashBack;

    public Cash(){}

    public Cash(String transactionType, String bankName, double cashTendered,double cashBack){
        super(transactionType, bankName);
        this.cashTendered = cashTendered;
        this.cashBack = cashBack;
    }


    public void displayDetail(){
        System.out.println(String.format("   Payment Method   ==>                          %s", super.getTransactionType()));
        System.out.println(String.format("   Cash Tendered                                 RM %.2f", cashTendered));
        System.out.println(String.format("   CashBack                                      RM %.2f", cashBack));
        System.out.println("____________________________________________________________________________");
        System.out.println("____________________________________________________________________________");
    }


}
