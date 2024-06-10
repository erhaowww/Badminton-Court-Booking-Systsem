package assignment;

import java.lang.String;
import assignment.datatype.*;

public class Customer {
    private String user_id;
    private String password;
    private Person person;
    private Member membership;


    public Customer(){}

    public Customer(String user_id){
        this.user_id = user_id;
    }

    public Customer (String user_id, String password){
        this.user_id = user_id;
        this.password = password;
    }

    public Customer (String user_id, String password,Person person){
        this.user_id = user_id;
        this.password = password;
        this.person = person;
    }

    public Customer (String user_id, String password,Person person, Member membership){
        this.user_id = user_id;
        this.password = password;
        this.person = person;
        this.membership = membership;
    }

    public Member getMembership(){
        return membership;
    }

    public void setMembership(Member membership){
        this.membership = membership;
    }

    public String getId() {
        return user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void displayCustDetail(){

        System.out.printf("\n\t\t\t\t\t\t\t\tCustomer Details");
        System.out.printf("\n---------------------------------------------------------------------------" );
        System.out.printf("\n|  User Id            :             %s", user_id);
        System.out.printf("\n|  Password           :             %s",password);
        System.out.printf("\n|  Name               :             %s", person.getName());
        System.out.printf("\n|  Email              :             %s", person.getEmail());
        System.out.printf("\n|  Phone              :             %s", person.getPhone());
        if(membership.getType() != null)
            membership.cusMember();
        System.out.printf("\n---------------------------------------------------------------------------");
        System.out.printf("\n\t\t\t\t\t\t\t\t  Address\n                         %s", person.getAddress());
        System.out.printf("\n", person.getAddress());
        System.out.printf("\n===========================================================================");

    }

    public String getPassword() {
        return password;
    }
}









































































































































































































































