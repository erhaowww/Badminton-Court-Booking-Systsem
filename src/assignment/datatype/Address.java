package assignment.datatype;
public class Address {
    private String streetAddress;
    private String city;
    private int postCode;
    private String state;


    //non-arg constructor
    public Address(){

    }

    public Address(String streetAddress,String city,int postCode,String state){
        this.streetAddress=streetAddress;
        this.city=city;
        this.postCode=postCode;
        this.state=state;
    }

    public String getCity() {
        return city;
    }
    public int getPostCode() {
        return postCode;
    }
    public String getState() {
        return state;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String toString(){

        return
                String.format("\n|  Street Addresss    :             %s", streetAddress) +
                        String.format("\n|  City               :             %s",city) +
                        String.format("\n|  Post Code          :             %s", postCode) +
                        String.format("\n|  State              :             %s", state);
    }
}

