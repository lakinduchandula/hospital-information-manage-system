package sample.model;

public class DispatchPostalMail extends PostalMail{
        private String toName;
        private String toAddress;
        private String fromName;

        //Variable Constructor
        public DispatchPostalMail(String toName, String toAddress, String fromName){
           this.setToName(toName);
           this.setToAddress(toAddress);
           this.setFromName(fromName);
        }
        //Default Constructor
        public DispatchPostalMail(){
            this.setToName("");
            this.setToAddress("");
            this.setFromName("");
        }

        //Getters and Setters
        public String getToName(){ return this.toName; }

        public String getToAddress(){
            return this.toAddress;
        }

        public String getFromName(){
            return this.fromName;
        }

        public void setFromName(String toName) {
            this.toName = toName;
        }

        public void setToAddress(String toAddress) {
            this.toAddress = toAddress;
        }

        public void setToName(String fromName){
            this.fromName = fromName;
        }

    @Override
    public String toString() {
        return super.toString() + String.format("~%s~%s~%s", getToName(), getToAddress(),getFromName()); }

    }

