package assignment.datatype;

public class Member {
    private int memberID = 3013;
    private String type;
    private int duration;
    private double price;
    private double discount;    //in percentage (convert to decimal in payment object)
    boolean buyNow = false;


    public Member(){}


    public Member(String type,int duration,double price,double discount){
        this.type=type;
        this.duration=duration;
        this.price = price;
        this.discount = discount;
        memberID++;
    }

    public Member(int memberID,String type,int duration,double price,double discount){
        this.type=type;
        this.duration=duration;
        this.price = price;
        this.discount = discount;
        this.memberID = memberID;
    }

    public int getDuration() {
        return duration;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getType() {
        return type;
    }

    public double getPrice(){
        return price;
    }

    public double getDiscount(){
        return discount;
    }

    public void setBuyNow(boolean a){
        buyNow = a;
    }

    public boolean getBuyNow(){
        return buyNow;
    }

    public String toStringMemberTypeSell(){
        return  String.format("\nMember Type      : %s",type) +
                String.format("\nDuration(Month)  : %d",duration) +
                String.format("\nPrice            : RM %.2f",price) +
                String.format("\nDiscount         : %.0f%%",discount) ;
    }

    public void cusMember(){
        System.out.printf("\n|  Member Type        :             %s", type);
        System.out.printf("\n|  Duration(Month)    :             %d", duration );
        System.out.printf("\n|  Discount           :             %.0f%%", discount);

    }

    public String toStringMember(){
        if(buyNow) {
            buyNow = false;
            return String.format("\n\nMembership : %s (+ RM %.2f)", type, price);
        }

        return String.format("%30s Membership : %s ", "", type);

    }

    public void displayMemberPurchase(){
        if(buyNow) {
            System.out.print("\n                                 Membership  "+
                             "\n============================================================================" +
                             "\n   Type        Duration(Month)           Discount(%)           Price (RM)"  +
                             "\n----------------------------------------------------------------------------");

            System.out.printf("\n %10s %2s %10d %9s %10.0f %15s RM %.2f\n",type,"",duration,"",discount,"",price);
        }



    }

}
