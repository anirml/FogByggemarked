package FunctionLayer;

public class FogException extends Exception {

    private String shortMessage;

    public String getShortMessage() {
        return shortMessage;
    }

    public FogException(String msg, String shortMessage) {
        super(msg);
        this.shortMessage = shortMessage;
    }

    public FogException(String msg) {
        super(msg);
        this.shortMessage = "";
    }
    

}
