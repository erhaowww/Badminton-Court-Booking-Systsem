package assignment.pay;

public class CreditCard extends PaymentTransaction {
    private String nameOnCard;
    private String cardNo;
    private String pinNum;

    public CreditCard(){}

    public CreditCard(String transactionType, String bankName, String nameOnCard, String cardNo, String pinNum){
        super(transactionType, bankName);
        this.nameOnCard = nameOnCard;
        this.cardNo = cardNo;
        this.pinNum = pinNum;
    }

    public String getCardNo() {
        return cardNo;
    }


    public void displayDetail(){
        System.out.println(String.format("   Payment Method   ==>                      %s", super.getTransactionType()));
        System.out.println(String.format("   Bank Name                                 %s", super.getBankName()));
        System.out.println(String.format("   Last 4-digit of Card No                   %s%s", "XXXX-XXXX-XXXX-",cardNo.substring(15)));
        System.out.println("____________________________________________________________________________");
        System.out.println("____________________________________________________________________________");
    }
}
