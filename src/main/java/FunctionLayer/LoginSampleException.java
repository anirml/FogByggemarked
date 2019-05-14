package FunctionLayer;

/**
 * The purpose of LoginSampleException is to...
 * @author kasper
 */
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
