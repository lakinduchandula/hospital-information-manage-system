package sample.model;

public class  ReceivedPostalMail extends PostalMail{
    private String fromName;
    private String fromAddress;
    private String toName;



    //Variable Constructor
    public ReceivedPostalMail(String fromName, String fromAddress, String toName){
        this.setFromName(fromName);
        this.setFromAddress(fromAddress);
        this.setToName(toName);
    }
    //Default Constructor
    public ReceivedPostalMail(){
        this.setFromName("");
        this.setFromAddress("");
        this.setToName("");
    }

    //Getters and Setters
    public String getFromName(){
        return this.fromName;
    }

    public String getFromAddress(){
        return this.fromAddress;
    }

    public String getToName(){
        return this.toName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public void setToName(String toName){
        this.toName = toName;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("~%s~%s~%s", getFromName(),getFromAddress(),getToName()); }
}
