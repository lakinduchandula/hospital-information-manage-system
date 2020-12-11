package sample.module;

public class DispatchPostalMail extends ReceivedPostalMail{
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

    private void setToName(java.lang.String s) {
    }
    private void setToAddress(java.lang.String s) {
    }
    private void setFromName(java.lang.String s) {
    }

    //Getters and Setters
        public String getToName(){
            return this.toName;
        }

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

    }

