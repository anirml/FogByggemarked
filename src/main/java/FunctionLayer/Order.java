package FunctionLayer;

public class Order {

    private int orderId;
    private String userId;
    private String orderDate;
    private String orderStatus;
    private String orderComment;
    private String orderRoofAngle;
    private String orderRoofMaterial;
    private String orderLength;
    private String orderWidth;
    private String orderShed;
    private String orderShedLength;
    private String orderShedWidth;
    private String orderShipDate;

    private String userName;
    private String userEmail;
    private String userAddress;
    private String userZipcode;
    private String userCity;
    private String userPhone;
    private String userType;

    public Order(String userId, String orderStatus, String orderComment, String orderRoofAngle,
                 String orderRoofMaterial, String orderLength, String orderWidth, String orderShed,
                 String orderShedLength, String orderShedWidth) {
        //this.orderId = orderId;
        //this.orderDate = orderDate;
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
        //this.orderShipDate = orderShipDate;
    }

    public Order(int orderId,String userId, String orderDate, String orderStatus, String orderComment,
                 String orderRoofAngle, String orderRoofMaterial, String orderLength,
                 String orderWidth, String orderShed, String orderShedLength, String orderShedWidth,
                 String orderShipDate, String userName, String userEmail, String userAddress,
                 String userZipcode, String userCity, String userPhone, String userType) {
        this.orderId = orderId;
        this.userId = userId;
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
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userZipcode = userZipcode;
        this.userCity = userCity;
        this.userPhone = userPhone;
        this.userType = userType;
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

    public String getOrderRoofMaterial() {
        return orderRoofMaterial;
    }

    public void setOrderRoofMaterial(String orderRoofMaterial) {
        this.orderRoofMaterial = orderRoofMaterial;
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

    public String getOrderShed() { return orderShed; }

    public void setOrderShed(String orderShed) { this.orderShed = orderShed; }

    public String getUserId() { return userId; }

    public String getOrderStatus() { return orderStatus; }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserZipcode() {
        return userZipcode;
    }

    public void setUserZipcode(String userZipcode) {
        this.userZipcode = userZipcode;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
