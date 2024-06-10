package assignment.datatype;
public class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;

    public Person(){

    }

    public Person(String name,Address address,String email,String phone){
        this.name=name;
        this.address=address;
        this.email=email;
        this.phone=phone;
    }
    public Address getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }



    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Person Address(){
        return Address();
    }
}

