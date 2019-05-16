package FunctionLayer;

public class LoginSampleException extends Exception {

    private String shortMessage;

    public String getShortMessage() {
        return shortMessage;
    }

    public LoginSampleException(String msg, String shortMessage) {
        super(msg);
        this.shortMessage = shortMessage;
    }

    public LoginSampleException(String msg) {
        super(msg);
    }
    

}
