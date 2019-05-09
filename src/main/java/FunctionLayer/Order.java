package FunctionLayer;

import java.util.Date;

public class Order {

    private int orderId;
    private String orderDate;
    //user_id
    private String orderStatus;
    private String orderComment;
    private String orderRoofAngle;
    private String roofMaterial;
    private String orderLength;
    private String orderWidth;
    private String orderShed;
    private String orderShedLength;
    private String orderShedWidth;
    private String orderShipDate;

    public Order(String  orderStatus, String orderComment, String orderRoofAngle, String roofMaterial, String orderLength,
                 String orderWidth, String orderShed, String orderShedLength, String orderShedWidth) {
        //this.orderId = orderId;
        //this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderComment = orderComment;
        this.orderRoofAngle = orderRoofAngle;
        this.roofMaterial = roofMaterial;
        this.orderLength = orderLength;
        this.orderWidth = orderWidth;
        this.orderShed = orderShed;
        this.orderShedLength = orderShedLength;
        this.orderShedWidth = orderShedWidth;
        //this.orderShipDate = orderShipDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getOrderRoofAngle() {
        return orderRoofAngle;
    }

    public void setOrderRoofAngle(String orderRoofAngle) {
        this.orderRoofAngle = orderRoofAngle;
    }

    public String getRoofMaterial() {
        return roofMaterial;
    }

    public void setRoofMaterial(String roofMaterial) {
        this.roofMaterial = roofMaterial;
    }

    public String getOrderLength() {
        return orderLength;
    }

    public void setOrderLength(String orderLength) {
        this.orderLength = orderLength;
    }

    public String getOrderWidth() {
        return orderWidth;
    }

    public void setOrderWidth(String orderWidth) {
        this.orderWidth = orderWidth;
    }

    public String  isOrderShed() {
        return orderShed;
    }

    public void setOrderShed(String orderShed) {
        this.orderShed = orderShed;
    }

    public String getOrderShedLength() {
        return orderShedLength;
    }

    public void setOrderShedLength(String orderShedLength) {
        this.orderShedLength = orderShedLength;
    }

    public String getOrderShedWidth() {
        return orderShedWidth;
    }

    public void setOrderShedWidth(String orderShedWidth) {
        this.orderShedWidth = orderShedWidth;
    }

    public String getOrderShipDate() {
        return orderShipDate;
    }

    public void setOrderShipDate(String orderShipDate) {
        this.orderShipDate = orderShipDate;
    }
}
