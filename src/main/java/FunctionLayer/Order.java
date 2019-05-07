package FunctionLayer;

public class Order {

    private int order_id;
    private String order_date;
    //user_id
    private boolean order_status;
    private String order_comment;
    private int order_roof_angle;
    private String roof_material;
    private int order_length;
    private int order_width;
    private boolean order_shed;
    private int order_shed_length;
    private int order_shed_width;
    private String order_ship_date;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public boolean isOrder_status() {
        return order_status;
    }

    public void setOrder_status(boolean order_status) {
        this.order_status = order_status;
    }

    public String getOrder_comment() {
        return order_comment;
    }

    public void setOrder_comment(String order_comment) {
        this.order_comment = order_comment;
    }

    public int getOrder_roof_angle() {
        return order_roof_angle;
    }

    public void setOrder_roof_angle(int order_roof_angle) {
        this.order_roof_angle = order_roof_angle;
    }

    public String getRoof_material() {
        return roof_material;
    }

    public void setRoof_material(String roof_material) {
        this.roof_material = roof_material;
    }

    public int getOrder_length() {
        return order_length;
    }

    public void setOrder_length(int order_length) {
        this.order_length = order_length;
    }

    public int getOrder_width() {
        return order_width;
    }

    public void setOrder_width(int order_width) {
        this.order_width = order_width;
    }

    public boolean isOrder_shed() {
        return order_shed;
    }

    public void setOrder_shed(boolean order_shed) {
        this.order_shed = order_shed;
    }

    public int getOrder_shed_length() {
        return order_shed_length;
    }

    public void setOrder_shed_length(int order_shed_length) {
        this.order_shed_length = order_shed_length;
    }

    public int getOrder_shed_width() {
        return order_shed_width;
    }

    public void setOrder_shed_width(int order_shed_width) {
        this.order_shed_width = order_shed_width;
    }

    public String getOrder_ship_date() {
        return order_ship_date;
    }

    public void setOrder_ship_date(String order_ship_date) {
        this.order_ship_date = order_ship_date;
    }


    public Order(int order_id, String order_date, boolean order_status, String order_comment, int order_roof_angle, String roof_material, int order_length, int order_width, boolean order_shed, int order_shed_length, int order_shed_width, String order_ship_date) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.order_status = order_status;
        this.order_comment = order_comment;
        this.order_roof_angle = order_roof_angle;
        this.roof_material = roof_material;
        this.order_length = order_length;
        this.order_width = order_width;
        this.order_shed = order_shed;
        this.order_shed_length = order_shed_length;
        this.order_shed_width = order_shed_width;
        this.order_ship_date = order_ship_date;
    }




}
