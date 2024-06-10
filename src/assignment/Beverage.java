package assignment;

public class Beverage {
    private String drinksName;
    private double price;
    private int quantity;

    public Beverage(){

    }

    public Beverage(String drinksName, double price){ // for display drinks sell
        this.drinksName = drinksName;
        this.price = price;
    }

    public Beverage(String drinksName, double price,int quantity){ // for order use
        this.drinksName = drinksName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDrinksName(){
        return drinksName;
    }

    public double getPrice(){
        return price;
    }

    public double calculateSubtotal(){
        return (price * quantity);
    }

    public String toStringBeverageOrder(){
        return String.format(" %-20s %10s %4d %12s RM %5.2f %5s RM %5.2f", drinksName, "", quantity, "", price,"", calculateSubtotal());
    }

    public String toStringDrinksSell(){
        return String.format(" %-20s %15s RM %5.2f      |",drinksName,"",price);
    }
}
