package assignment.pay;

public class OnlineBanking extends PaymentTransaction {
    private String onlineBankingAccount;
    private String onlineBankingPassword;
    private int referenceNum = 48510;
    private String reference;
    private String pacNo;


    public OnlineBanking(){}

    public OnlineBanking(String transactionType, String bankName, String onlineBankingAccount, String onlineBankingPassword, String reference, String pacNo){
        super(transactionType, bankName);
        this.onlineBankingAccount = onlineBankingAccount;
        this.onlineBankingPassword = onlineBankingPassword;
        this.reference = reference;
        this.pacNo = pacNo;
        referenceNum++;

    }

    public int getReferenceNum(){
        return referenceNum;
    }

    public void displayDetail(){
        System.out.println(String.format("   Payment Method   ==>                       %s", super.getTransactionType()));
        System.out.println(String.format("   Bank Name                                  %s", super.getBankName()));
        System.out.println(String.format("   Reference Number                           %s", referenceNum));
        System.out.println(String.format("   Recipient's reference                      %s", reference));
        System.out.println(String.format("   PAC No                                     %s%s", "XXX", pacNo.substring(3)));
        System.out.println("____________________________________________________________________________");
        System.out.println("____________________________________________________________________________");

    }



}
