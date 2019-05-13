package FunctionLayer;

public class Roof {

    private int roofId;
    private String roofDesc;
    private String roofColor;
    private int roofLength;
    private int roofWidth;
    private int roofLenDeck;
    private int roofWidDeck;
    private String roofUnit;
    private double roofPrice;
    private int roofStatus;
    private int roofMenu;

    public Roof() {
    }

    public Roof(int roofId, String roofDesc) {
        this.roofId = roofId;
        this.roofDesc = roofDesc;
    }

    public Roof(int roofId, String roofDesc, String roofColor, int roofLength, int roofWidth,
                int roofLenDeck, int roofWidDeck, String roofUnit, double roofPrice, int roofStatus, int roofMenu) {
        this.roofId = roofId;
        this.roofDesc = roofDesc;
        this.roofColor = roofColor;
        this.roofLength = roofLength;
        this.roofWidth = roofWidth;
        this.roofLenDeck = roofLenDeck;
        this.roofWidDeck = roofWidDeck;
        this.roofUnit = roofUnit;
        this.roofPrice = roofPrice;
        this.roofStatus = roofStatus;
        this.roofMenu = roofMenu;
    }

    public int getRoofId() {
        return roofId;
    }

    public void setRoofId(int roofID) {
        this.roofId = roofId;
    }

    public String getRoofDesc() {
        return roofDesc;
    }

    public void setRoofDesc(String roofDesc) {
        this.roofDesc = roofDesc;
    }

    public String getRoofColor() {
        return roofColor;
    }

    public void setRoofColor(String roofColor) {
        this.roofColor = roofColor;
    }

    public int getRoofLength() {
        return roofLength;
    }

    public void setRoofLength(int roofLength) {
        this.roofLength = roofLength;
    }

    public int getRoofWidth() {
        return roofWidth;
    }

    public void setRoofWidth(int roofWidth) {
        this.roofWidth = roofWidth;
    }

    public int getRoofLenDeck() {
        return roofLenDeck;
    }

    public void setRoofLenDeck(int roofLenDeck) {
        this.roofLenDeck = roofLenDeck;
    }

    public int getRoofWidDeck() {
        return roofWidDeck;
    }

    public void setRoofWidDeck(int roofWidDeck) {
        this.roofWidDeck = roofWidDeck;
    }

    public String getRoofUnit() {
        return roofUnit;
    }

    public void setRoofUnit(String roofUnit) {
        this.roofUnit = roofUnit;
    }

    public double getRoofPrice() {
        return roofPrice;
    }

    public void setRoofPrice(double roofPrice) {
        this.roofPrice = roofPrice;
    }

    public int getRoofStatus() {
        return roofStatus;
    }

    public void setRoofStatus(int roofStatus) {
        this.roofStatus = roofStatus;
    }

    public int getRoofMenu() {
        return roofMenu;
    }

    public void setRoofMenu(int roofMenu) {
        this.roofMenu = roofMenu;
    }

    @Override
    public String toString() {
        return "Roof{" +
                "roofId=" + roofId +
                ", roofDesc='" + roofDesc + '\'' +
                ", roofColor='" + roofColor + '\'' +
                ", roofLength=" + roofLength +
                ", roofWidth=" + roofWidth +
                ", roofLenDeck=" + roofLenDeck +
                ", roofWidDeck=" + roofWidDeck +
                ", roofUnit='" + roofUnit + '\'' +
                ", roofPrice=" + roofPrice +
                ", roofStatus=" + roofStatus +
                ", roofMenu=" + roofMenu +
                '}';
    }
}
