package FunctionLayer;

public class Order_oh {

    private int orderId;
    private String orderDate;
    private int userId;
    private int orderStatus;
    private String orderComment;
    private int orderRoofAngle;
    private int orderRoofMaterial;
    private int orderLength;
    private int orderWidth;
    private int orderShed;
    private int orderShedLength;
    private int orderShedWidth;
    private String orderShipDate;

    public Order_oh(String orderDate, int userId, int orderStatus, String orderComment, int orderRoofAngle, int orderRoofMaterial, int orderLength, int orderWidth, int orderShed, int orderShedLength, int orderShedWidth, String orderShipDate) {
        this.orderDate = orderDate;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderComment = orderComment;
        this.orderRoofAngle = orderRoofAngle;
        this.orderRoofMaterial = orderRoofMaterial;
        this.orderLength = orderLength;
        this.orderWidth = orderWidth;
        this.orderShed = orderShed;
        this.orderShedLength = orderShedLength;
        this.orderShedWidth = orderShedWidth;
        this.orderShipDate = orderShipDate;
    }

    public Order_oh(int orderId, String orderDate, int orderStatus, String orderComment, int orderRoofAngle, int orderRoofMaterial, int orderLength, int orderWidth, int orderShed, int orderShedLength, int orderShedWidth, String orderShipDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderComment = orderComment;
        this.orderRoofAngle = orderRoofAngle;
        this.orderRoofMaterial = orderRoofMaterial;
        this.orderLength = orderLength;
        this.orderWidth = orderWidth;
        this.orderShed = orderShed;
        this.orderShedLength = orderShedLength;
        this.orderShedWidth = orderShedWidth;
        this.orderShipDate = orderShipDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public int getOrderRoofAngle() {
        return orderRoofAngle;
    }

    public int getOrderRoofMaterial() {
        return orderRoofMaterial;
    }

    public int getOrderLength() {
        return orderLength;
    }

    public int getOrderWidth() {
        return orderWidth;
    }

    public int getOrderShed() {
        return orderShed;
    }

    public int getOrderShedLength() {
        return orderShedLength;
    }

    public int getOrderShedWidth() {
        return orderShedWidth;
    }

    public String getOrderShipDate() {
        return orderShipDate;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public void setOrderRoofAngle(int orderRoofAngle) {
        this.orderRoofAngle = orderRoofAngle;
    }

    public void setOrderRoofMaterial(int orderRoofMaterial) {
        this.orderRoofMaterial = orderRoofMaterial;
    }

    public void setOrderLength(int orderLength) {
        this.orderLength = orderLength;
    }

    public void setOrderWidth(int orderWidth) {
        this.orderWidth = orderWidth;
    }

    public void setOrderShed(int orderShed) {
        this.orderShed = orderShed;
    }

    public void setOrderShedLength(int orderShedLength) {
        this.orderShedLength = orderShedLength;
    }

    public void setOrderShedWidth(int orderShedWidth) {
        this.orderShedWidth = orderShedWidth;
    }

    public void setOrderShipDate(String orderShipDate) {
        this.orderShipDate = orderShipDate;
    }

    @Override
    public String toString() {
        return orderId +" " + orderDate + " " + userId +" "+ orderStatus +" "+ orderComment +
                " " + orderRoofAngle + " "+ orderRoofMaterial +" " + orderLength +" " + orderWidth +
                " " + orderShed +" " + orderShedLength +" " + orderShedWidth +" " + orderShipDate;
    }
}
